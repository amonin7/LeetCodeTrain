package com.avminin.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class NumberOfIslands {

    public void dfs (int v, List<List<Integer>> adj_list, HashSet<Integer> used) {
        used.remove(v);
        for (int new_v : adj_list.get(v)) {
            if (used.contains(new_v)) {
                dfs(new_v, adj_list, used);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        List<List<Integer>> adj_list = new ArrayList<>();
        HashSet<Integer> used = new HashSet<>();
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == '0') {
                    adj_list.add(new ArrayList<>());
                    continue;
                }
                int id = i * cols + j;
                used.add(id);
                List<Integer> v_adj_list = new ArrayList<>();
                if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                    v_adj_list.add((i - 1) * cols + j);
                }
                if (i + 1 < rows && grid[i + 1][j] == '1') {
                    v_adj_list.add((i + 1) * cols + j);
                }
                if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                    v_adj_list.add(i * cols + j - 1);
                }
                if (j + 1 < cols && grid[i][j + 1] == '1') {
                    v_adj_list.add(i * cols + j + 1);
                }
                adj_list.add(v_adj_list);
            }
        }
        int cnt = 0;
        while (!used.isEmpty()) {
            ++cnt;
            dfs(used.iterator().next(), adj_list, used);
        }
        return cnt;
    }

}
