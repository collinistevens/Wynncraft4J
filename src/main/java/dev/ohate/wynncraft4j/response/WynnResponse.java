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

}
