package com.club.subject.domain.convert;

import com.club.subject.domain.entity.SubjectAnswerBO;
import com.club.subject.infra.basic.entity.SubjectMultiple;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * packageName com.club.subject.domain.convert
 *
 * @author zh
 * @version 1.0
 * @className MultipleSubjectConverter
 * @date 2025-08-24
 * @description TODO 多选题对象转换器
 */
@Mapper
public interface MultipleSubjectConverter {
    MultipleSubjectConverter INSTANCE = Mappers.getMapper(MultipleSubjectConverter.class);

    SubjectMultiple convertBoToEntity(SubjectAnswerBO subjectAnswerBO);

}