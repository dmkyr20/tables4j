package org.dmkyr20.tables4j.tables.exceptions;

import org.dmkyr20.tables4j.tables.Cell;

/**
 * The {@link Cell} exception.
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
