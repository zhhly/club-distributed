package com.club.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.club.subject.common.enums.IsDeleteFlagEnum;
import com.club.subject.domain.convert.SubjectCategoryConverter;
import com.club.subject.domain.entity.SubjectCategoryBO;
import com.club.subject.domain.service.SubjectCategoryDomainService;
import com.club.subject.infra.basic.entity.SubjectCategory;
import com.club.subject.infra.basic.service.SubjectCategoryService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName com.club.subject.domain.service
 *
 * @author zh
 * @version 1.0
 * @className impl
 * @date 2025-08-17
 * @description TODO 对外提供接口能力
 */
@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Override
    public void add(SubjectCategoryBO subjectCategoryBO) {
        if(log.isInfoEnabled()){
            log.info("SubjectCategoryDomainServiceImpl.add.bo:{}", JSON.toJSON(subjectCategoryBO));
        }
        // BO -> SubjectCategory
        SubjectCategory subjectCategory =
                SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryBO);
        // 新增
        subjectCategoryService.insert(subjectCategory);
    }

    @Override
    public List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO) {
        // BO -> SubjectCategory
        SubjectCategory subjectCategory =
                SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeleteFlagEnum.UN_DELETE.getCode());

        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryCategory(subjectCategory);

        // List<SubjectCategory> -> List<BO>
        List<SubjectCategoryBO> subjectCategoryBOList =
                SubjectCategoryConverter.INSTANCE.convertCategoryListToCategoryBoList(subjectCategoryList);

        if(log.isInfoEnabled()){
            log.info("SubjectCategoryDomainServiceImpl.queryPrimaryCategory.listBo:{}", JSON.toJSON(subjectCategoryBOList));
        }
        return subjectCategoryBOList;
    }

    @Override
    public SubjectCategory update(SubjectCategoryBO subjectCategoryBO) {
        if(log.isInfoEnabled()){
            log.info("SubjectCategoryDomainServiceImpl.update.bo:{}", JSON.toJSON(subjectCategoryBO));
        }
        // BO -> SubjectCategory
        SubjectCategory subjectCategory =
                SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryBO);
        // 修改
        return subjectCategoryService.update(subjectCategory);
    }

    @Override
    public boolean delete(SubjectCategoryBO subjectCategoryBO) {
        if(log.isInfoEnabled()){
            log.info("SubjectCategoryDomainServiceImpl.delete.bo:{}", JSON.toJSONString(subjectCategoryBO));
        }
        // BO -> SubjectCategory
        SubjectCategory subjectCategory =
                SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeleteFlagEnum.DELETE.getCode());
        return subjectCategoryService.deleteById(subjectCategory) > 0;
    }

}
