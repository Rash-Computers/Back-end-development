
/**
 * @author: ntwari egide
 * @desciption: course curriculum not found exception handler
 */

package com.rashcomps.rashcomputers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CourseCurriculumNotFoundException extends RuntimeException{
  public CourseCurriculumNotFoundException(String message){
    super(message);
  }
}
