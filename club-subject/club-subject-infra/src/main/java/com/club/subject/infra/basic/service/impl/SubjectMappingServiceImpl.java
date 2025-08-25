package com.club.subject.infra.basic.service.impl;

import com.club.subject.infra.basic.entity.SubjectMapping;
import com.club.subject.infra.basic.mapper.SubjectMappingDao;
import com.club.subject.infra.basic.service.SubjectMappingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 题目分类关系表(SubjectMapping)表服务实现类
 *
 * @author makejava
 * @since 2025-08-22 22:44:02
 */
@Service("subjectMappingService")
public class SubjectMappingServiceImpl implements SubjectMappingService {
    @Resource
    private SubjectMappingDao subjectMappingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectMapping queryById(Integer id) {
        return this.subjectMappingDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param subjectMapping 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectMapping insert(SubjectMapping subjectMapping) {
        this.subjectMappingDao.insert(subjectMapping);
        return subjectMapping;
    }

    /**
     * 修改数据
     *
     * @param subjectMapping 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectMapping update(SubjectMapping subjectMapping) {
        this.subjectMappingDao.update(subjectMapping);
        return this.queryById(subjectMapping.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.subjectMappingDao.deleteById(id) > 0;
    }

    /**
     * 查询所有labelid
     *
     * @param subjectMapping 标签与分类 id映射
     * @return 是否成功
     */
    @Override
    public List<SubjectMapping> queryLabelId(SubjectMapping subjectMapping) {
        return subjectMappingDao.queryDistinctLabelId(subjectMapping);
    }

    /**
     * 批量新增映射
     * @param subjectMappingList
     */
    @Override
    public void batchInsert(List<SubjectMapping> subjectMappingList) {
        this.subjectMappingDao.insertBatch(subjectMappingList);
    }
}
