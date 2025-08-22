package com.club.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 题目标签表(SubjectLabel)实体类
 *
 * @author zh
 * @since 2025-08-20 20:38:17
 */
@Data
public class SubjectLabel implements Serializable {
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
     * 逻辑删除
     */
    private Integer isDeleted;
}

