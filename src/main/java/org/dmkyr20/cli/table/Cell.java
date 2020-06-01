package org.dmkyr20.cli.table;

import java.util.Arrays;
import java.util.function.BiFunction;

import lombok.*;
import org.dmkyr20.cli.table.exceptions.CellContentException;
import org.dmkyr20.cli.table.templates.borders.CellBorderTemplate;
import org.dmkyr20.cli.table.types.CellBorderStyle;
import org.dmkyr20.cli.table.types.CellHorizontalAlignment;
import org.dmkyr20.cli.table.types.CellPosition;
import org.dmkyr20.cli.table.types.CellVerticalAlignment;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Use \n for content line separating
 */
@Getter
@Setter
@RequiredArgsConstructor
public class Cell {

    public Cell(CellPosition position, String content) throws CellContentException {
        this.position = position;
        setContent(content);
    }

    @NonNull
    private CellPosition position;
    private String content = "";

    private CellBorderStyle cellBorderStyle = CellBorderTemplate.CLASSIC.getBorderStyle();
    private CellHorizontalAlignment horizontalAlignment = CellHorizontalAlignment.CENTER;
    private CellVerticalAlignment verticalAlignment = CellVerticalAlignment.MIDDLE;

    public void setContent(String content) throws CellContentException {
        content = content == null ? " " : content;
        Pattern nextLine = Pattern.compile("\n");
        int nextLineCount = 1;
        for (Matcher matcher = nextLine.matcher(content); matcher.find();) { nextLineCount++; }
        if (nextLineCount > (position.getRightBottomY() - position.getLeftTopY())) {
            throw new CellContentException(
                    "The content: " + content + " was too height for the cell: {" + this.toString() +
                    "}, the cell height is: " + (position.getLeftTopY() - position.getRightBottomY())
            );
        }
        if (content.replace("\n", "").length() > getMaxContentLength()) {
            throw new CellContentException(
                    "The content: " + content + "was too long for the cell: {" + this.toString() +
                    "}, the cell max length is: " + getMaxContentLength()
            );
        }

        this.content = content;
    }

    public List<String> getContent() throws CellContentException {
        List<String> textParts = new ArrayList<>(Arrays.asList(content.split("\n")));
        textParts = verticalAlignment.getFunction().apply(textParts, getHeight());
        return alignWithHorizon(textParts, getWidth(), horizontalAlignment.getFunction());
    }

    public List<String> getCell() throws CellContentException {
        List<String> cellContent = getContent();
        List<String> cell = new ArrayList<>();
        int realWidth = getRealWidth();
        cell.add(cellBorderStyle.writeTopLine(realWidth));
        for (String line : cellContent) {
            cell.add(cellBorderStyle.surroundLine(line));
        }
        cell.add(cellBorderStyle.writeBottomLine(realWidth));
        return cell;
    }

    /**
     * Write the cell to System.out
     * @param cell Cell for printing
     * @throws CellContentException when the Content of cell is too big
     */
    public static void printCell(Cell cell) throws CellContentException {
        List<String> cellAsList = cell.getCell();
        for (String line : cellAsList) {
            System.out.println(line);
        }
    }

    /**
     * Write the cell content to System.out
     * @param cell Cell for printing
     * @throws CellContentException when the Content of cell is too big
     */
    public static void printContent(Cell cell) throws CellContentException {
        List<String> cellContent = cell.getContent();
        for (String line : cellContent) {
            System.out.println(line);
        }
    }

    public int getMaxContentLength() {
        return getHeight() * getWidth();
    }

    public int getHeight() {
        return position.getRightBottomY() - position.getLeftTopY();
    }

    public int getWidth() {
        return position.getRightBottomX() - position.getLeftTopX();
    }

    public int getRealHeight() {
        return getHeight() + 2;
    }

    public int getRealWidth() {
        return getWidth() + 2;
    }

    private List<String> alignWithHorizon(List<String> textParts, int maxLength,
                                          BiFunction<Integer, StringBuilder, String> horizontalAlignmentFunction)
            throws CellContentException {
        List<String> cellContent = new ArrayList<>();
        for (String part : textParts) {
            StringBuilder line = new StringBuilder(part);
            if (line.length() > maxLength) {
                throw new CellContentException("The part of content: " + line.toString() +
                        " is too long. The max length for line is: " + maxLength);
            }
            cellContent.add(horizontalAlignmentFunction.apply(maxLength, line));
        }
        return cellContent;
    }
}
