package com.club.subject.infra.basic.service.impl;

import com.club.subject.infra.basic.entity.SubjectLabel;
import com.club.subject.infra.basic.mapper.SubjectLabelDao;
import com.club.subject.infra.basic.service.SubjectLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 题目标签表(SubjectLabel)表服务实现类
 *
 * @author makejava
 * @since 2025-08-20 20:38:17
 */
@Service("subjectLabelService")
public class SubjectLabelServiceImpl implements SubjectLabelService {
    @Resource
    private SubjectLabelDao subjectLabelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectLabel queryById(Integer id) {
        return this.subjectLabelDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(SubjectLabel subjectLabel) {
        return this.subjectLabelDao.insert(subjectLabel);
    }

    /**
     * 修改数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectLabel update(SubjectLabel subjectLabel) {
        return this.subjectLabelDao.update(subjectLabel) > 0 ? this.queryById(subjectLabel.getId()) : null;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(SubjectLabel subjectLabel) {
        return this.subjectLabelDao.deleteById(subjectLabel) > 0;
    }

    @Override
    public List<SubjectLabel> bacthQueryById(List<Integer> labelIdsList) {
        return this.subjectLabelDao.bacthQueryById(labelIdsList);
    }
}
