package com.club.subject.application.convert;

import com.club.subject.application.dto.SubjectAnswerDTO;
import com.club.subject.domain.entity.SubjectAnswerBO;
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
public interface SubjectAnswerDTOConverter {
    SubjectAnswerDTOConverter INSTANCE = Mappers.getMapper(SubjectAnswerDTOConverter.class);

    SubjectAnswerBO convertAnswerDTOToInfoBo(SubjectAnswerDTO subjectAnswerDTO);
    List<SubjectAnswerBO> convertListDTOToInfoBo(List<SubjectAnswerDTO> subjectAnswerDTOList);

}
