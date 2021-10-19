package com.rashcomps.rashcomputers.exceptions;

/**
 * @author : ntwari egide - Rash Computers
 * @description:  Lesson video not found exception handler
 */

public class LessonVideoNotFoundException extends RuntimeException {

    public LessonVideoNotFoundException(String message) {
        super(message);
    }

}
