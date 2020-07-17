package org.dmkyr20.cli.table.exceptions;

/**
 * The {@link org.dmkyr20.cli.table.Cell} exception.
 *
 * @author dmkyr20
 */
public class CellContentException extends Throwable {

    public CellContentException(String s) {
        super(s);
    }

    @Override
    public String getMessage() {
        return "CellException: " + super.getMessage();
    }
}
