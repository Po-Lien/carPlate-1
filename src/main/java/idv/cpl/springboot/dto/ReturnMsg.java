package idv.cpl.springboot.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.stereotype.Component;

@Component
public class ReturnMsg<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer returnCode;
    private String msg;
    private Object data;

    public ReturnMsg(ReturnEnum type) {
        this.returnCode = type.getCode();
        this.msg = type.getMessage();
    }

    public ReturnMsg(ReturnEnum type, T data) {
        this.returnCode = type.getCode();
        this.msg = type.getMessage();
        this.data = data;
    }

    public ReturnMsg(ReturnEnum type, String msg, T data) {
        this.returnCode = type.getCode();
        if (msg == null || "".equals(msg)) {
            msg = type.getMessage();
        }
        this.msg = msg;
        this.data = data;
    }

    public static ReturnMsg success() {
        return new ReturnMsg(ReturnEnum.SUCCESS);
    }

    public static <T> ReturnMsg<T> success(ReturnEnum typeEnum) {
        return new ReturnMsg(typeEnum);
    }

    public static <T> ReturnMsg<T> success(T data) {
        return new ReturnMsg(ReturnEnum.SUCCESS, data);
    }

    public static <T> ReturnMsg<T> success(ReturnEnum typeEnum, T data) {
        return new ReturnMsg(typeEnum, data);
    }

    public static <T> ReturnMsg<T> success(ReturnEnum typeEnum, String msg, T data) {
        return new ReturnMsg(typeEnum, msg, data);
    }

    public static ReturnMsg error() {
        return new ReturnMsg(ReturnEnum.ERROR);
    }

    public static <T> ReturnMsg<T> error(ReturnEnum typeEnum) {
        return new ReturnMsg(typeEnum);
    }

    public static <T> ReturnMsg<T> error(T data) {
        return new ReturnMsg(ReturnEnum.ERROR, data);
    }

    public static <T> ReturnMsg<T> error(ReturnEnum typeEnum, T data) {
        return new ReturnMsg(typeEnum, data);
    }

    public static <T> ReturnMsg<T> error(ReturnEnum typeEnum, String msg, T data) {
        return new ReturnMsg(typeEnum, msg, data);
    }

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).append("returnCode", getReturnCode())
                .append("msg", getMsg()).append("data", getData()).toString();
    }
}
