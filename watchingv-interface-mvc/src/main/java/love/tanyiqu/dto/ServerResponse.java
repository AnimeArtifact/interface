package love.tanyiqu.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 封装结果类
 *
 * @param <T> 结果
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse<T> {
    private Integer status;
    private T data = null;
    private String msg;

    ServerResponse() {
    }

    // 返回一个成功的response
    public static <T> ServerResponse<T> createSuccess(String msg, T data) {
        ServerResponse<T> successResponse = new ServerResponse<T>();
        successResponse.setStatus(ResponseCode.SUCCESS.getCode());
        successResponse.setMsg(msg);
        successResponse.setData(data);
        return successResponse;
    }

    // 返回一个失败的response
    public static <T> ServerResponse<T> createError(String errorMsg) {
        ServerResponse<T> errorResponse = new ServerResponse<T>();
        errorResponse.setStatus(ResponseCode.ERROR.getCode());
        errorResponse.setMsg(errorMsg);
        return errorResponse;
    }

    @Override
    public String toString() {
        return "ServerResult{" +
                "status=" + status +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
