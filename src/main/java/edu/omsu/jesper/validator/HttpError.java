package edu.omsu.jesper.validator;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class HttpError {

    private HttpStatus status = HttpStatus.BAD_REQUEST;
    private String message;
    private Map<String, String> errors;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
