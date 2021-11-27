
/**
 * @author: ntwari egide
 * @desciption: school not found exception handler
 */

package com.rashcomps.rashcomputers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SchoolOutlineNotFoundException extends RuntimeException{
  public SchoolOutlineNotFoundException(String message){
    super(message);
  }
}
