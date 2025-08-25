package com.club.subject.common.enums;

import lombok.Getter;

/**
 * packageName com.club.subject.common.enums
 *
 * @author zh
 * @version 1.0
 * @className IsDeleteFlagEnum
 * @date 2025-08-19
 * @description TODO 题目类型枚举
 */
@Getter
public enum SubjectInfoTypeEnum {
    RADIO(1, "单选"),
    MULTIPLE(2, "多选"),
    JUDGE(3, "判断"),
    BRIEF(4, "简答"),
    ;

    private final int type;
    private final String desc;

    SubjectInfoTypeEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static SubjectInfoTypeEnum getType(int typeVal){
        for (SubjectInfoTypeEnum item : SubjectInfoTypeEnum.values()) {
            if(item.type == typeVal){
                return item;
            }
        }
        return null;
    }

}
