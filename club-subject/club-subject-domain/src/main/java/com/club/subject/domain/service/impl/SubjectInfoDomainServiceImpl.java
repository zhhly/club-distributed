package com.club.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.club.subject.common.enums.IsDeleteFlagEnum;
import com.club.subject.domain.convert.SubjectInfoConverter;
import com.club.subject.domain.entity.SubjectInfoBO;
import com.club.subject.domain.handler.subject.SubjectTypeHandler;
import com.club.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import com.club.subject.domain.service.SubjectInfoDomainService;
import com.club.subject.infra.basic.entity.SubjectInfo;
import com.club.subject.infra.basic.entity.SubjectMapping;
import com.club.subject.infra.basic.service.SubjectInfoService;
import com.club.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

import java.util.LinkedList;
import java.util.List;

/**
 * packageName com.club.subject.domain.service.impl
 *
 * @author zh
 * @version 1.0
 * @className SubjectInfoDomainServiceImpl
 * @date 2025-08-24
 * @description TODO
 */
@Service
@Slf4j
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {

    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        if(log.isInfoEnabled()){
            log.info("SubjectInfoDomainServiceImpl.add.bo:{}", JSON.toJSON(subjectInfoBO));
        }
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.convertBoToInfo(subjectInfoBO);
        // 新增成功记得将id返回
        SubjectInfo newSubjectInfo = subjectInfoService.insert(subjectInfo);

        // 设置题目ID，确保后续处理器能获取到ID
        subjectInfoBO.setId(subjectInfo.getId());
        
        // 由于题目种类有四种，单选，多选，判断，等。需要写至少四个if语句。所以：使用策略+工厂模式进行开发。
        // 一个工厂包含四种类型，根据传入的type自动映射选择器。
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        if (handler == null) {
            log.error("未找到对应的题目类型处理器，题目类型：{}", subjectInfo.getSubjectType());
            throw new RuntimeException("未找到对应的题目类型处理器，题目类型：" + subjectInfo.getSubjectType());
        }
        handler.add(subjectInfoBO);

        // 新增mapper映射信息
        List<Integer> categoryIds = subjectInfoBO.getCategoryIds();
        List<Integer> labelIds = subjectInfoBO.getLabelIds();
        List<SubjectMapping> subjectMappingList = new LinkedList<>();
        
        if (subjectInfoBO.getId() == null) {
            log.error("题目ID为空，无法创建映射关系");
            throw new RuntimeException("题目ID为空，无法创建映射关系");
        }
        
        categoryIds.forEach(categoryId->{
            labelIds.forEach(labelId->{
                SubjectMapping subjectMapping = new SubjectMapping();
                subjectMapping.setSubjectId(newSubjectInfo.getId());
                subjectMapping.setCategoryId(categoryId);
                subjectMapping.setLabelId(labelId);
                subjectMapping.setIsDeleted(IsDeleteFlagEnum.UN_DELETE.getCode());
                subjectMappingList.add(subjectMapping);
            });
        });
        // 批量新增mapper
        subjectMappingService.batchInsert(subjectMappingList);

    }
}
