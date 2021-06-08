package leetcode.editor.cn.review1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class P3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring1("pwwkew"));
    }

    /**
     * 滑动窗口
     */
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            byte[] bytes = s.getBytes();
            Set<Byte> set = new HashSet();
            int begin = 0;
            int end = 0;
            int maxlength = 0;
            int currentlength = 0;
            while (end < s.length()) {
                if (set.contains(bytes[end])) {
                    set.remove(bytes[begin]);
                    begin++;
                    currentlength--;
                } else {
                    set.add(bytes[end]);
                    end++;
                    currentlength++;
                    if (currentlength > maxlength) {
                        maxlength = currentlength;
                    }
                }
            }
            return maxlength;
        }

        /**
         * 借助map记录位置，直接跳转到重复的元素位置之后（比较下标过滤掉不在滑动窗口之内的）
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring1(String s) {
            if (s.length() == 0) return 0;
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            int max = 0;
            int left = 0;
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    left = Math.max(left, map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i), i);
                max = Math.max(max, i - left + 1);
            }
            return max;

        }
    }
}
