package love.tanyiqu.dto;

public enum ResponseCode {
    SUCCESS(200),
    ERROR(401);

    private int code;

    public int getCode() {
        return code;
    }

    ResponseCode(int code) {
        this.code = code;
    }
}
