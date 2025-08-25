package com.club.subject.domain.convert;

import com.club.subject.domain.entity.SubjectCategoryBO;
import com.club.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * packageName com.club.subject.domain.convert
 *
 * @author zh
 * @version 1.0
 * @className SubjectCategoryConverter
 * @date 2025-08-17
 * @description TODO 对象转换器
 */
@Mapper
public interface SubjectCategoryConverter {
    SubjectCategoryConverter INSTANCE = Mappers.getMapper(SubjectCategoryConverter.class);

    SubjectCategory convertBoToCategory(SubjectCategoryBO subjectCategoryBO);

    List<SubjectCategoryBO> convertCategoryListToCategoryBoList(List<SubjectCategory> list);

}
