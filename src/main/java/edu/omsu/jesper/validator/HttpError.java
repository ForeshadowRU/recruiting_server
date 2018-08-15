package edu.omsu.jesper.validator;

import org.springframework.http.HttpStatus;

import java.util.Map;
import java.util.Objects;

public class HttpError {
    private HttpStatus status = HttpStatus.BAD_REQUEST;
    private String message;
    private Map<String, String> errors;

    public HttpError() {
    }

    public HttpError(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpError(String message) {
        this.message = message;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HttpError error = (HttpError) o;
        return status == error.status &&
                Objects.equals(message, error.message) &&
                Objects.equals(errors, error.errors);
    }

    @Override
    public int hashCode() {

        return Objects.hash(status, message, errors);
    }

    @Override
    public String toString() {
        return "{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", errors=" + errors +
                '}';
    }
}
