package com.club.subject.common.enums;

import lombok.Getter;

/**
 * @author: 朱鹏
 * @since: 2025-06-26 H O U R : {HOUR}:HOUR:{MINUTE}
 * @description: 枚举类：错误信息提示【业务异常的枚举】
 */
@Getter
public enum AppExceptionCodeMsg {
    SUCCESS(200, "请求成功"),
    BAD_REQUEST(400, "请求参数错误"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "资源不存在"),
    INTERNAL_ERROR(500, "服务器内部错误"),
    SERVICE_UNAVAILABLE(503, "服务不可用"),


    // 题目分类 异常码
    ADD_FAIL(500, "新增分类失败"),
    UPDATE_FAIL(500, "修改分类失败"),
    DELETE_FAIL(500, "删除分类失败"),
    QUERY_FAIL(500, "查询失败"),


    ;

    private final int code;
    private final String msg;

    AppExceptionCodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
