package com.club.subject.infra.basic.service.impl;

import com.club.subject.infra.basic.entity.SubjectCategory;
import com.club.subject.infra.basic.mapper.SubjectCategoryDao;
import com.club.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 刷题分类表(SubjectCategory)表服务实现类
 *
 * @author makejava
 * @since 2025-08-16 21:52:09
 */
@Service("subjectCategoryService")
public class SubjectCategoryServiceImpl implements SubjectCategoryService {

    @Resource
    private SubjectCategoryDao subjectCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectCategory queryById(Integer id) {
        return this.subjectCategoryDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectCategory insert(SubjectCategory subjectCategory) {
        this.subjectCategoryDao.insert(subjectCategory);
        return subjectCategory;
    }

    /**
     * 修改数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectCategory update(SubjectCategory subjectCategory) {
        this.subjectCategoryDao.update(subjectCategory);
        return this.queryById(subjectCategory.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param subjectCategory id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(SubjectCategory subjectCategory) {
        return this.subjectCategoryDao.deleteById(subjectCategory);
    }

    /**
     * 查询所有分类
     * @return
     */
    @Override
    public List<SubjectCategory> queryCategory(SubjectCategory subjectCategory) {
        return this.subjectCategoryDao.queryCategory(subjectCategory);
    }
}
