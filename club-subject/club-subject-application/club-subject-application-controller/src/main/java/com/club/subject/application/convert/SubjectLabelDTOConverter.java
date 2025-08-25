package com.club.subject.application.convert;

import com.club.subject.application.dto.SubjectLabelDTO;
import com.club.subject.domain.entity.SubjectLabelBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * packageName com.club.subject.domain.convert
 *
 * @author zh
 * @version 1.0
 * @className SubjectLabelDTOConverter
 * @date 2025-08-17
 * @description TODO 对象转换器
 */
@Mapper
public interface SubjectLabelDTOConverter {
    SubjectLabelDTOConverter INSTANCE = Mappers.getMapper(SubjectLabelDTOConverter.class);

    SubjectLabelBO convertLabelDTOToLabelBo(SubjectLabelDTO subjectLabelDTO);

    List<SubjectLabelDTO> convertLabelBoListToLabelDTOList(List<SubjectLabelBO> subjectLabelBOList);
}
