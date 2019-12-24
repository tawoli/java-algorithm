package leetcode._347;

import java.util.*;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer integer : map.keySet()) {
            heap.add(integer);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<Integer> top = new ArrayList<>();
        while (!heap.isEmpty()) {
            top.add(heap.poll());
        }
        Collections.reverse(top);
        return top;
    }
}
