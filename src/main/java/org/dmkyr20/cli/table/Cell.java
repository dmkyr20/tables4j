package org.dmkyr20.cli.table;

import lombok.*;
import org.dmkyr20.cli.table.exceptions.TooBigCellContentException;
import org.dmkyr20.cli.table.types.CellBorderStyle;
import org.dmkyr20.cli.table.types.CellHorizontalAlignment;
import org.dmkyr20.cli.table.types.CellPosition;
import org.dmkyr20.cli.table.types.CellVerticalAlignment;

import javax.swing.plaf.SplitPaneUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Use \n for content line separating
 */
@Getter
@Setter
@AllArgsConstructor
public class Cell {

    @NonNull
    private final CellBorderStyle cellBorderStyle;
    private final CellPosition position;
    private String text;

    @NonNull
    private CellHorizontalAlignment horizontalAlignment;
    @NonNull
    private CellVerticalAlignment verticalAlignment;

    public void setText(String text) throws TooBigCellContentException {
        Pattern nextLine = Pattern.compile("\n");
        int nextLineCount = 1;
        for (Matcher matcher = nextLine.matcher(text); matcher.find();) { nextLineCount++; }
        if (nextLineCount > (position.getRightBottomY() - position.getLeftTopY())) {
            throw new TooBigCellContentException(
                    "The content: " + text + " was too height for the cell: {" + this.toString() +
                    "}, the cell height is: " + (position.getLeftTopY() - position.getRightBottomY())
            );
        }
        if (text.replace("\n", "").length() > getMaxContentLength()) {
            throw new TooBigCellContentException(
                    "The content: " + text + "was too long for the cell: {" + this.toString() +
                    "}, the cell max length is: " + getMaxContentLength()
            );
        }

        this.text = text == null ? "" : text;
    }

    //TODO: add other positioning
    //TODO: rwrite with lambdas
    public List<String> getContent() throws TooBigCellContentException {
        List<String> textParts = Arrays.asList(text.split("\n"));
        List<String> cellContent = new ArrayList<String>();
        int maxLength = getWidth();
        if (verticalAlignment == CellVerticalAlignment.TOP) {
            if (horizontalAlignment == CellHorizontalAlignment.CENTER) {
                for (String part : textParts) {
                    StringBuilder line = new StringBuilder(part);
                    if (line.length() > maxLength) {
                        throw new TooBigCellContentException("The part of content: " + line.toString() +
                                " is too long. The max length for line is: " + maxLength);
                    }
                    StringBuilder spaces = new StringBuilder();
                    for (int i = 0; i < (maxLength - line.length()) / 2; i++) {
                        spaces.append(" ");
                    }
                    if ((maxLength - line.length()) % 2 == 1) {
                        line.append(" ");
                    }
                    cellContent.add(new StringBuilder().append(spaces).append(line).append(spaces).toString());
                }
            }
            else if (horizontalAlignment == CellHorizontalAlignment.LEFT) {
                for (String part: textParts) {
                    StringBuilder line = new StringBuilder(part);
                    if (line.length() > maxLength) {
                        throw new TooBigCellContentException("The part of content: " + line.toString() +
                                " is too long. The max length for line is: " + maxLength);
                    }
                    for (int i = 0; maxLength != line.length(); i++) {
                        line.append(" ");
                    }
                    cellContent.add(line.toString());
                }
            }
            else if (horizontalAlignment == CellHorizontalAlignment.RIGHT) {
                for (String part: textParts) {
                    StringBuilder line = new StringBuilder(part);
                    if (line.length() > maxLength) {
                        throw new TooBigCellContentException("The part of content: " + line.toString() +
                                " is too long. The max length for line is: " + maxLength);
                    }
                    for (int i = 0; maxLength != line.length(); i++) {
                        line.insert(0, " ");
                    }
                    cellContent.add(line.toString());
                }
            }
        }
        return cellContent;
    }

    public List<String> getCell() throws TooBigCellContentException {
        List<String> cellContent = getContent();
        List<String> cell = new ArrayList<String>();
        int realWidth = getRealWidth();
        StringBuilder sepLine = new StringBuilder();
        for (int i = 0; i < realWidth; i++) {
            if (i == 0) {
                sepLine.append(cellBorderStyle.getLeftTopCorner());
            } else if (i == realWidth - 1) {
                sepLine.append(cellBorderStyle.getRightTopCorner());
            } else {
                sepLine.append(cellBorderStyle.getTopBorderType());
            }
        }
        cell.add(sepLine.toString());
        for (String line : cellContent) {
            cell.add(cellBorderStyle.getLeftBorderType() + line + cellBorderStyle.getRightBorderType());
        }
        sepLine.setLength(0);
        for (int i = 0; i < realWidth; i++) {
            if (i == 0) {
                sepLine.append(cellBorderStyle.getLeftBottomCorner());
            } else if (i == realWidth - 1) {
                sepLine.append(cellBorderStyle.getRightBottomCorner());
            } else {
                sepLine.append(cellBorderStyle.getBottomBorderType());
            }
        }
        cell.add(sepLine.toString());
        return cell;
    }

    /**
     * Write the cell to System.out
     * @param cell Cell for printing
     * @throws TooBigCellContentException when the Content of cell is too big
     */
    public static void printCell(Cell cell) throws TooBigCellContentException {
        List<String> cellAsList = cell.getCell();
        for (String line : cellAsList) {
            System.out.println(line);
        }
    }

    /**
     * Write the cell content to System.out
     * @param cell Cell for printing
     * @throws TooBigCellContentException when the Content of cell is too big
     */
    public static void printContent(Cell cell) throws TooBigCellContentException {
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
}
