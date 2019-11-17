package leetcode._90;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, new LinkedList<>());
        return res;
    }

    private void subsetsWithDup(int[] nums, int index, LinkedList<Integer> list) {
        res.add(new LinkedList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            subsetsWithDup(nums, i + 1, list);
            list.removeLast();
        }
    }
}
