package leetcode._78;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        subsets(nums, 0, new LinkedList<>());
        return res;
    }

    private void subsets(int[] nums, int index, LinkedList<Integer> list) {
        res.add(new LinkedList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            subsets(nums, i + 1, list);
            list.removeLast();
        }
    }
}
