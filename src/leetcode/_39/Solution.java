package leetcode._39;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, new LinkedList<>());
        return res;
    }

    private void combinationSum(int[] candidates, int target, int index, LinkedList<Integer> c) {
        if (target == 0) {
            res.add(new LinkedList<>(c));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            c.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, c);
            c.removeLast();
        }
    }
}
