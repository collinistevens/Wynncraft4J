package dev.ohate.wynncraft4j.response;

import lombok.Data;
import org.jetbrains.annotations.Nullable;

@Data
public class WynnResponse<T> {

    private final boolean success;
    private final int code;

    @Nullable
    private final T data;
    @Nullable
    private final String error;
    @Nullable
    private final Object metadata;

    public static <T> WynnResponse<T> success(int code, T data) {
        return new WynnResponse<>(true, code, data, null, null);
    }

    public static <T> WynnResponse<T> error(int code, String error) {
        return new WynnResponse<>(false, code, null, error, null);
    }

    public static <T> WynnResponse<T> error(int code, String error, Object metadata) {
        return new WynnResponse<>(false, code, null, error, metadata);
    }

}
