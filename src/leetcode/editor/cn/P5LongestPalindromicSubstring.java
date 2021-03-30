//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3425 👎 0


package leetcode.editor.cn;

//Java：最长回文子串
public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
        solution.longestPalindrome("babad");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            byte[] bytes = s.getBytes();
            int length = bytes.length;
            if (length < 2) {
                return s;
            }
            int maxBeginIndex = 0;
            int maxEndIndex = 0;
            for (int i = 0; i < length; i++) {
                int maxLengthOddNumber = getMaxLength(bytes, i, i);
                int maxLengthEvenNumber = getMaxLength(bytes, i, i + 1);
                int currentMax = Math.max(maxLengthOddNumber, maxLengthEvenNumber);
                if (currentMax > maxEndIndex - maxBeginIndex) {
                    maxBeginIndex = i - (currentMax - 1) / 2;
                    maxEndIndex = i + currentMax / 2;
                }
            }
            return s.substring(maxBeginIndex, maxEndIndex + 1);
        }

        private int getMaxLength(byte[] bytes, int leftPosition, int rightPosition) {
            while (leftPosition >= 0 && rightPosition < bytes.length && bytes[leftPosition] == bytes[rightPosition]) {
                leftPosition--;
                rightPosition++;
            }
            return rightPosition - leftPosition - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}