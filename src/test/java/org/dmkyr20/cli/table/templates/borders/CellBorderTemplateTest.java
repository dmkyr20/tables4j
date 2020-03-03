package org.dmkyr20.cli.table.templates.borders;

import org.dmkyr20.cli.table.Cell;
import org.dmkyr20.cli.table.exceptions.TooBigCellContentException;
import org.dmkyr20.cli.table.types.CellHorizontalAlignment;
import org.dmkyr20.cli.table.types.CellPosition;
import org.dmkyr20.cli.table.types.CellVerticalAlignment;
import org.junit.jupiter.api.Test;

import java.util.List;

class CellBorderTemplateTest {

    @Test
    public void testBorderCLASSIC() throws TooBigCellContentException {
        CellPosition position = new CellPosition();
        position.setLeftTopX(0);
        position.setLeftTopY(0);
        position.setRightBottomX(20);
        position.setRightBottomY(2);

        String content = "Test strings";

        Cell cell = new Cell(CellBorderTemplate.CLASSIC.getBorderStyle(), position, content,
                CellHorizontalAlignment.RIGHT, CellVerticalAlignment.TOP);

        List<String> content1 = cell.getCell();
        for (String line : content1) {
            System.out.println(line);
        }
    }

    @Test
    public void testBorderCLASSIC_WITH_STARS() throws TooBigCellContentException {
        CellPosition position = new CellPosition();
        position.setLeftTopX(0);
        position.setLeftTopY(0);
        position.setRightBottomX(20);
        position.setRightBottomY(2);

        String content = "Test strings";

        Cell cell = new Cell(CellBorderTemplate.CLASSIC_WITH_STARS.getBorderStyle(), position, content,
                CellHorizontalAlignment.RIGHT, CellVerticalAlignment.TOP);

        List<String> content1 = cell.getCell();
        for (String line : content1) {
            System.out.println(line);
        }
    }
}