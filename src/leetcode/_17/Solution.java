package leetcode._17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private String[] letterMap = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> strings = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return strings;
        }
        findCombination(digits, 0, "");
        return strings;
    }

    private void findCombination(String digits, int index, String s) {
        if (index == digits.length()) {
            strings.add(s);
            return;
        }
        char c = digits.charAt(index);
        assert c >= '0' && c <= '9' && c != '1';
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
    }
}
