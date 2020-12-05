package com.springboot.custom.exception;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "error")
public class ErrorResponse 
{
	public ErrorResponse()
	{
		
	}
    public ErrorResponse(String message, List<String> details) {
        super();
        this.error = message;
        this.details = details;
    }
 
    //General error message about nature of error
    private String error;
 
    //Specific errors in API request processing
    private List<String> details;
 
    //Getter and setters
    public String getError() {
		return error;
	}

	public void setError(String message) {
		this.error = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}
}