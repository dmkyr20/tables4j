package org.dmkyr20.tables4j.tables.templates.borders;

import org.dmkyr20.tables4j.tables.Cell;
import org.dmkyr20.tables4j.tables.exceptions.CellContentException;
import org.dmkyr20.tables4j.tables.types.CellPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellBorderTemplateTest {

    private final CellPosition position = new CellPosition();
    private final String cellText = "Test String";

    @BeforeEach
    void setPosition() {
        this.position.setLeftTopX(0);
        this.position.setLeftTopY(0);
        this.position.setRightBottomX(22);
        this.position.setRightBottomY(4);
    }


    @Test
    public void TestShouldPrintAllTypeOfBorderTemplatesWhenRunTest() throws CellContentException {

        assertTrue(true);
        CellBorderTemplate[] borderTemplates = (CellBorderTemplate.class).getEnumConstants();
        for(CellBorderTemplate borderTemplate : borderTemplates)
        {
            System.out.println(borderTemplate.getName());
            printWithBorderType(borderTemplate);
            System.out.println();
        }


    }

    private void printWithBorderType(CellBorderTemplate cellBorderTemplate) throws CellContentException {
        Cell cell = new Cell(position, cellText);
        cell.setCellBorderStyle(cellBorderTemplate.getBorderStyle());
        Cell.printCell(cell);
    }
}