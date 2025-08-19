package com.club.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * packageName com.club.subject.application.controller.dto
 *
 * @author zh
 * @version 1.0
 * @className SubjectCategoryDTO
 * @date 2025-08-17
 * @description TODO
 */
@Data
public class SubjectCategoryDTO  implements Serializable {
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
