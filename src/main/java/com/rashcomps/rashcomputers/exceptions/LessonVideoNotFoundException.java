package com.rashcomps.rashcomputers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author : ntwari egide - Rash Computers
 * @description:  Lesson video not found exception handler
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LessonVideoNotFoundException extends RuntimeException {

    public LessonVideoNotFoundException(String message) {
        super(message);
    }

}
