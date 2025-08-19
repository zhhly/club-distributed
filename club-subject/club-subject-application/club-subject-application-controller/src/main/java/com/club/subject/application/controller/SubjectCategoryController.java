package com.club.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.club.subject.application.convert.SubjectCategoryDTOConverter;
import com.club.subject.application.dto.SubjectCategoryDTO;
import com.club.subject.common.entity.Resp;
import com.club.subject.common.enums.AppExceptionCodeMsg;
import com.club.subject.domain.entity.SubjectCategoryBO;
import com.club.subject.domain.service.SubjectCategoryDomainService;
import com.club.subject.infra.basic.entity.SubjectCategory;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * packageName com.club.subject.application.controller
 *
 * @author zh
 * @version 1.0
 * @className SubjectCategoryController
 * @date 2025-08-17
 * @description TODO 题目分类 Controller
 */
@RestController
@RequestMapping("/subject/category")
@Slf4j
public class SubjectCategoryController {

    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    /**
     * 新增题目分类
     * @param subjectCategoryDTO
     * @return void
     */
    @PostMapping("/add")
    public Resp add(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try{
            if(log.isInfoEnabled()){
                log.info("SubjectCategoryController.add.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }
            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryName(), "分类名称不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(),"分类类型不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(),"父ID不能为空");
            // BTO -> BO
            SubjectCategoryBO subjectCategoryBO =
                    SubjectCategoryDTOConverter.INSTANCE.convertCategoryDTOToCategoryBo(subjectCategoryDTO);
            // 新增
            subjectCategoryDomainService.add(subjectCategoryBO);
            return Resp.success("新增成功", Boolean.TRUE);
        }catch (Exception e){
            log.error("SubjectCategoryController.add.error:{}", JSON.toJSONString(e.getMessage()), e);
            return Resp.error(AppExceptionCodeMsg.ADD_FAIL.getCode(), AppExceptionCodeMsg.ADD_FAIL.getMsg());
        }
    }

    /**
     * 查询所有大分类
     * @return List<SubjectCategoryDTO>
     */
    @GetMapping("/queryPrimaryCategory")
    public Resp<List<SubjectCategoryDTO>> queryPrimaryCategory(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try{
            if(log.isInfoEnabled()){
                log.info("SubjectCategoryController.queryPrimaryCategory.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }
            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(),"分类类型不能为空");
            // BTO -> BO
            SubjectCategoryBO subjectCategoryBO =
                    SubjectCategoryDTOConverter.INSTANCE.convertCategoryDTOToCategoryBo(subjectCategoryDTO);
            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService.queryCategory(subjectCategoryBO);
            // List<BO> -> List<BTO>
            List<SubjectCategoryDTO> subjectCategoryDTOList =
                    SubjectCategoryDTOConverter.INSTANCE.convertCategoryBoToCategoryDTOList(subjectCategoryBOList);
            return Resp.success("查询成功", subjectCategoryDTOList);
        }catch (Exception e){
            if(log.isInfoEnabled()){
                log.error("SubjectCategoryController.queryPrimaryCategory.dto:{}", JSON.toJSONString(e.getMessage()), e);
            }
            return Resp.error(AppExceptionCodeMsg.QUERY_FAIL.getCode(), AppExceptionCodeMsg.QUERY_FAIL.getMsg());
        }
    }

    /**
     * 查询所有子分类
     * @return List<SubjectCategoryDTO>
     */
    @GetMapping("/queryCategoryByPrimary")
    public Resp<List<SubjectCategoryDTO>> queryCategoryByPrimary(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try{
            if(log.isInfoEnabled()){
                log.info("SubjectCategoryController.queryCategoryByPrimary.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(),"分类ID不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(),"分类类型不能为空");
            // BTO -> BO
            SubjectCategoryBO subjectCategoryBO =
                    SubjectCategoryDTOConverter.INSTANCE.convertCategoryDTOToCategoryBo(subjectCategoryDTO);
            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService.queryCategory(subjectCategoryBO);
            // List<BO> -> List<BTO>
            List<SubjectCategoryDTO> subjectCategoryDTOList =
                    SubjectCategoryDTOConverter.INSTANCE.convertCategoryBoToCategoryDTOList(subjectCategoryBOList);
            return Resp.success("查询成功", subjectCategoryDTOList);
        }catch (Exception e){
            if(log.isInfoEnabled()){
                log.error("SubjectCategoryController.queryCategoryByPrimary.dto:{}", JSON.toJSONString(e.getMessage()), e);
            }
            return Resp.error(AppExceptionCodeMsg.QUERY_FAIL.getCode(), AppExceptionCodeMsg.QUERY_FAIL.getMsg());
        }
    }

    /**
     * 修改分类
     */
    @PostMapping("/update")
    public Resp update(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try{
            if(log.isInfoEnabled()){
                log.info("SubjectCategoryController.update.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }
            Preconditions.checkNotNull(subjectCategoryDTO.getId(),"ID不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryName(),"分类名称不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(),"分类类型不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(),"父ID不能为空");
            // BTO -> BO
            SubjectCategoryBO subjectCategoryBO =
                    SubjectCategoryDTOConverter.INSTANCE.convertCategoryDTOToCategoryBo(subjectCategoryDTO);
            // 修改
            SubjectCategory update = subjectCategoryDomainService.update(subjectCategoryBO);
            return Resp.success("修改成功", update);
        }catch (Exception e){
            log.error("SubjectCategoryController.update.error:{}", JSON.toJSONString(e.getMessage()), e);
            return Resp.error(AppExceptionCodeMsg.UPDATE_FAIL.getCode(), AppExceptionCodeMsg.UPDATE_FAIL.getMsg());
        }
    }

    /**
     * 删除分类
     */
    @PostMapping("/delete")
    public Resp delete(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try{
            if(log.isInfoEnabled()){
                log.info("SubjectCategoryController.delete.dto:{}", subjectCategoryDTO);
            }
            Preconditions.checkNotNull(subjectCategoryDTO.getId(),"ID不能为空");
            // BTO -> BO
            SubjectCategoryBO subjectCategoryBO =
                    SubjectCategoryDTOConverter.INSTANCE.convertCategoryDTOToCategoryBo(subjectCategoryDTO);
            // 删除
            boolean result = subjectCategoryDomainService.delete(subjectCategoryBO);
            return Resp.success("删除成功", result);
        }catch (Exception e){
            log.error("SubjectCategoryController.delete.error:{}", JSON.toJSONString(e.getMessage()), e);
            return Resp.error(AppExceptionCodeMsg
                    .DELETE_FAIL.getCode(), AppExceptionCodeMsg.DELETE_FAIL.getMsg());
        }
    }

}

