package com.club.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目答案
 *
 * @author makejava
 * @since 2025-08-24 19:23:07
 */
@Data
public class SubjectAnswerDTO implements Serializable {
    private static final long serialVersionUID = 958974743486505962L;
    /**
     * 答案选项标识
     */
    private Integer optionType;
    /**
     * 答案
     */
    private String optionContent;
    /**
     * 是否正确
     */
    private Integer isCorrect;

}

