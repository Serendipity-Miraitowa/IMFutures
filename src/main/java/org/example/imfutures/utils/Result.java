package org.example.imfutures.utils;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "响应信息实体")
public class Result {

    @Schema(name = "响应状态", description = "响应状态", required = true, example = "true")
    private boolean success;

    @Schema(name = "响应消息", description = "响应消息", required = true, example = "获取成功")
    private String messages;

    @Schema(name = "响应数据", description = "响应数据", required = true, example = "[{uid:1,username:'李白'}]")
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
