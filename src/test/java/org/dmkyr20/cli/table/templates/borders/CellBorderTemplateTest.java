package org.dmkyr20.cli.table.templates.borders;

import org.dmkyr20.cli.table.Cell;
import org.dmkyr20.cli.table.exceptions.TooBigCellContentException;
import org.dmkyr20.cli.table.types.CellHorizontalAlignment;
import org.dmkyr20.cli.table.types.CellPosition;
import org.dmkyr20.cli.table.types.CellVerticalAlignment;
import org.junit.jupiter.api.Test;

import java.util.List;

class CellBorderTemplateTest {

    public CellBorderTemplateTest() {
        setPosition();
    }

    private final CellPosition position = new CellPosition();
    private final String cellText = "Test String";

    @Test
    public void testBorderCLASSIC() throws TooBigCellContentException {
        Cell cell = new Cell(CellBorderTemplate.CLASSIC.getBorderStyle(), position, cellText,
                CellHorizontalAlignment.RIGHT, CellVerticalAlignment.TOP);

        Cell.print(cell);
    }

    @Test
    public void testBorderCLASSIC_WITH_STARS() throws TooBigCellContentException {
        Cell cell = new Cell(CellBorderTemplate.CLASSIC_WITH_STARS.getBorderStyle(), position, cellText,
                CellHorizontalAlignment.RIGHT, CellVerticalAlignment.TOP);

        Cell.print(cell);
    }

    private void setPosition() {
        this.position.setLeftTopX(0);
        this.position.setLeftTopY(0);
        this.position.setRightBottomX(20);
        this.position.setRightBottomY(2);
    }
}