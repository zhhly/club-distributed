package com.club.subject.infra.basic.service;

import com.club.subject.infra.basic.entity.SubjectCategory;

import java.util.List;

/**
 * 刷题分类表(SubjectCategory)表服务接口
 *
 * @author makejava
 * @since 2025-08-16 21:52:08
 */
public interface SubjectCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectCategory queryById(Integer id);


    /**
     * 新增数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    SubjectCategory insert(SubjectCategory subjectCategory);

    /**
     * 修改数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    SubjectCategory update(SubjectCategory subjectCategory);

    /**
     * 通过主键删除数据
     *
     * @param subjectCategory id 主键
     * @return 是否成功
     */
    int deleteById(SubjectCategory subjectCategory);

    List<SubjectCategory> queryCategory(SubjectCategory subjectCategory);
}
