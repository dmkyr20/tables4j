package org.dmkyr20.cli.table.types;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TableTemplate {
    private CellBorderStyle externalBorder, innerBorder, HeaderBorder;
    private int cellHeight = 1;
    private int cellWidth = 10;
}
