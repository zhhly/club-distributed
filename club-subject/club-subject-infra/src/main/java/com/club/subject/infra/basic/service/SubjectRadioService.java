package com.club.subject.infra.basic.service;

import com.club.subject.infra.basic.entity.SubjectRadio;

import java.util.List;

/**
 * 单选题表(SubjectRadio)表服务接口
 *
 * @author makejava
 * @since 2025-08-24 19:24:29
 */
public interface SubjectRadioService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectRadio queryById(Integer id);

    /**
     * 新增数据
     *
     * @param subjectRadio 实例对象
     * @return 实例对象
     */
    SubjectRadio insert(SubjectRadio subjectRadio);

    /**
     * 修改数据
     *
     * @param subjectRadio 实例对象
     * @return 实例对象
     */
    SubjectRadio update(SubjectRadio subjectRadio);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    void bacthInsert(List<SubjectRadio> subjectRadioList);

}
