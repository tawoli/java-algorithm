package leetcode._131;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        return partition(s, 0);
    }

    private List<List<String>> partition(String s, int index) {
        if (index == s.length()) {
            List<String> list = new ArrayList<>();
            List<List<String>> ans = new ArrayList<>();
            ans.add(list);
            return ans;
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = index; i < s.length(); i++) {
            String left = s.substring(index, i + 1);
            if (isPalindrome(s.substring(index, i + 1))) {
                for (List<String> strings : partition(s, i + 1)) {
                    strings.add(0, left);
                    ans.add(strings);
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
