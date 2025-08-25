package com.club.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.club.subject.application.convert.SubjectLabelDTOConverter;
import com.club.subject.application.dto.SubjectLabelDTO;
import com.club.subject.common.entity.Resp;
import com.club.subject.common.enums.AppExceptionCodeMsg;
import com.club.subject.domain.entity.SubjectLabelBO;
import com.club.subject.domain.service.SubjectLabelDomainService;
import com.club.subject.infra.basic.entity.SubjectLabel;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * packageName com.club.subject.application.controller
 *
 * @author zh
 * @version 1.0
 * @className SubjectLabelController
 * @date 2025-08-20
 * @description TODO 题目标签controller
 */
@RestController
@RequestMapping("/subject/label")
@Slf4j
public class SubjectLabelController {

    @Resource
    SubjectLabelDomainService subjectLabelDomainService;

    /**
     * 新增题目标签
     */
    @PostMapping("/add")
    public Resp add(@RequestBody SubjectLabelDTO subjectLabelDTO){
        try{
            if(log.isInfoEnabled()){
                log.info("SubjectLabelController.add.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }
            Preconditions.checkNotNull(subjectLabelDTO.getLabelName(), "标签名称不能为空");
            // BTO -> BO
            SubjectLabelBO subjectLabelBO =
                    SubjectLabelDTOConverter.INSTANCE.convertLabelDTOToLabelBo(subjectLabelDTO);
            // 新增
            return Resp.success("新增成功", subjectLabelDomainService.add(subjectLabelBO));
        }catch (Exception e){
            log.error("SubjectLabelController.add.error:{}", JSON.toJSONString(e.getMessage()), e);
            return Resp.error(AppExceptionCodeMsg.ADD_FAIL.getCode(), AppExceptionCodeMsg.ADD_FAIL.getMsg());
        }
    }

    /**
     * 修改标签
     */
    @PostMapping("/update")
    public Resp update(@RequestBody SubjectLabelDTO subjectLabelDTO){
        try{
            if(log.isInfoEnabled()){
                log.info("SubjectLabelController.update.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }
            Preconditions.checkNotNull(subjectLabelDTO.getId(),"ID不能为空");
            Preconditions.checkNotNull(subjectLabelDTO.getLabelName(),"标签名称不能为空");
            // BTO -> BO
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.convertLabelDTOToLabelBo(subjectLabelDTO);
            // 修改
            SubjectLabel update = subjectLabelDomainService.update(subjectLabelBO);
            return Resp.success("修改成功", update);
        }catch (Exception e){
            log.error("SubjectLabelController.update.error:{}", JSON.toJSONString(e.getMessage()), e);
            return Resp.error(AppExceptionCodeMsg.UPDATE_FAIL.getCode(), AppExceptionCodeMsg.UPDATE_FAIL.getMsg());
        }
    }

    /**
     * 删除标签
     */
    @PostMapping("/delete")
    public Resp delete(@RequestBody SubjectLabelDTO subjectLabelDTO){
        try{
            if(log.isInfoEnabled()){
                log.info("SubjectLabelController.delete.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }
            Preconditions.checkNotNull(subjectLabelDTO.getId(),"ID不能为空");
            // BTO -> BO
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.convertLabelDTOToLabelBo(subjectLabelDTO);
            // 删除
            return Resp.success("删除成功", subjectLabelDomainService.delete(subjectLabelBO));
        }catch (Exception e){
            log.error("SubjectLabelController.delete.error:{}", JSON.toJSONString(e.getMessage()), e);
            return Resp.error(AppExceptionCodeMsg
                    .DELETE_FAIL.getCode(), AppExceptionCodeMsg.DELETE_FAIL.getMsg());
        }
    }

    /**
     * 查询分类下标签
     */
    @PostMapping("/queryLabelByCategoryId")
    public Resp<List<SubjectLabelDTO>> queryLabelByCategoryId(@RequestBody SubjectLabelDTO subjectLabelDTO){
        try{
            if(log.isInfoEnabled()){
                log.info("SubjectLabelController.queryLabelByCategoryId.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }
            // Preconditions.checkNotNull(subjectLabelDTO.getId(),"ID不能为空");
            Preconditions.checkNotNull(subjectLabelDTO.getCategoryId(),"分类ID不能为空");
            // BTO -> BO
            SubjectLabelBO subjectLabelBO =
                    SubjectLabelDTOConverter.INSTANCE.convertLabelDTOToLabelBo(subjectLabelDTO);
            // 查询
            List<SubjectLabelBO> subjectLabelBOList = subjectLabelDomainService.queryLabelByCategoryId(subjectLabelBO);
            // ListBO -> ListDTO
            List<SubjectLabelDTO> result =
                    SubjectLabelDTOConverter.INSTANCE.convertLabelBoListToLabelDTOList(subjectLabelBOList);
            return Resp.success("查询成功", result);
        }catch (Exception e){
            log.error("SubjectLabelController.queryLabelByCategoryId.error:{}", JSON.toJSONString(e.getMessage()), e);
            return Resp.error(AppExceptionCodeMsg
                    .DELETE_FAIL.getCode(), AppExceptionCodeMsg.DELETE_FAIL.getMsg());
        }
    }


}
