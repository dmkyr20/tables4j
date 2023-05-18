package org.dmkyr20.tables4j.tables;

import org.dmkyr20.tables4j.tables.exceptions.CellContentException;
import org.dmkyr20.tables4j.tables.types.CellHorizontalAlignment;
import org.dmkyr20.tables4j.tables.types.CellPosition;
import org.dmkyr20.tables4j.tables.types.CellVerticalAlignment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Simple tests for {@link Cell}
 * @author dmkyr20
 */
public class CellTest {

    private static final CellPosition POSITION = new CellPosition();
    private static final String ALIGN_CONTENT_TEST = "Align";

    @BeforeEach
    public void setupPosition() {
        POSITION.setLeftTopX(0);
        POSITION.setLeftTopY(0);
        POSITION.setRightBottomX(20);
        POSITION.setRightBottomY(5);
    }

    @Test
    public void shouldAlignContentWhenSetAlign() throws CellContentException {
        Cell cell = new Cell(POSITION, ALIGN_CONTENT_TEST);

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
}