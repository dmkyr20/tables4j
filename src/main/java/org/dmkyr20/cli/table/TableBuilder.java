package org.dmkyr20.cli.table;

import org.dmkyr20.cli.table.types.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TableBuilder {

    private final List<Cell> cells = new ArrayList<Cell>();
    private TableTemplate tableTemplate;

    public void addCell(String content, CellPosition position) {
        cells.add(new Cell(null, position, content, CellHorizontalAlignment.CENTER, CellVerticalAlignment.MIDDLE));
    }

    public String build() {

        char[][] table = char[][]
    }
}
