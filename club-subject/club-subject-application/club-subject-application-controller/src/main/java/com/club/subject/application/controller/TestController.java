package com.club.subject.application.controller;

import com.club.subject.common.entity.Resp;
import com.club.subject.domain.handler.subject.SubjectTypeHandler;
import com.club.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试控制器
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Resource
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;

    @GetMapping("/handler")
    public Resp testHandler(@RequestParam int subjectType) {
        try {
            SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectType);
            if (handler != null) {
                return Resp.success("找到处理器", handler.getClass().getSimpleName());
            } else {
                return Resp.error(500, "未找到处理器");
            }
        } catch (Exception e) {
            log.error("测试处理器失败", e);
            return Resp.error(500, "测试失败：" + e.getMessage());
        }
    }
}