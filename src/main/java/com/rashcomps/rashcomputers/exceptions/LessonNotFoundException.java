package com.rashcomps.rashcomputers.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author : ntwari egide - Rash Computers
 * @description:  Lesson not found exception handler
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LessonNotFoundException extends RuntimeException{
    public LessonNotFoundException(String message) {
        super(message);
    }
}
