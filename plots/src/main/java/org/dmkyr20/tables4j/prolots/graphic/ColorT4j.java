package org.dmkyr20.tables4j.prolots.graphic;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ColorT4j {
    private final int rgb;

    public ColorT4j(int red, int green, int blue) {
        int rgb = 0;

        rgb |= blue;
        rgb |= green << 8;
        rgb |= red << 16;

        this.rgb = rgb | 0xFF000000;;
    }

    public int getRed() {
        return (rgb & 0x00FF0000) >> 16;
    }

    public int getGreen() {
        return (rgb & 0x0000FF00) >> 8;
    }

    public int getBlue() {
        return rgb & 0x000000FF;
    }
}
