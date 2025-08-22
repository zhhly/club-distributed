package com.club.subject.domain.service;

import com.club.subject.domain.entity.SubjectLabelBO;
import com.club.subject.infra.basic.entity.SubjectLabel;

import java.util.List;

/**
 * packageName com.club.subject.domain.service
 *
 * @author zh
 * @version 1.0
 * @className SubjectLabelDomainService
 * @date 2025-08-20
 * @description TODO
 */

public interface SubjectLabelDomainService {
    Boolean add(SubjectLabelBO subjectLabelBO);

    List<SubjectLabelBO> queryCategory(SubjectLabelBO subjectLabelBO);

    SubjectLabel update(SubjectLabelBO subjectLabelBO);

    boolean delete(SubjectLabelBO subjectLabelBO);

    List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO);
}
