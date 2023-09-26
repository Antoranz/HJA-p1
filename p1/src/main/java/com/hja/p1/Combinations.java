package com.hja.p1;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    private ArrayList<Card> cardList;
    
    public Combinations(){
        
    }
    public List<List<Card>> combine(int n, int k, ArrayList<Card> cardList) {
        List<List<Card>> result = new ArrayList<>();
        List<Card> current = new ArrayList<>();
        this.cardList = cardList;
        generateCombinations(n, k, 0, current, result);
        return result;
    }

    private void generateCombinations(int n, int k, int start, List<Card> current, List<List<Card>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(cardList.get(i));
            generateCombinations(n, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

}