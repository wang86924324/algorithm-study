package com.vincent.algorithm.recursions;

import java.util.Arrays;
import java.util.List;

public class Solutions120 {
    public int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            // dp formula
            for (int j = triangle.get(i).size() - 1;j >= 0; j--) {
                int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                min += triangle.get(i).get(j);
                triangle.get(i).set(j, min);
            }

        }
        return triangle.get(0).get(0);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }

        return _dfs(triangle, 0, 0, "");
    }

    private int _dfs(List<List<Integer>> triangle, int i, int j, String path) {
        // terminator
        if (i == triangle.size() - 1) {
            path += triangle.get(i).get(j) + "#";
            System.out.println(path);
            return 0;
        }

        // process
        path += triangle.get(i).get(j) + "->";
        // drill down
        _dfs(triangle, i + 1, j, path);
        _dfs(triangle, i + 1, j + 1, path);

        // clear state
        // NOTE: no need to clear up the state `path`
        return 0;
    }

    public static void main(String[] args) {
        Solutions120 sol = new Solutions120();
        int result = sol.minimumTotal(Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        ));
    }
}
