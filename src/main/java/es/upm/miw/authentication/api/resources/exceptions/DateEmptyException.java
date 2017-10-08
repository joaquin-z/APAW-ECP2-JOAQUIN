package es.upm.miw.authentication.api.resources.exceptions;

public class DateEmptyException extends Exception {

    private static final long serialVersionUID = -4858586702180345703L;
    public static final String DESCRIPTION = "La fecha de nacimiento no puede estar vacía";

    public DateEmptyException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public DateEmptyException() {
        this("");
    }

}
