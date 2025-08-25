package com.club.subject.domain.handler.subject;

import com.club.subject.common.enums.IsDeleteFlagEnum;
import com.club.subject.common.enums.SubjectInfoTypeEnum;
import com.club.subject.domain.convert.JudgeSubjectConverter;
import com.club.subject.domain.entity.SubjectInfoBO;
import com.club.subject.infra.basic.entity.SubjectJudge;
import com.club.subject.infra.basic.service.SubjectJudgeService;
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
 * @className JudgeTypeHandler
 * @date 2025-08-24
 * @description TODO 判断题目策略类
 */
@Component
public class JudgeTypeHandler implements SubjectTypeHandler {

    @Resource
    private SubjectJudgeService subjectJudgeService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // 判断题目新增
        if (subjectInfoBO.getOptionList() == null || CollectionUtils.isEmpty(subjectInfoBO.getOptionList())){
            throw new AppException(500, "判断题答案不能为空");
        }
        
        List<SubjectJudge> subjectJudgeList = new LinkedList<>();
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectJudge subjectJudge = JudgeSubjectConverter.INSTANCE.convertBoToEntity(option);
            subjectJudge.setSubjectId(subjectInfoBO.getId());
            subjectJudge.setIsDeleted(IsDeleteFlagEnum.UN_DELETE.getCode());
            subjectJudgeList.add(subjectJudge);
        });
        subjectJudgeService.batchInsert(subjectJudgeList);
    }
}
