package org.dmkyr20.cli.table.types;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CellPosition {
    private int leftTopX, leftTopY, rightBottomX, rightBottomY;
}
