package com.club.subject.infra.basic.service.impl;

import com.club.subject.infra.basic.entity.SubjectJudge;
import com.club.subject.infra.basic.mapper.SubjectJudgeDao;
import com.club.subject.infra.basic.service.SubjectJudgeService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * 判断题表(SubjectJudge)表服务实现类
 *
 * @author makejava
 * @since 2025-08-24 19:23:53
 */
@Service("subjectJudgeService")
public class SubjectJudgeServiceImpl implements SubjectJudgeService {
    @Resource
    private SubjectJudgeDao subjectJudgeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectJudge queryById(Integer id) {
        return this.subjectJudgeDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param subjectJudge 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectJudge insert(SubjectJudge subjectJudge) {
        this.subjectJudgeDao.insert(subjectJudge);
        return subjectJudge;
    }

    /**
     * 修改数据
     *
     * @param subjectJudge 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectJudge update(SubjectJudge subjectJudge) {
        this.subjectJudgeDao.update(subjectJudge);
        return this.queryById(subjectJudge.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.subjectJudgeDao.deleteById(id) > 0;
    }

    /**
     * 批量新增数据
     *
     * @param subjectJudgeList 实例对象列表
     */
    @Override
    public void batchInsert(List<SubjectJudge> subjectJudgeList) {
        this.subjectJudgeDao.insertBatch(subjectJudgeList);
    }
}
