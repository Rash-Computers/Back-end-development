
/**
 * @author: ntwari egide
 * @desciption: course instructor not found exception handler
 */

package com.rashcomps.rashcomputers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CourseInstructorNotFoundException extends RuntimeException{
  public CourseInstructorNotFoundException(String message){
    super(message);
  }
}
