package org.dmkyr20.cli.table;

import org.dmkyr20.cli.table.exceptions.TooBigCellContentException;
import org.dmkyr20.cli.table.templates.borders.CellBorderTemplate;
import org.dmkyr20.cli.table.types.CellBorderStyle;
import org.dmkyr20.cli.table.types.CellHorizontalAlignment;
import org.dmkyr20.cli.table.types.CellPosition;
import org.dmkyr20.cli.table.types.CellVerticalAlignment;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    public void getContentTest() throws TooBigCellContentException {
        CellPosition position = new CellPosition();
        position.setLeftTopX(0);
        position.setLeftTopY(0);
        position.setRightBottomX(20);
        position.setRightBottomY(2);

        CellBorderStyle borderStyle = new CellBorderStyle();
        borderStyle.setBottomBorderType('-');
        borderStyle.setLeftBorderType('|');
        borderStyle.setLeftBottomCorner('*');
        borderStyle.setLeftTopCorner('*');
        borderStyle.setRightBorderType('|');
        borderStyle.setRightBottomCorner('*');
        borderStyle.setRightTopCorner('*');
        borderStyle.setTopBorderType('-');

        String content = "Test string";

        Cell cell = new Cell(borderStyle, position, content,
                CellHorizontalAlignment.CENTER, CellVerticalAlignment.TOP);

        List<String> content1 = cell.getContent();
        for (String line : content1) {
            System.out.println(line);
        }
    }

    @Test
    public void getCellTest() throws TooBigCellContentException {
        CellPosition position = new CellPosition();
        position.setLeftTopX(0);
        position.setLeftTopY(0);
        position.setRightBottomX(20);
        position.setRightBottomY(2);

        CellBorderStyle borderStyle = new CellBorderStyle();
        borderStyle.setBottomBorderType('-');
        borderStyle.setLeftBorderType('|');
        borderStyle.setLeftBottomCorner('*');
        borderStyle.setLeftTopCorner('*');
        borderStyle.setRightBorderType('|');
        borderStyle.setRightBottomCorner('*');
        borderStyle.setRightTopCorner('*');
        borderStyle.setTopBorderType('-');

        String content = "Test strings";

        Cell cell = new Cell(borderStyle, position, content,
                CellHorizontalAlignment.CENTER, CellVerticalAlignment.TOP);

        List<String> content1 = cell.getCell();
        for (String line : content1) {
            System.out.println(line);
        }
    }

    @Test
    public void getCellRightLeftTest() throws TooBigCellContentException {
        CellPosition position = new CellPosition();
        position.setLeftTopX(0);
        position.setLeftTopY(0);
        position.setRightBottomX(20);
        position.setRightBottomY(2);

        CellBorderStyle borderStyle = CellBorderTemplate.CLASSIC.getBorderStyle();

        String rightContent = "Right test";
        String leftContent = "Left content";

        Cell cell = new Cell(borderStyle, position, rightContent, CellHorizontalAlignment.RIGHT, CellVerticalAlignment.TOP);
        Cell.print(cell);

        cell.setHorizontalAlignment(CellHorizontalAlignment.LEFT);
        cell.setText(leftContent);
        Cell.print(cell);
    }
}