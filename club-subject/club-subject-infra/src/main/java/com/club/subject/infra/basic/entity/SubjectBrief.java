package com.club.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 简答题表(SubjectBrief)实体类
 *
 * @author makejava
 * @since 2025-08-24 19:23:24
 */
@Data
public class SubjectBrief implements Serializable {
    private static final long serialVersionUID = -20200971482769826L;

    private Integer id;
    /**
     * 题目id
     */
    private Integer subjectId;
    /**
     * 题目答案
     */
    private String subjectAnswer;
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

