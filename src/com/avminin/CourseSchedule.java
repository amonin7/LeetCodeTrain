package com.avminin;

import java.util.Arrays;
import java.util.HashSet;

public class CourseSchedule {

    int [] color;
    boolean [][] adj_matrix;

    public boolean dfs(int v) {
        color[v] = 1;
        for (int i = 0; i < adj_matrix.length; ++i) {
            if (v != i && adj_matrix[v][i]) {
                if (color[i] == 0) {
                    if (dfs(i)) {
                        return true;
                    }
                } else if (color[i] == 1) {
                    return true;
                }
            }
        }
        color[v] = 2;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        adj_matrix = new boolean[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; ++i) {
            int first = prerequisites[i][1], second = prerequisites[i][0];
            if (first == second) {
                return false;
            }
            adj_matrix[first][second] = true;
        }
        color = new int[numCourses];
        Arrays.fill(color, 0);
        for (int i = 0; i < numCourses; ++i) {
            if (color[i] == 0 && dfs(i)) {
                return false;
            }
        }
        return true;
    }
}
