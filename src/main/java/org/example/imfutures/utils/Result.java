package org.example.imfutures.utils;


import lombok.Data;

@Data
public class Result {
    private boolean success;
    private String messages;
    private Object data;

    public Result(boolean success, String messages, Object data) {
        this.success = success;
        this.messages = messages;
        this.data = data;
    }

    public Result(boolean success, String messages) {
        this.success = success;
        this.messages = messages;
    }

    public Result() {
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean aTrue) {
        success = aTrue;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
