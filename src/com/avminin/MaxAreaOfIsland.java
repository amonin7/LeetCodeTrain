package com.avminin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 0) continue;
                adjList.put(i * m + j, addNeighs(i, j, grid));
            }
        }
        boolean[] visited = new boolean[m * n];
        int maxSquare = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 0) continue;
                maxSquare = Integer.max(dfs(i * m + j, adjList, visited), maxSquare);
            }
        }
        return maxSquare;
    }

    private int dfs(int v, HashMap<Integer, List<Integer>> adjList, boolean[] visited) {
        if (visited[v]) return 0;
        visited[v] = true;
        if (adjList.get(v).isEmpty()) return 1;
        int neighs = 1;
        for (Integer neigh : adjList.get(v)) {
            neighs += dfs(neigh, adjList, visited);
        }
        return neighs;
    }

    private List<Integer> addNeighs(int i, int j, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        List<Integer> neighs = new ArrayList<>();
        if (i - 1 >= 0 && grid[i - 1][j] == 1) neighs.add((i - 1) * m + j);
        if (j - 1 >= 0 && grid[i][j - 1] == 1) neighs.add(i * m + j - 1);
        if (i + 1 < n && grid[i + 1][j] == 1) neighs.add((i + 1) * m + j);
        if (j + 1 < m && grid[i][j + 1] == 1) neighs.add(i * m + j + 1);
        return neighs;
    }

}
