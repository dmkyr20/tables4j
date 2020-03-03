package org.dmkyr20.cli.table.templates.borders;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.dmkyr20.cli.table.Cell;
import org.dmkyr20.cli.table.exceptions.TooBigCellContentException;
import org.dmkyr20.cli.table.types.CellHorizontalAlignment;
import org.dmkyr20.cli.table.types.CellPosition;
import org.dmkyr20.cli.table.types.CellVerticalAlignment;
import org.junit.jupiter.api.Test;

class CellBorderTemplateTest {

    public CellBorderTemplateTest() {
        setPosition();
    }

    private final CellPosition position = new CellPosition();
    private final String cellText = "Test String";

    @Ignore
    @Test
    public void shouldPrintAllTypeOfBorderTemplatesWhenRun() throws TooBigCellContentException {
        CellBorderTemplate[] borderTemplates = (CellBorderTemplate.class).getEnumConstants();
        for(CellBorderTemplate borderTemplate : borderTemplates)
        {
            System.out.println(borderTemplate.getName());
            printWithBorderType(borderTemplate);
            System.out.println();
        }
    }

    private void setPosition() {
        this.position.setLeftTopX(0);
        this.position.setLeftTopY(0);
        this.position.setRightBottomX(20);
        this.position.setRightBottomY(2);
    }

    private void printWithBorderType(CellBorderTemplate cellBorderTemplate) throws TooBigCellContentException {
        Cell cell = new Cell(cellBorderTemplate.getBorderStyle(), position, cellText,
                CellHorizontalAlignment.RIGHT, CellVerticalAlignment.TOP);

        Cell.print(cell);
    }
}