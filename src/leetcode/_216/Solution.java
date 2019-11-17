package leetcode._216;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum3(k, n, 1, new LinkedList<>());
        return res;
    }

    public void combinationSum3(int k, int n, int index, LinkedList<Integer> c) {
        if (n == 0 && k == 0) {
            res.add(new LinkedList<>(c));
            return;
        }
        for (int i = index; i <= 9  && n - i >= 0; i++) {
            c.add(i);
            combinationSum3(k - 1, n - i, i + 1, c);
            c.removeLast();
        }
    }
}
