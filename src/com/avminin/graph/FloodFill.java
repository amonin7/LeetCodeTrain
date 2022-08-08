package com.avminin.graph;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, color, new boolean[image.length][image[0].length]);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int color, boolean[][] used) {
        if (used[i][j]) return;
        used[i][j] = true;
        int initialColor = image[i][j];
        image[i][j] = color;
        if (i - 1 >= 0 && image[i - 1][j] == initialColor) dfs(image, i - 1, j, color, used);
        if (j - 1 >= 0 && image[i][j - 1] == initialColor) dfs(image, i, j - 1, color, used);
        if (i + 1 < image.length && image[i + 1][j] == initialColor) dfs(image, i + 1, j, color, used);
        if (j + 1 < image[0].length && image[i][j + 1] == initialColor) dfs(image, i, j + 1, color, used);
    }

}
