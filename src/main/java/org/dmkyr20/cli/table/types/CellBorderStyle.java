package org.dmkyr20.cli.table.types;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CellBorderStyle {
    private char leftBorderType, rightBorderType, topBorderType, bottomBorderType
            , leftTopCorner, rightTopCorner, leftBottomCorner, rightBottomCorner;
}
