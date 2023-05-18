package org.dmkyr20.tables4j.prolots.graphic;

import org.dmkyr20.tables4j.prolots.exceptions.GraphicException;

public class BoardT4j {
    private final int height;
    private final int width;
    private final PixelT4j[][] pixels;

    public BoardT4j(int height, int width) {
        this.height = height;
        this.width = width;
        this.pixels = new PixelT4j[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                pixels[i][j] = new PixelT4j(i, j, ColorsT4j.WHITE);
            }
        }
    }

    private PixelT4j get(int x, int y) {
        validateX(x);
        validateY(y);
        return pixels[x][y];
    }

    private void validateX(int x) {
        if(x < 0 || x >= width )
            throw new GraphicException("x = " + x + " out of the board");
    }

    private void validateY(int y) {
        if(y < 0 || y >= height)
            throw new GraphicException("y" + y + " out of the board");
    }
}
