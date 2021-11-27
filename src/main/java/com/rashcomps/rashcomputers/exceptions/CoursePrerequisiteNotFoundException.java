
/**
 * @author: ntwari egide
 * @desciption: prerequisite not found exception handler
 */

package com.rashcomps.rashcomputers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CoursePrerequisiteNotFoundException extends RuntimeException{
  public CoursePrerequisiteNotFoundException(String message){
    super(message);
  }
}
