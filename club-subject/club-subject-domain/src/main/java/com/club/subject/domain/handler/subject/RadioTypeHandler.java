package com.club.subject.domain.handler.subject;

import com.club.subject.common.enums.IsDeleteFlagEnum;
import com.club.subject.common.enums.SubjectInfoTypeEnum;
import com.club.subject.domain.convert.RadioSubjectConverter;
import com.club.subject.domain.entity.SubjectInfoBO;
import com.club.subject.infra.basic.entity.SubjectRadio;
import com.club.subject.infra.basic.service.SubjectRadioService;
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
 * @className RadioTypeHandler
 * @date 2025-08-24
 * @description TODO 单选题目策略类
 */
@Component
public class RadioTypeHandler implements SubjectTypeHandler {

    @Resource
    private SubjectRadioService subjectRadioService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // 单选题目新增
        if (subjectInfoBO.getOptionList() == null || CollectionUtils.isEmpty(subjectInfoBO.getOptionList())){
            throw new AppException(500, "题目答案不能为空");
        }
        List<SubjectRadio> subjectRadioList = new LinkedList<>();
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectRadio subjectRadio = RadioSubjectConverter.INSTANCE.convertBoToEntity(option);
            subjectRadio.setSubjectId(subjectInfoBO.getId());
            subjectRadio.setIsDeleted(IsDeleteFlagEnum.UN_DELETE.getCode());
            subjectRadioList.add(subjectRadio);
        });
        subjectRadioService.bacthInsert(subjectRadioList);
    }
}
