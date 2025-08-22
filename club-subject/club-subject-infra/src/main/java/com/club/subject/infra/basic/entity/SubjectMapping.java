package com.club.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 题目分类关系表(SubjectMapping)实体类
 *
 * @author makejava
 * @since 2025-08-22 22:43:55
 */
@Data
public class SubjectMapping implements Serializable {
    private static final long serialVersionUID = -32546218189323352L;

    private Integer id;
    /**
     * 题目id
     */
    private Integer subjectId;
    /**
     * 分类id
     */
    private Integer categoryId;
    /**
     * 标签id
     */
    private Integer labelId;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 是否删除
     */
    private Integer isDeleted;

}

