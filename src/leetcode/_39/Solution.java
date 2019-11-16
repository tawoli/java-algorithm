package leetcode._39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void combinationSum(int[] candidates, int target, int index, List<Integer> c) {
        if (target == 0) {
            res.add(new ArrayList<>(c));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            c.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, c);
            c.remove(c.size() - 1);
        }
    }
}
