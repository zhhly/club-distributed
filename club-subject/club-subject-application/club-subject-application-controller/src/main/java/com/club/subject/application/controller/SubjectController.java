package com.club.subject.application.controller;

import com.club.subject.infra.basic.entity.SubjectCategory;
import com.club.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName com.club.subject.application.controller
 * @author zh
 * @version 1.0
 * @className SubjectController
 * @date 2025-08-16
 * @description TODO 刷题Controller
 */
@RestController
public class SubjectController {

    private final SubjectCategoryService subjectCategoryService;

    public SubjectController(SubjectCategoryService subjectCategoryService) {
        this.subjectCategoryService = subjectCategoryService;
    }

    @GetMapping("/test")
    public SubjectCategory test(){
        SubjectCategory subjectCategory = subjectCategoryService.queryById(1);
        return subjectCategory;
    }

}
