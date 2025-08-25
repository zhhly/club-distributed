package com.club.subject.application.convert;

import com.club.subject.application.dto.SubjectInfoDTO;
import com.club.subject.domain.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

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
public interface SubjectInfoDTOConverter {
    SubjectInfoDTOConverter INSTANCE = Mappers.getMapper(SubjectInfoDTOConverter.class);

    SubjectInfoBO convertInfoDTOToInfoBo(SubjectInfoDTO subjectInfoDTO);

}
