package com.club.subject.domain.handler.subject;

import com.club.subject.common.enums.SubjectInfoTypeEnum;
import com.club.subject.domain.entity.SubjectInfoBO;

/**
 * packageName com.club.subject.domain.handler
 *
 * @author zh
 * @version 1.0
 * @className SubjectTypeInfoHandler
 * @date 2025-08-24
 * @description TODO 题目类型
 */

public interface SubjectTypeHandler {
    /**
     * 枚举类型识别
     * @return
     */
    SubjectInfoTypeEnum getHandlerType();

    // 新增
    void add(SubjectInfoBO subjectInfoBO);

}
