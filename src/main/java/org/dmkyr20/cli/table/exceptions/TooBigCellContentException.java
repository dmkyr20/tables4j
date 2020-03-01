package org.dmkyr20.cli.table.exceptions;

public class TooBigCellContentException extends Throwable {

    public TooBigCellContentException(String s) {
        super(s);
    }

    @Override
    public String getMessage() {
        return "TooBigCellException: " + super.getMessage();
    }
}
