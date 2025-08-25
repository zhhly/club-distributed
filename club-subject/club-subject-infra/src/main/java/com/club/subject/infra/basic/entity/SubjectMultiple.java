package com.club.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 多选题表(SubjectMultiple)实体类
 *
 * @author makejava
 * @since 2025-08-24 19:24:09
 */
@Data
public class SubjectMultiple implements Serializable {
    private static final long serialVersionUID = -33447174121592727L;

    private Integer id;
    /**
     * 题目id
     */
    private Integer subjectId;
    /**
     * 选项类型[a, b, c, d, e]
     */
    private String optionType;
    /**
     * 选项内容
     */
    private String optionContent;
    /**
     * 是否正确
     */
    private Integer isCorrect;
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

    private Integer isDeleted;

}

