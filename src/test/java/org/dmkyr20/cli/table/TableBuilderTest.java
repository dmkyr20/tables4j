package org.dmkyr20.cli.table;

import org.dmkyr20.cli.table.exceptions.CellContentException;
import org.dmkyr20.cli.table.types.CellPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.StringUtils;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Simple tests for {@link TableBuilder}
 * @author dmkyr20
 */
class TableBuilderTest {

    private TableBuilder tableBuilder;
    private final static String TEST_CONTENT = "Test";
    private final static String TEST_ERROR_CONTENT = "Too Long Test Text";

    @BeforeEach
    public void init() {
        tableBuilder = new TableBuilder();
    }

    @Test
    public void shouldCreateCellByCoordinatesXL0YL0XR10LR10() throws CellContentException {
        CellPosition positionX0Y0 = new CellPosition(0, 0, 10, 10);
        tableBuilder.addCell(TEST_CONTENT, positionX0Y0);

        String table = tableBuilder.build();

        assertNotEquals(Character.toString(table.charAt(0)), StringUtils.SPACE);
        assertNotEquals(Character.toString(table.charAt(100)), StringUtils.SPACE);
    }

    @Test
    public void shouldCreateCellByCoordinatesXL1YL1XR10YR10() throws CellContentException {
        CellPosition positionX1Y1 = new CellPosition(1, 1, 10, 10);
        tableBuilder.addCell(TEST_CONTENT, positionX1Y1);

        String table = tableBuilder.build();

        assertEquals(Character.toString(table.charAt(0)), StringUtils.SPACE);
        assertNotEquals(Character.toString(table.charAt(12)), StringUtils.SPACE);
        assertNotEquals(Character.toString(table.charAt(108)), StringUtils.SPACE);
    }

    @Test
    public void shouldAddedCellUsingCellClass() throws CellContentException {
        Cell cell = new Cell(new CellPosition(0, 0, 10, 10));

        tableBuilder.addCell(cell);

        assertFalse(tableBuilder.build().isEmpty());
    }

    @Test
    public void shouldReturnErrorWhenCellContentIsTooLongError() {
        CellPosition cellPosition = new CellPosition(0, 0, 2, 2);

        assertThrows(CellContentException.class, () -> tableBuilder.addCell(TEST_ERROR_CONTENT, cellPosition));
    }

}