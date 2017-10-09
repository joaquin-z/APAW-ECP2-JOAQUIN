package es.upm.miw.authentication.api.resources.exceptions;

public class UserInvalidException extends Exception {

    private static final long serialVersionUID = -3934953682860484996L;
    
    public static final String DESCRIPTION = "El ID debe ser un numero entero";

    public UserInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public UserInvalidException() {
        this("");
    }

}
