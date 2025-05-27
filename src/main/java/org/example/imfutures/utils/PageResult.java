package org.example.imfutures.utils;

public class PageResult {
    private boolean isTrue;
    private String message;
    private Object data;

    public PageResult(boolean isTrue, String message, Object data) {
        this.isTrue = isTrue;
        this.message = message;
        this.data = data;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "isTrue=" + isTrue +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
