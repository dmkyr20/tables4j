package org.dmkyr20.cli.table;

import org.dmkyr20.cli.table.exceptions.CellContentException;
import org.dmkyr20.cli.table.types.CellHorizontalAlignment;
import org.dmkyr20.cli.table.types.CellPosition;
import org.dmkyr20.cli.table.types.CellVerticalAlignment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CellTest {

    private static final CellPosition POSITION = new CellPosition();
    private static final String CONTENT = "Test String";

    @BeforeEach
    public void setupPosition() {
        POSITION.setLeftTopX(0);
        POSITION.setLeftTopY(0);
        POSITION.setRightBottomX(20);
        POSITION.setRightBottomY(3);
    }

    @Test
    public void getContentTest() throws CellContentException {
        Cell cell = new Cell(POSITION, CONTENT);
        Cell.printContent(cell);
    }

    @Test
    public void getCellTest() throws CellContentException {
        Cell cell = new Cell(POSITION, CONTENT);
        Cell.printCell(cell);
    }

    @Test
    public void shouldAlignContentWhenSetAlign() throws CellContentException {
        CellPosition position = new CellPosition();
        Cell cell = new Cell(POSITION, "Align");
        CellHorizontalAlignment[] horizontalAlignments = (CellHorizontalAlignment.class).getEnumConstants();
        for (CellHorizontalAlignment horizontalAlignment : horizontalAlignments) {
            CellVerticalAlignment[] verticalAlignments = (CellVerticalAlignment.class).getEnumConstants();
            for (CellVerticalAlignment verticalAlignment : verticalAlignments) {
                cell.setHorizontalAlignment(horizontalAlignment);
                cell.setVerticalAlignment(verticalAlignment);
                Cell.printCell(cell);
            }
        }
    }

    @Test
    public void shouldCreateEmptyCellWhenSetTextNull() throws CellContentException {
        final String content = null;
        Cell cell = new Cell(POSITION, content);
        cell.setContent(content);
        Cell.printCell(cell);
    }
}