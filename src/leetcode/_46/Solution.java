package leetcode._46;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        used = new boolean[nums.length];
        permute(nums, 0, new ArrayList<>());
        return result;
    }

    private void permute(int[] nums, int index, List<Integer> p) {
        if (index == nums.length) {
            result.add(new ArrayList<>(p));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                p.add(nums[i]);
                used[i] = true;
                permute(nums, index + 1, p);
                p.remove(p.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.permute(new int[]{1, 2, 3});
    }
}
