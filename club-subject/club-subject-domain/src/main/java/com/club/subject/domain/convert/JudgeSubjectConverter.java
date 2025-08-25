package com.club.subject.domain.convert;

import com.club.subject.domain.entity.SubjectAnswerBO;
import com.club.subject.infra.basic.entity.SubjectJudge;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * packageName com.club.subject.domain.convert
 *
 * @author zh
 * @version 1.0
 * @className JudgeSubjectConverter
 * @date 2025-08-24
 * @description TODO 判断题对象转换器
 */
@Mapper
public interface JudgeSubjectConverter {
    JudgeSubjectConverter INSTANCE = Mappers.getMapper(JudgeSubjectConverter.class);

    SubjectJudge convertBoToEntity(SubjectAnswerBO subjectAnswerBO);

}