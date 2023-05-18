package org.dmkyr20.tables4j.prolots.exceptions;

public class GraphicException extends RuntimeException {
    public GraphicException() {
        super();
    }

    public GraphicException(String message) {
        super(message);
    }

    public GraphicException(String message, Throwable cause) {
        super(message, cause);
    }

    public GraphicException(Throwable cause) {
        super(cause);
    }

    protected GraphicException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
