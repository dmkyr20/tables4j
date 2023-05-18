package org.dmkyr20.tables4j.tables.types;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The future feature. Isn't available now.
 *
 * @author dmkyr20
 */
@Deprecated
@Getter
@Setter
@NoArgsConstructor
public class TableTemplate {
    private CellBorderStyle externalBorder, innerBorder, HeaderBorder;
    private int cellHeight = 1;
    private int cellWidth = 10;
}
