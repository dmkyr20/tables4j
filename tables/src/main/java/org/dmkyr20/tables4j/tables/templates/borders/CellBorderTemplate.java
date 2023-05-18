package org.dmkyr20.tables4j.tables.templates.borders;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.dmkyr20.tables4j.tables.types.CellBorderStyle;

/**
 * Cell Borders simple templates.
 * You could add here any kind of your own templates if you often use it.
 * Use unicode chars: https://unicode-table.com/en/blocks/box-drawing/
 *
 * @author dmkyr20
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
            ' ', ' ', ' ', ' '), "NO_BORDERS"),
    EMPTY(new CellBorderStyle('\0', '\0', '\0', '\0',
            '\0', '\0', '\0', '\0'), "EMPTY");

    @Getter
    private final CellBorderStyle borderStyle;
    @Getter
    private final String name;

    public static CellBorderTemplate getBorders(String name) {
        switch (name) {
            case "CLASSIC":
                return CLASSIC;
            case "CLASSIC_WITH_STARS":
                return CLASSIC_WITH_STARS;
            case "STARS":
                return STARS;
            case "SOLID":
                return SOLID;
            case "NO_BORDERS":
                return NO_BORDERS;
            default:
                throw new RuntimeException("Unknown Cell Border Template Exception");
        }
    }
}
