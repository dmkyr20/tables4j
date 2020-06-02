package org.dmkyr20.cli.table;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.dmkyr20.cli.table.exceptions.CellContentException;
import org.dmkyr20.cli.table.types.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class TableBuilder {

    private final List<Cell> cells = new ArrayList<>();
    private TableTemplate tableTemplate;

    private int leftTopX;
    private int leftTopY;
    private int rightBottomX;
    private int rightBottomY;

    public TableBuilder addCell(String content, CellPosition position) throws CellContentException {
        Cell cell = new Cell(position, content);
        calculateSize(position);
        cells.add(cell);
        return this;
    }

    public TableBuilder addCell(Cell cell) {
        calculateSize(cell.getPosition());
        cells.add(cell);
        return this;
    }

    public String build() throws CellContentException {
        List<StringBuilder> table = createWhiteSheet();

        for (Cell cell : cells) {
             List<String> cellBlock = cell.getCell();
             CellPosition position = cell.getPosition();
             for (int i = position.getLeftTopY(), j = 0; i < cell.getPosition().getRightBottomY(); i++, j++) {
                 table.get(i).replace(position.getLeftTopX(), position.getRightBottomX(), cellBlock.get(j));
             }
        }

        return StringUtils.joinWith("\n", table.toArray());
    }

    public TableBuilder print() throws CellContentException {
        System.out.println(build());
        return this;
    }

    private List<StringBuilder> createWhiteSheet () {
        List<StringBuilder> sheet = new ArrayList<>();
        for (int i = leftTopY; i < rightBottomY; i++) {
            sheet.add(new StringBuilder(StringUtils.repeat(StringUtils.SPACE, rightBottomX - leftTopX)));
        }
        return sheet;
    }

    private void calculateSize(CellPosition position) {
        if (position.getLeftTopY() < leftTopY) {
            leftTopY = position.getLeftTopY();
        }
        if (position.getLeftTopX() < leftTopX) {
            leftTopX = position.getLeftTopX();
        }
        if (position.getRightBottomY() > rightBottomY) {
            rightBottomY = position.getRightBottomY();
        }
        if (position.getRightBottomX() > rightBottomX) {
            rightBottomX = position.getRightBottomX();
        }
    }
}
