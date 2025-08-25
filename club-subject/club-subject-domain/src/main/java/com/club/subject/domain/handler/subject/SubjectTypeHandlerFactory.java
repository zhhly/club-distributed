package com.club.subject.domain.handler.subject;

import com.club.subject.common.enums.SubjectInfoTypeEnum;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * packageName com.club.subject.domain.handler.subject
 *
 * @author zh
 * @version 1.0
 * @className SubjectTypeHandlerFactory
 * @date 2025-08-24
 * @description TODO 题目类型工厂
 */
@Component
public class SubjectTypeHandlerFactory implements InitializingBean {

    @Resource
    private List<SubjectTypeHandler> subjectTypeHandlers;

    private Map<SubjectInfoTypeEnum, SubjectTypeHandler> handlerMap = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        for (SubjectTypeHandler subjectTypeHandler : subjectTypeHandlers) {
            handlerMap.put(subjectTypeHandler.getHandlerType(), subjectTypeHandler);
        }
    }

    public SubjectTypeHandler getHandler(int subjectType){
        SubjectInfoTypeEnum typeEnum = SubjectInfoTypeEnum.getType(subjectType);
        return handlerMap.get(typeEnum);
    }
}
