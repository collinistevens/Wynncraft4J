package dev.ohate.wynncraft4j.exception;

public class WynncraftException extends RuntimeException {

    private final String error;
    private final String detail;
    private final int code;

    private String url;

    public WynncraftException(int code, String error, String detail) {
        super(detail);
        this.error = error;
        this.detail = detail;
        this.code = code;
    }

    public String getError() {
        return this.error;
    }

    public String getDetail() {
        return this.detail;
    }

    public int getCode() {
        return this.code;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
