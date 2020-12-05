package com.springboot.custom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@ResponseStatus(HttpStatus.CONFLICT)
public class RecordNotFoundException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;
	
	java.util.List data;
	
    public RecordNotFoundException(String exception) {
        super(exception);
    }
    
    public RecordNotFoundException(String err , java.util.List exception) {
       // super(exception);
    	super(err);
    	this.data = exception;
    }
}
