package org.dmkyr20.cli.table.templates.borders;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.dmkyr20.cli.table.types.CellBorderStyle;

/**
 * Cell Borders simple templates
 * Unicode chars: https://unicode-table.com/en/blocks/box-drawing/
 */
@RequiredArgsConstructor
public enum CellBorderTemplate {
    CLASSIC(new CellBorderStyle('|', '|', '-', '-',
            '-', '-' ,'-', '-'), "CLASSIC"),
    CLASSIC_WITH_STARS(new CellBorderStyle('|', '|', '-', '-',
            '*', '*' ,'*', '*'), "CLASSIC_WITH_STARS"),
    STARS(new CellBorderStyle('*', '*', '*', '*',
            '*', '*' ,'*', '*'), "STARS"),
    SOLID(new CellBorderStyle('│', '│', '─', '─',
            '┌', '┐' ,'└', '┘'), "SOLID"),
    NO_BORDERS(new CellBorderStyle(' ', ' ', ' ', ' ',
            ' ', ' ', ' ', ' '), "NO_BORDERS");

    @Getter
    private final CellBorderStyle borderStyle;
    @Getter
    private final String name;
}
