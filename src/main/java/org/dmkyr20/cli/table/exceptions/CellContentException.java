package org.dmkyr20.cli.table.exceptions;

public class CellContentException extends Throwable {

    public CellContentException(String s) {
        super(s);
    }

    @Override
    public String getMessage() {
        return "CellException: " + super.getMessage();
    }
}
