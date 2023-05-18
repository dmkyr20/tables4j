package org.dmkyr20.tables4j.tables.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.dmkyr20.tables4j.tables.Cell;

/**
 * The class describe a cell border style and used for creating styled borders of a cell
 *
 * @author dmkyr20
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CellBorderStyle {
    private char leftBorderType, rightBorderType, topBorderType, bottomBorderType
            , leftTopCorner, rightTopCorner, leftBottomCorner, rightBottomCorner;

    /**
     * Write top border for line
     * @param width of the {@link Cell}
     * @return top line for {@link Cell}
     */
    public String writeTopLine(int width) {
        StringBuilder sepLine = new StringBuilder();
        for (int i = 0; i < width; i++) {
            if (i == 0) {
                sepLine.append(this.leftTopCorner);
            } else if (i == width - 1) {
                sepLine.append(this.rightTopCorner);
            } else {
                sepLine.append(this.getTopBorderType());
            }
        }
        return sepLine.toString();
    }

    /**
     * Write bottom border for line
     * @param width of the {@link Cell}
     * @return bottom line for {@link Cell}
     */
    public String writeBottomLine(int width) {
        StringBuilder sepLine = new StringBuilder();
        for (int i = 0; i < width; i++) {
            if (i == 0) {
                sepLine.append(this.leftBottomCorner);
            } else if (i == width - 1) {
                sepLine.append(this.rightBottomCorner);
            } else {
                sepLine.append(this.bottomBorderType);
            }
        }
        return sepLine.toString();
    }

    /**
     * Suraund cell line wih borders
     * @param line line to surround with borders
     * @return line ready to use in {@link Cell}
     */
    public String surroundLine(String line) {
        return this.leftBorderType + line + this.rightBorderType;
    }
}
