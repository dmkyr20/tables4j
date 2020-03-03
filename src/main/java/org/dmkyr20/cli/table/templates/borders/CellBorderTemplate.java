package org.dmkyr20.cli.table.templates.borders;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.dmkyr20.cli.table.types.CellBorderStyle;

@RequiredArgsConstructor
public enum CellBorderTemplate {
    CLASSIC(new CellBorderStyle('|', '|', '-', '-', '-', '-' ,'-', '-')),
    CLASSIC_WITH_STARS(new CellBorderStyle('|', '|', '-', '-', '*', '*' ,'*', '*')),
    NO_BORDERS(new CellBorderStyle(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '));

    @Getter
    private final CellBorderStyle borderStyle;
}
