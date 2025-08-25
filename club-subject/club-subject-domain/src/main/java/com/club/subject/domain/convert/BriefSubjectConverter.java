package com.club.subject.domain.convert;

import com.club.subject.domain.entity.SubjectInfoBO;
import com.club.subject.infra.basic.entity.SubjectBrief;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * packageName com.club.subject.domain.convert
 *
 * @author zh
 * @version 1.0
 * @className BriefSubjectConverter
 * @date 2025-08-24
 * @description TODO 简答题对象转换器
 */
@Mapper
public interface BriefSubjectConverter {
    BriefSubjectConverter INSTANCE = Mappers.getMapper(BriefSubjectConverter.class);

    SubjectBrief convertBoToEntity(SubjectInfoBO subjectInfoBO);

}