package org.dmkyr20.cli.table;

import org.dmkyr20.cli.table.exceptions.CellContentException;
import org.dmkyr20.cli.table.types.*;

import java.util.ArrayList;
import java.util.List;

// TODO
public class TableBuilder {

    private final List<Cell> cells = new ArrayList<Cell>();
    private TableTemplate tableTemplate;
    private StringBuilder table = new StringBuilder();

    // TODO: Add cell alignment
    public void addCell(String content, CellPosition position) throws CellContentException {
        Cell cell = new Cell(position, content);
        cells.add(cell);
//        if (StringBuilder)
    }

    public String build() {
        StringBuilder table = new StringBuilder();
        for (Cell cell : cells) {
             table.insert(5, "test");
        }
        return null;
    }
}
