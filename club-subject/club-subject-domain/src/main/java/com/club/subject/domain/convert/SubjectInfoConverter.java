package com.club.subject.domain.convert;

import com.club.subject.domain.entity.SubjectCategoryBO;
import com.club.subject.domain.entity.SubjectInfoBO;
import com.club.subject.infra.basic.entity.SubjectCategory;
import com.club.subject.infra.basic.entity.SubjectInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * packageName com.club.subject.domain.convert
 *
 * @author zh
 * @version 1.0
 * @className SubjectInfoConverter
 * @date 2025-08-17
 * @description TODO 对象转换器
 */
@Mapper
public interface SubjectInfoConverter {
    SubjectInfoConverter INSTANCE = Mappers.getMapper(SubjectInfoConverter.class);

    SubjectInfo convertBoToInfo(SubjectInfoBO subjectInfoBO);

    List<SubjectCategoryBO> convertCategoryListToCategoryBoList(List<SubjectCategory> list);

}
