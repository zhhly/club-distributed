package com.club.subject.common.entity;

import com.club.subject.common.enums.AppExceptionCodeMsg;
import lombok.Data;

/**
 * <p>
 * Resp类: 统一返回结果类
 * </p>
 *
 * @author zh
 * @date 2025-06-26 22:39
 */
@Data
public class Resp<T> {
    private boolean success;
    private int code;
    private String msg;
    private T data;

    public Resp(Boolean success, int code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Resp<T> success(T data) {
        return new Resp<T>(true, AppExceptionCodeMsg.SUCCESS.getCode(), AppExceptionCodeMsg.SUCCESS.getMsg(), data);
    }
    // 成功返回
    public static <T> Resp<T> success(String msg, T data) {
        return new Resp(true, AppExceptionCodeMsg.SUCCESS.getCode(), msg, data);
    }

    // 异常错误返回
    public static <T> Resp error(AppExceptionCodeMsg appExceptionCodeMsg) {
        return new Resp(false, appExceptionCodeMsg.getCode(), appExceptionCodeMsg.getMsg(), new int[]{});
    }

    public static <T> Resp error(int code, String msg) {
        return new Resp(false, code, msg, new int[]{});
    }
}
