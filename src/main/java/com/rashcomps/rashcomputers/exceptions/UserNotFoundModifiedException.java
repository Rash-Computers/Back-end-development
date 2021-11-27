/**
 * @author: ntwari egide
 * @description: user not found modified exception handler
 */

package com.rashcomps.rashcomputers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundModifiedException extends RuntimeException {
    public UserNotFoundModifiedException(String invalid_credentials) {
        super(invalid_credentials);
    }
}
