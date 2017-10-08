package es.upm.miw.authentication.api.resources.exceptions;

public class RequestInvalidException extends Exception {
    private static final long serialVersionUID = 1077002349825272753L;
    
    public static final String DESCRIPTION = "Petición no implementada";

    public RequestInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public RequestInvalidException() {
        this("");
    }
}