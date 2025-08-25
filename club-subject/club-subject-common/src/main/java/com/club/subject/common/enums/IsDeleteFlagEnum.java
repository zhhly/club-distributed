package com.club.subject.common.enums;

import lombok.Getter;

/**
 * packageName com.club.subject.common.enums
 *
 * @author zh
 * @version 1.0
 * @className IsDeleteFlagEnum
 * @date 2025-08-19
 * @description TODO 删除状态枚举
 */
@Getter
public enum IsDeleteFlagEnum {
    DELETE(1, "已删除"),
    UN_DELETE(0, "未删除"),
    ;

    private final int code;
    private final String msg;

    IsDeleteFlagEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static IsDeleteFlagEnum getCode(int codeVal){
        for (IsDeleteFlagEnum item : IsDeleteFlagEnum.values()) {
            if(item.code == codeVal){
                return item;
            }
        }
        return null;
    }

}
