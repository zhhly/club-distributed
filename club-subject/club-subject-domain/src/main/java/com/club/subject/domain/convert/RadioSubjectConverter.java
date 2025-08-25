package com.club.subject.domain.convert;

import com.club.subject.domain.entity.SubjectAnswerBO;
import com.club.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * packageName com.club.subject.domain.convert
 *
 * @author zh
 * @version 1.0
 * @className RadioSubjectConverter
 * @date 2025-08-17
 * @description TODO 单选题对象转换器
 */
@Mapper
public interface RadioSubjectConverter {
    RadioSubjectConverter INSTANCE = Mappers.getMapper(RadioSubjectConverter.class);

    SubjectRadio convertBoToEntity(SubjectAnswerBO subjectAnswerBO);

}
