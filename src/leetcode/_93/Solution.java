package leetcode._93;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> strings = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        restoreIpAddresses(s, 0, 0, "");
        return strings;
    }

    private void restoreIpAddresses(String s, int index, int level, String res) {
        if (level == 4) {
            if (index == s.length()) {
                strings.add(res.substring(0, res.length() - 1));
            }
            return;
        }
        for (int i = index; i < index + 3 && i < s.length(); i++) {
            if (i == index && s.charAt(i) == '0') {
                restoreIpAddresses(s, i + 1, level + 1, res + s.charAt(i) + '.');
                break;
            }
            if (Integer.parseInt(s.substring(index, i + 1)) <= 255) {
                restoreIpAddresses(s, i + 1, level + 1, res + s.substring(index, i + 1) + '.');
            }
        }
    }
}
