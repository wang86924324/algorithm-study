package com.vincent.algorithm.recursions;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _51NQueue_0111 {
    Set<Integer> cols = new HashSet<>();
    Set<Integer> pie = new HashSet<>();
    Set<Integer> la = new HashSet<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<String>> solvesNqueues(int n) {
        return null;
    }

    public void dfs(int n, int row, List<Integer> currState) {
        // terminator
        if (row >= n) {
            result.add(currState);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || pie.contains(row + col) || la.contains(row - col)) continue;
            currState.add(col);

            cols.add(col);
            pie.add(row + col);
            la.add(col - col);

            dfs(n, row, currState);

            cols.remove(col);
            cols.remove(row + col);
            la.remove(col - col);
        }

    }
}
