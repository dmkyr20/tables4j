package org.dmkyr20.cli.table;

import org.dmkyr20.cli.table.exceptions.TooBigCellContentException;
import org.dmkyr20.cli.table.templates.borders.CellBorderTemplate;
import org.dmkyr20.cli.table.types.CellBorderStyle;
import org.dmkyr20.cli.table.types.CellHorizontalAlignment;
import org.dmkyr20.cli.table.types.CellPosition;
import org.dmkyr20.cli.table.types.CellVerticalAlignment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CellTest {

    private static final CellBorderStyle BORDER_STYLE = CellBorderTemplate.CLASSIC.getBorderStyle();
    private static final CellPosition POSITION = new CellPosition();
    private static final String CONTENT = "Test String";

    @BeforeEach
    public void setupPosition() {
        POSITION.setLeftTopX(0);
        POSITION.setLeftTopY(0);
        POSITION.setRightBottomX(20);
        POSITION.setRightBottomY(2);
    }

    @Test
    public void getContentTest() throws TooBigCellContentException {
        Cell cell = new Cell(BORDER_STYLE, POSITION, CONTENT,
                CellHorizontalAlignment.CENTER, CellVerticalAlignment.TOP);
        Cell.printContent(cell);
    }

    @Test
    public void getCellTest() throws TooBigCellContentException {
        Cell cell = new Cell(BORDER_STYLE, POSITION, CONTENT,
                CellHorizontalAlignment.CENTER, CellVerticalAlignment.TOP);
        Cell.printCell(cell);
    }

    @Test
    public void getCellRightLeftTest() throws TooBigCellContentException {
        String rightContent = "Right test";
        String leftContent = "Left content";

        Cell cell = new Cell(BORDER_STYLE, POSITION, rightContent,
                CellHorizontalAlignment.RIGHT, CellVerticalAlignment.TOP);
        Cell.printCell(cell);

        cell.setHorizontalAlignment(CellHorizontalAlignment.LEFT);
        cell.setText(leftContent);
        Cell.printCell(cell);
    }
}