package com.club.subject.domain.handler.subject;

import com.club.subject.common.enums.IsDeleteFlagEnum;
import com.club.subject.common.enums.SubjectInfoTypeEnum;
import com.club.subject.domain.convert.BriefSubjectConverter;
import com.club.subject.domain.entity.SubjectInfoBO;
import com.club.subject.infra.basic.entity.SubjectBrief;
import com.club.subject.infra.basic.service.SubjectBriefService;
import com.club.subject.infra.exception.AppException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * packageName com.club.subject.domain.handler.subject
 *
 * @author zh
 * @version 1.0
 * @className BriefTypeHandler
 * @date 2025-08-24
 * @description TODO 简答类题目策略类
 */
@Component
public class BriefTypeHandler implements SubjectTypeHandler {

    @Resource
    private SubjectBriefService subjectBriefService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // 简答类题目新增
        if (!StringUtils.hasText(subjectInfoBO.getSubjectAnswer())){
            throw new AppException(500, "简答题答案不能为空");
        }
        
        SubjectBrief subjectBrief = BriefSubjectConverter.INSTANCE.convertBoToEntity(subjectInfoBO);
        subjectBrief.setSubjectId(subjectInfoBO.getId());
        subjectBrief.setIsDeleted(IsDeleteFlagEnum.UN_DELETE.getCode());
        subjectBriefService.insert(subjectBrief);
    }
}
