package leetcode._120;

import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] min = new int[triangle.size() + 1];
        for (int level = triangle.size() - 1; level >= 0; level--) {
            for (int i = 0; i <= level; i++) {
                min[i] = Math.min(min[i], min[i + 1]) + triangle.get(level).get(i);
            }
        }
        return min[0];
    }
}
