package leetcode._77;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> list = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || k > n) {
            return list;
        }
        combine(n, k, 1, new LinkedList<>());
        return list;
    }

    private void combine(int n, int k, int start, LinkedList<Integer> c) {
        if (c.size() == k) {
            list.add(new LinkedList<>(c));
            return;
        }
        for (int i = start; i <= n - (k - c.size()) + 1; i++) {
            c.add(i);
            combine(n, k, i + 1, c);
            c.removeLast();
        }
    }
}
