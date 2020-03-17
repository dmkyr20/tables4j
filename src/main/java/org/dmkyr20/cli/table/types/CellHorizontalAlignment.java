package org.dmkyr20.cli.table.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.BiFunction;

@RequiredArgsConstructor
public enum CellHorizontalAlignment {
    LEFT((maxLength, line) -> {
        while (maxLength != line.length()) {
            line.append(" ");
        }
        return line.toString();
    }),
    CENTER((maxLength, line) -> {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < (maxLength - line.length()) / 2; i++) {
            spaces.append(" ");
        }
        if ((maxLength - line.length()) % 2 == 1) {
            line.append(" ");
        }
        return String.valueOf(spaces) + line + spaces;
    }),
    RIGHT((maxLength, line) -> {
        while (maxLength != line.length()) {
            line.insert(0, " ");
        }
        return line.toString();
    });

    @Getter
    private final BiFunction<Integer, StringBuilder, String> function;
}
