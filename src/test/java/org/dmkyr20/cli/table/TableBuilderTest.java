package org.dmkyr20.cli.table;

import org.dmkyr20.cli.table.exceptions.CellContentException;
import org.dmkyr20.cli.table.types.CellPosition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableBuilderTest {

    private TableBuilder tableBuilder;

    @BeforeEach
    public void init() {
        tableBuilder = new TableBuilder();
    }

    @Test
    public void test() throws CellContentException {
        CellPosition firsCell = new CellPosition(0, 0, 10, 10);
        tableBuilder.addCell("test", firsCell);
        CellPosition secondCell = new CellPosition(9, 9, 20, 20);
        tableBuilder.addCell("test1", secondCell);
        CellPosition thirstCell = new CellPosition(19, 0, 30, 10);
        tableBuilder.addCell("test3", thirstCell);

        tableBuilder.print();
    }

    @Test
    public void shouldReturnError() throws CellContentException {
        CellPosition firstCell = new CellPosition(0, 0, 2, 2);
        tableBuilder.addCell("Bigtest", firstCell);

        tableBuilder.print();
    }

}