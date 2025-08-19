package com.club.subject.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 刷题分类表(SubjectCategory)实体类
 *
 * @author makejava
 * @since 2025-08-16 21:52:03
 */
@Data
public class SubjectCategoryBO implements Serializable {
    private static final long serialVersionUID = -41176738747171445L;

    private Integer id;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 分类类型
     */
    private String categoryType;
    /**
     * 图片链接
     */
    private String imageUrl;
    /**
     * 父类id
     */
    private Integer parentId;

}

