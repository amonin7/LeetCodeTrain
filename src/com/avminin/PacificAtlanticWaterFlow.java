package com.avminin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;

        List<Boolean> visitedPacFinding = new ArrayList<>();
        List<Boolean> visitedAtlFinding = new ArrayList<>();
        List<Boolean> isPacReach = new ArrayList<>();
        List<Boolean> isAtlReach = new ArrayList<>();
        for (int i = 0; i < n * m; ++i) {
            visitedAtlFinding.add(false);
            visitedPacFinding.add(false);
            isPacReach.add(false);
            isAtlReach.add(false);
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                List<Integer> edges = new ArrayList<>();
                // add pacific
                if (isPacific(i, j)) isPacReach.set(i * m + j, true);
                // add atlantic
                if (isAtlantic(i, j, n, m)) isAtlReach.set(i * m + j, true);
                addNeighs(i, j, heights, edges);
                adjList.put(i * m + j, edges);
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (i == 11 && j == 3) {
                    int x = 10;
                }
                boolean resPac = dfs2(i * m + j, m, heights, visitedPacFinding, isPacReach, adjList);
                boolean resAtl = dfs2(i * m + j, m, heights, visitedAtlFinding, isAtlReach, adjList);
                if (resPac && resAtl)
                    result.add(List.of(i, j));
            }
        }

        return result;
    }

    public boolean dfs2(
            int v,
            int m,
            int[][] heights,
            List<Boolean> visited,
            List<Boolean> isReach,
            HashMap<Integer, List<Integer>> adjList) {
        if (visited.get(v) || isReach.get(v)) {
            return isReach.get(v);
        }
        visited.set(v, true);

        boolean totalReachment = false;
        for (Integer neigh : adjList.get(v)) {
            totalReachment |= dfs2(neigh, m, heights, visited, isReach, adjList);
            isReach.set(v, totalReachment);
            // if (totalReachment)
            //     break;
        }

        isReach.set(v, totalReachment);
        if (totalReachment) {
            propagateEqual(v, m, heights, isReach);
        }
        return totalReachment;
    }

    private void propagateEqual(int v, int m, int[][] heights, List<Boolean> isReach) {
        int i = v / m;
        int j = v % m;
        if (i - 1 >= 0 && heights[i - 1][j] == heights[i][j]) isReach.set((i - 1) * m + j, true);
        if (j - 1 >= 0 && heights[i][j - 1] == heights[i][j]) isReach.set(i * m + j - 1, true);
        if (i + 1 < heights.length && heights[i + 1][j] == heights[i][j]) isReach.set((i + 1) * m + j, true);
        if (j + 1 < m && heights[i][j + 1] == heights[i][j]) isReach.set(i * m + j + 1, true);
    }

    private void addNeighs(int i, int j, int[][] heights, List<Integer> edges) {
        int n = heights.length;
        int m = heights[0].length;
        if (i - 1 >= 0 && heights[i - 1][j] <= heights[i][j]) edges.add((i - 1) * m + j);
        if (j - 1 >= 0 && heights[i][j - 1] <= heights[i][j]) edges.add(i * m + j - 1);
        if (i + 1 < n && heights[i + 1][j] <= heights[i][j]) edges.add((i + 1) * m + j);
        if (j + 1 < m && heights[i][j + 1] <= heights[i][j]) edges.add(i * m + j + 1);
    }

    private boolean isPacific(int i, int j) {
        return i == 0 || j == 0;
    }

    private boolean isAtlantic(int i, int j, int n, int m) {
        return i == n - 1 || j == m - 1;
    }
}
