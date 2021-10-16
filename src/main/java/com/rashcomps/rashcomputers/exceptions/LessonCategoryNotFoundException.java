package com.rashcomps.rashcomputers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * @author : ntwari egide - Rash Computers
 * @description:  Lesson category not found exception handler
 */


@ResponseStatus(HttpStatus.NOT_FOUND)
public class LessonCategoryNotFoundException extends RuntimeException{

    public LessonCategoryNotFoundException(String message) {
        super(message);
    }

}
