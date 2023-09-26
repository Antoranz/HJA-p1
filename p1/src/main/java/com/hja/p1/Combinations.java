package com.hja.p1;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public Combinations(){
        
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        generateCombinations(n, k, 1, current, result);
        return result;
    }

    private void generateCombinations(int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            generateCombinations(n, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

}