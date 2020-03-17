package org.dmkyr20.cli.table.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CellBorderStyle {
    private char leftBorderType, rightBorderType, topBorderType, bottomBorderType
            , leftTopCorner, rightTopCorner, leftBottomCorner, rightBottomCorner;

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

    public String surroundLine(String line) {
        return this.leftBorderType + line + this.rightBorderType;
    }
}
