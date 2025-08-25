package com.club.subject.infra.basic.service;

import com.club.subject.infra.basic.entity.SubjectMultiple;

import java.util.List;

/**
 * 多选题表(SubjectMultiple)表服务接口
 *
 * @author makejava
 * @since 2025-08-24 19:24:09
 */
public interface SubjectMultipleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectMultiple queryById(Integer id);

    /**
     * 新增数据
     *
     * @param subjectMultiple 实例对象
     * @return 实例对象
     */
    SubjectMultiple insert(SubjectMultiple subjectMultiple);

    /**
     * 修改数据
     *
     * @param subjectMultiple 实例对象
     * @return 实例对象
     */
    SubjectMultiple update(SubjectMultiple subjectMultiple);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 批量新增数据
     *
     * @param subjectMultipleList 实例对象列表
     */
    void batchInsert(List<SubjectMultiple> subjectMultipleList);

}
