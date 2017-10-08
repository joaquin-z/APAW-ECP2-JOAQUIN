package es.upm.miw.authentication.api.resources.exceptions;

public class NameEmptyException extends Exception {

    private static final long serialVersionUID = 5501665868021214856L;
    public static final String DESCRIPTION = "El nombre no puede estar vacío";

    public NameEmptyException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public NameEmptyException() {
        this("");
    }

}
