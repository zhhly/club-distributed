package com.club.subject.infra.basic.service.impl;

import com.club.subject.infra.basic.entity.SubjectBrief;
import com.club.subject.infra.basic.mapper.SubjectBriefDao;
import com.club.subject.infra.basic.service.SubjectBriefService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 简答题表(SubjectBrief)表服务实现类
 *
 * @author makejava
 * @since 2025-08-24 19:23:24
 */
@Service("subjectBriefService")
public class SubjectBriefServiceImpl implements SubjectBriefService {
    @Resource
    private SubjectBriefDao subjectBriefDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectBrief queryById(Integer id) {
        return this.subjectBriefDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param subjectBrief 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectBrief insert(SubjectBrief subjectBrief) {
        this.subjectBriefDao.insert(subjectBrief);
        return subjectBrief;
    }

    /**
     * 修改数据
     *
     * @param subjectBrief 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectBrief update(SubjectBrief subjectBrief) {
        this.subjectBriefDao.update(subjectBrief);
        return this.queryById(subjectBrief.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.subjectBriefDao.deleteById(id) > 0;
    }
}
