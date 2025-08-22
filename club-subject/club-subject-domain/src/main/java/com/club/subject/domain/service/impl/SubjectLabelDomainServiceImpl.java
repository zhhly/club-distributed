package com.club.subject.domain.service.impl;

import com.club.subject.common.enums.IsDeleteFlagEnum;
import com.club.subject.domain.convert.SubjectLabelConverter;
import com.club.subject.domain.entity.SubjectLabelBO;
import com.club.subject.domain.service.SubjectLabelDomainService;
import com.club.subject.infra.basic.entity.SubjectLabel;
import com.club.subject.infra.basic.entity.SubjectMapping;
import com.club.subject.infra.basic.service.SubjectLabelService;
import com.club.subject.infra.basic.service.SubjectMappingService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName com.club.subject.domain.service.impl
 *
 * @author zh
 * @version 1.0
 * @className SubjectLabelDomainServiceImpl
 * @date 2025-08-20
 * @description TODO 对外提供接口能力
 */
@Service
@Slf4j
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {
    @Resource
    private SubjectLabelService subjectLabelService;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Override
    public Boolean add(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convSubjectLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeleteFlagEnum.UN_DELETE.getCode());
        return subjectLabelService.insert(subjectLabel) > 0;
    }

    @Override
    public List<SubjectLabelBO> queryCategory(SubjectLabelBO subjectLabelBO) {
        return List.of();
    }

    @Override
    public SubjectLabel update(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convSubjectLabel(subjectLabelBO);
        return subjectLabelService.update(subjectLabel);
    }

    @Override
    public boolean delete(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convSubjectLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeleteFlagEnum.DELETE.getCode());
        return subjectLabelService.deleteById(subjectLabel);
    }

    @Override
    public List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO) {
        Integer categoryId = subjectLabelBO.getCategoryId();
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setCategoryId(categoryId);
        subjectMapping.setIsDeleted(IsDeleteFlagEnum.UN_DELETE.getCode());

        List<SubjectMapping> subjectMappingList = subjectMappingService.queryLabelId(subjectMapping);
        if(CollectionUtils.isEmpty(subjectMappingList)){
            return Collections.emptyList();
        }
        List<Integer> labelIdsList = subjectMappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> labelList = subjectLabelService.bacthQueryById(labelIdsList);

        List<SubjectLabelBO> boList = new LinkedList<>();
        labelList.forEach(label -> {
            SubjectLabelBO bo = new SubjectLabelBO();
            bo.setId(label.getId());
            bo.setLabelName(label.getLabelName());
            bo.setSortNum(label.getSortNum());
            bo.setIsDeleted(label.getIsDeleted());
            bo.setCategoryId(categoryId);
            boList.add(bo);
        });
        return boList;
    }
}
