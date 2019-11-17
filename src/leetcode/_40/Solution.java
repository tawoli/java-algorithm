package leetcode._40;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, new LinkedList<>());
        return res;
    }

    private void combinationSum2(int[] candidates, int target, int index, LinkedList<Integer> c) {
        if (target == 0) {
            res.add(new LinkedList<>(c));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            c.add(candidates[i]);
            combinationSum2(candidates, target - candidates[i], i + 1, c);
            c.removeLast();
        }
    }
}
