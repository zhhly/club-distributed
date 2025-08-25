package com.club.subject.domain.handler.subject;

import com.club.subject.common.enums.IsDeleteFlagEnum;
import com.club.subject.common.enums.SubjectInfoTypeEnum;
import com.club.subject.domain.convert.MultipleSubjectConverter;
import com.club.subject.domain.entity.SubjectInfoBO;
import com.club.subject.infra.basic.entity.SubjectMultiple;
import com.club.subject.infra.basic.service.SubjectMultipleService;
import com.club.subject.infra.exception.AppException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * packageName com.club.subject.domain.handler.subject
 *
 * @author zh
 * @version 1.0
 * @className MultipleTypeHandler
 * @date 2025-08-24
 * @description TODO 多选题目策略类
 */
@Component
public class MultipleTypeHandler implements SubjectTypeHandler {

    @Resource
    private SubjectMultipleService subjectMultipleService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.MULTIPLE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // 多选题目新增
        if (subjectInfoBO.getOptionList() == null || CollectionUtils.isEmpty(subjectInfoBO.getOptionList())){
            throw new AppException(500, "多选题答案不能为空");
        }
        
        List<SubjectMultiple> subjectMultipleList = new LinkedList<>();
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectMultiple subjectMultiple = MultipleSubjectConverter.INSTANCE.convertBoToEntity(option);
            subjectMultiple.setSubjectId(subjectInfoBO.getId());
            subjectMultiple.setIsDeleted(IsDeleteFlagEnum.UN_DELETE.getCode());
            subjectMultipleList.add(subjectMultiple);
        });
        subjectMultipleService.batchInsert(subjectMultipleList);
    }
}
