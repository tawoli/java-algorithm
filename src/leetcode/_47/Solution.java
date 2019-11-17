package leetcode._47;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> result = new LinkedList<>();
    private boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        permuteUnique(nums, 0, new LinkedList<>());
        return result;
    }

    private void permuteUnique(int[] nums, int index, LinkedList<Integer> p) {
        if (index == nums.length) {
            result.add(new LinkedList<>(p));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && !visited[i - 1] && nums[i - 1] == nums[i])) {
                continue;
            }
            visited[i] = true;
            p.add(nums[i]);
            permuteUnique(nums, index + 1, p);
            p.removeLast();
            visited[i] = false;
        }
    }
}
