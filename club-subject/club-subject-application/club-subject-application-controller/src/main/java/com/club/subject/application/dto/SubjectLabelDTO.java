package com.club.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目标签DTO
 *
 * @author zh
 * @since 2025-08-20 20:38:17
 */
@Data
public class SubjectLabelDTO implements Serializable {
    private static final long serialVersionUID = -50583380788466237L;

    private Integer id;
    /**
     * 标签名称
     */
    private String labelName;
    /**
     * 排序
     */
    private Integer sortNum;
    /**
     * 逻辑删除
     */
    private Integer isDeleted;
    /**
     * 分类id
     */
    private Integer categoryId;
}

