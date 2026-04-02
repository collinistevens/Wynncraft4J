package dev.ohate.wynncraft4j.response;

import org.jetbrains.annotations.Nullable;

public class WynnResponse<T> {

    private final boolean success;
    private final int code;
    private final T data;

    private final String error;
    private final Object metadata;

    public WynnResponse(boolean success, int code, T data, String error, Object metadata) {
        this.success = success;
        this.code = code;
        this.data = data;
        this.error = error;
        this.metadata = metadata;
    }

    public static <T> WynnResponse<T> success(int code, T data) {
        return new WynnResponse<>(true, code, data, null, null);
    }

    public static <T> WynnResponse<T> error(int code, String error) {
        return new WynnResponse<>(false, code, null, error, null);
    }

    public static <T> WynnResponse<T> error(int code, String error, Object metadata) {
        return new WynnResponse<>(false, code, null, error, metadata);
    }

    public boolean isSuccess() {
        return this.success;
    }

    public int getCode() {
        return this.code;
    }

    @Nullable
    public T getData() {
        return this.data;
    }

    @Nullable
    public String getError() {
        return this.error;
    }

    @Nullable
    public Object getMetadata() {
        return this.metadata;
    }

}
