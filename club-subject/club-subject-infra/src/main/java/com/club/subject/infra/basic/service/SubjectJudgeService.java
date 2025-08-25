package com.club.subject.infra.basic.service;

import com.club.subject.infra.basic.entity.SubjectJudge;

import java.util.List;

/**
 * 判断题表(SubjectJudge)表服务接口
 *
 * @author makejava
 * @since 2025-08-24 19:23:53
 */
public interface SubjectJudgeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectJudge queryById(Integer id);

    /**
     * 新增数据
     *
     * @param subjectJudge 实例对象
     * @return 实例对象
     */
    SubjectJudge insert(SubjectJudge subjectJudge);

    /**
     * 修改数据
     *
     * @param subjectJudge 实例对象
     * @return 实例对象
     */
    SubjectJudge update(SubjectJudge subjectJudge);

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
     * @param subjectJudgeList 实例对象列表
     */
    void batchInsert(List<SubjectJudge> subjectJudgeList);

}
