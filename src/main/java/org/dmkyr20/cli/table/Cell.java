package org.dmkyr20.cli.table;

import lombok.*;
import org.dmkyr20.cli.table.exceptions.TooBigCellContentException;
import org.dmkyr20.cli.table.types.CellBorderStyle;
import org.dmkyr20.cli.table.types.CellHorizontalAlignment;
import org.dmkyr20.cli.table.types.CellPosition;
import org.dmkyr20.cli.table.types.CellVerticalAlignment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@AllArgsConstructor
public class Cell {

    @NonNull
    private final CellBorderStyle cellBorderStyle;
    private final CellPosition cellPosition;
    private String text;

    @NonNull
    private CellHorizontalAlignment horizontalAlignment;
    @NonNull
    private CellVerticalAlignment verticalAlignment;

    public void setText(String text) throws TooBigCellContentException {
        Pattern nextLine = Pattern.compile("\n");
        int nextLineCount = 1;
        for (Matcher matcher = nextLine.matcher(text); matcher.find();) { nextLineCount++; }
        if (nextLineCount > (cellPosition.getRightBottomY() - cellPosition.getLeftTopY())) {
            throw new TooBigCellContentException(
                    "The content: " + text + " was too height for the cell: {" + this.toString() +
                    "}, the cell height is: " + (cellPosition.getLeftTopY() - cellPosition.getRightBottomY())
            );
        }
        if (text.length() > getMaxContentLength()) {
            throw new TooBigCellContentException(
                    "The content: " + text + "was too long for the cell: {" + this.toString() +
                    "}, the cell max length is: " + getMaxContentLength()
            );
        }

        this.text = text == null ? "" : text;
    }

    public int getMaxContentLength() {
        return getHeight() * getWidth();
    }

    public int getHeight() {
        return cellPosition.getRightBottomX() - cellPosition.getLeftTopX();
    }

    public int getWidth() {
        return cellPosition.getRightBottomY() - cellPosition.getLeftTopY();
    }
}
