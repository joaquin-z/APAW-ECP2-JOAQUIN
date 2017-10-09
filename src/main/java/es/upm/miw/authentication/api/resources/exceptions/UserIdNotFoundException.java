package es.upm.miw.authentication.api.resources.exceptions;

public class UserIdNotFoundException extends Exception {

    private static final long serialVersionUID = 7528615336955285972L;
    
    public static final String DESCRIPTION = "El usuario no ha sido encontrado";

    public UserIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public UserIdNotFoundException() {
        this("");
    }

}
