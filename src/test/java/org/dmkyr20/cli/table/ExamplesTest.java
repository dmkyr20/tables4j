package org.dmkyr20.cli.table;

import lombok.ToString;
import org.dmkyr20.cli.table.exceptions.CellContentException;
import org.dmkyr20.cli.table.templates.borders.CellBorderTemplate;
import org.dmkyr20.cli.table.types.CellHorizontalAlignment;
import org.dmkyr20.cli.table.types.CellPosition;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

public class ExamplesTest {

    private static final String HEADER = "█▀▀ █░░ ░▀░         █▀▀▀ █▀▀█ █▀▄▀█ █▀▀\n" +
                                        "█░░ █░░ ▀█▀         █░▀█ █▄▄█ █░▀░█ █▀▀\n" +
                                        "▀▀▀ ▀▀▀ ▀▀▀         ▀▀▀▀ ▀░░▀ ▀░░░▀ ▀▀▀";
    private static final String NOTE = "Note: Pres number key to choose.";

    @Test
    @Ignore
    public void simpleOutput() throws CellContentException {
        TableBuilder tableBuilder = new TableBuilder();
        tableBuilder.setDefaultCellBorderStyle(CellBorderTemplate.SOLID.getBorderStyle());

        tableBuilder.addCell(HEADER, new CellPosition(0, 0, 100, 12));
        tableBuilder.addCell("1 - Start", new CellPosition(0, 12, 25, 15));
        tableBuilder.addCell("2 - Load", new CellPosition(25, 12, 50, 15));
        tableBuilder.addCell("5 - Settings", new CellPosition(50, 12, 75, 15));
        tableBuilder.addCell("6 - Exit", new CellPosition(75, 12, 100, 15));

        tableBuilder.print();
    }

    @Test
//    @Ignore
    public void simpleOutputWithNote() throws CellContentException {
        TableBuilder tableBuilder = new TableBuilder();
        tableBuilder.setDefaultCellBorderStyle(CellBorderTemplate.SOLID.getBorderStyle());

        tableBuilder.addCell(HEADER, new CellPosition(0, 0, 100, 12));
        tableBuilder.addCell("1 - Start", new CellPosition(0, 12, 25, 15));
        tableBuilder.addCell("2 - Load", new CellPosition(25, 12, 50, 15));
        tableBuilder.addCell("5 - Settings", new CellPosition(50, 12, 75, 15));
        tableBuilder.addCell("6 - Exit", new CellPosition(75, 12, 100, 15));

        Cell note = new Cell(new CellPosition(1, 8, 90, 11), NOTE);
        note.setCellBorderStyle(CellBorderTemplate.NO_BORDERS.getBorderStyle());
        note.setHorizontalAlignment(CellHorizontalAlignment.LEFT);
        tableBuilder.addCell(note);

        tableBuilder.print();
    }
}
