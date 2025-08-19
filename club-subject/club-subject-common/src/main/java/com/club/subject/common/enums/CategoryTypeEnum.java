package com.club.subject.common.enums;

import lombok.Getter;

/**
 * packageName com.club.subject.common.enums
 *
 * @author zh
 * @version 1.0
 * @className IsDeleteFlagEnum
 * @date 2025-08-19
 * @description TODO 分类类型枚举
 */
@Getter
public enum CategoryTypeEnum {
    PRIMARY("1", "岗位大类"),
    SECOND("2", "二级分类"),
    ;

    private final String type;
    private final String decs;

    CategoryTypeEnum(String type, String decs) {
        this.type = type;
        this.decs = decs;
    }

    public static CategoryTypeEnum getType(String typeVal){
        for (CategoryTypeEnum item : CategoryTypeEnum.values()) {
            if(typeVal.equals(item.type)){
                return item;
            }
        }
        return null;
    }

}
