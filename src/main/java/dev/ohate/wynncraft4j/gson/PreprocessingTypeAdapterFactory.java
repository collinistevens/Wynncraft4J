package dev.ohate.wynncraft4j.gson;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.UnaryOperator;

public class PreprocessingTypeAdapterFactory implements TypeAdapterFactory {

    private final Set<Class<?>> targets;
    private final UnaryOperator<JsonElement> processor;

    public PreprocessingTypeAdapterFactory(Set<Class<?>> targets, UnaryOperator<JsonElement> processor) {
        this.targets = targets;
        this.processor = processor;
    }

    public PreprocessingTypeAdapterFactory(Class<?> target, UnaryOperator<JsonElement> processor) {
        this(new HashSet<>(Collections.singletonList(target)), processor);
    }

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();

        boolean matches = this.targets.stream().anyMatch(target -> target.isAssignableFrom(rawType));

        if (!matches) {
            return null;
        }

        TypeAdapter<T> delegate = gson.getDelegateAdapter(this, typeToken).nullSafe();

        return new TypeAdapter<T>() {
            @Override
            public void write(JsonWriter out, T value) throws java.io.IOException {
                delegate.write(out, value);
            }

            @Override
            public T read(JsonReader in) {
                JsonElement jsonElement = JsonParser.parseReader(in);
                JsonElement modified = processor.apply(jsonElement);
                return delegate.fromJsonTree(modified);
            }
        };
    }
}
