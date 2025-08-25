package com.club.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 判断题表(SubjectJudge)实体类
 *
 * @author makejava
 * @since 2025-08-24 19:23:53
 */
@Data
public class SubjectJudge implements Serializable {
    private static final long serialVersionUID = 748278803792218935L;

    private Integer id;
    /**
     * 题目id
     */
    private Integer subjectId;
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

