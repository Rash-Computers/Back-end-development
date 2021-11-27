
/**
 * @author: ntwari egide
 * @desciption: lesson video not found exception handler
 */

package com.rashcomps.rashcomputers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LessonVideoNotFoundException extends RuntimeException{
  public LessonVideoNotFoundException(String message){
    super(message);
  }
}
