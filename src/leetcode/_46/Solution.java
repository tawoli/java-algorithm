package leetcode._46;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> result = new LinkedList<>();
    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        visited = new boolean[nums.length];
        permute(nums, 0, new LinkedList<>());
        return result;
    }

    private void permute(int[] nums, int index, LinkedList<Integer> p) {
        if (index == nums.length) {
            result.add(new LinkedList<>(p));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                p.add(nums[i]);
                visited[i] = true;
                permute(nums, index + 1, p);
                p.removeLast();
                visited[i] = false;
            }
        }
    }
}
