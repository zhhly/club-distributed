package com.club.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.club.subject.application.convert.SubjectAnswerDTOConverter;
import com.club.subject.application.convert.SubjectInfoDTOConverter;
import com.club.subject.application.dto.SubjectInfoDTO;
import com.club.subject.common.entity.Resp;
import com.club.subject.common.enums.AppExceptionCodeMsg;
import com.club.subject.domain.entity.SubjectAnswerBO;
import com.club.subject.domain.entity.SubjectInfoBO;
import com.club.subject.domain.service.SubjectInfoDomainService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * packageName com.club.subject.application.controller
 * @author zh
 * @version 1.0
 * @className SubjectController
 * @date 2025-08-16
 * @description TODO 刷题Controller
 */
@RestController
@RequestMapping("/subject")
@Slf4j
public class SubjectController {

    private final SubjectInfoDomainService subjectInfoDomainService;

    public SubjectController(SubjectInfoDomainService subjectInfoDomainService) {
        this.subjectInfoDomainService = subjectInfoDomainService;
    }

    /**
     * 新增题目
     * @param subjectInfoDTO
     * @return void
     */
    @PostMapping("/add")
    public Resp add(@RequestBody SubjectInfoDTO subjectInfoDTO){
        try{
            if(log.isInfoEnabled()){
                log.info("SubjectController.add.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectName(),"题目名称不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectDifficult(),"题目难度不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(),"题目类型不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectScore(),"分数不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getCategoryIds()),"分类ID不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getLabelIds()),"标签ID不能为空");
            // BTO -> BO
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertInfoDTOToInfoBo(subjectInfoDTO);
            // ListDTI -> ListBO
            List<SubjectAnswerBO> subjectAnswerBOS =
                    SubjectAnswerDTOConverter.INSTANCE.convertListDTOToInfoBo(subjectInfoDTO.getOptionList());
            subjectInfoBO.setOptionList(subjectAnswerBOS);
            // 新增
            subjectInfoDomainService.add(subjectInfoBO);
            return Resp.success("新增成功", Boolean.TRUE);
        }catch (Exception e){
            log.error("SubjectController.add.error:{}", JSON.toJSONString(e.getMessage()), e);
            return Resp.error(AppExceptionCodeMsg.ADD_FAIL.getCode(), AppExceptionCodeMsg.ADD_FAIL.getMsg());
        }
    }

}
