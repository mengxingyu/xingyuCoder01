package xingyu.constant;

/**
 * @Package: xingyu.constant
 * @ClassName: ResponseCode
 * @Author: mengxingyu
 * @Description:
 * @Date: 2020/8/14 11:18
 */
public enum ResponseCode {
    ILLEGAL_ARGUMENT(100,"请求不合法"),
    REPETITIVE_OPERATION(10001, "请勿重复操作"),
    SUCCESS(0, "操作成功"),
    ERROR(1, "操作失败"),
    SERVER_ERROR(500, "服务器异常");

    private String msg;
    private int code;
    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
