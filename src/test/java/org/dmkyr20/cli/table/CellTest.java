package org.dmkyr20.cli.table;

import org.dmkyr20.cli.table.exceptions.TooBigCellContentException;
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
                CellHorizontalAlignment.RIGHT, CellVerticalAlignment.TOP);

        List<String> content1 = cell.getContent();
        for (String line : content1) {
            System.out.println(line);
        }
    }
}