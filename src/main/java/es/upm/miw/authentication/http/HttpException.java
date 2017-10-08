package es.upm.miw.authentication.http;

public class HttpException extends RuntimeException {
    private static final long serialVersionUID = -5216295603814526456L;

    public HttpException(String msg) {
        super(msg);
    }

}
