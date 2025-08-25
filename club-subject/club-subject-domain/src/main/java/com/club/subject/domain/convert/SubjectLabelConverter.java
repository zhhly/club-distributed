package com.club.subject.domain.convert;

import com.club.subject.domain.entity.SubjectLabelBO;
import com.club.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * packageName com.club.subject.domain.convert
 *
 * @author zh
 * @version 1.0
 * @className SubjectLabelConverter
 * @date 2025-08-17
 * @description TODO 对象转换器
 */
@Mapper
public interface SubjectLabelConverter {
    SubjectLabelConverter INSTANCE = Mappers.getMapper(SubjectLabelConverter.class);

    SubjectLabel convSubjectLabel(SubjectLabelBO SubjectLabelBO);

    List<SubjectLabelBO> subjectLabeSubjectLabelBoList(List<SubjectLabel> list);

}
