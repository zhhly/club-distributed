package com.club.subject.domain.service;

import com.club.subject.domain.entity.SubjectCategoryBO;
import com.club.subject.infra.basic.entity.SubjectCategory;

import java.util.List;

/**
 * packageName com.club.subject.domain.service
 *
 * @author zh
 * @version 1.0
 * @className SubjectCategoryDomainService
 * @date 2025-08-17
 * @description TODO 暴露新增分类接口
 */

public interface SubjectCategoryDomainService {

    void add(SubjectCategoryBO subjectCategoryBO);

    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);

    SubjectCategory update(SubjectCategoryBO subjectCategoryBO);

    boolean delete(SubjectCategoryBO subjectCategoryBO);
}
