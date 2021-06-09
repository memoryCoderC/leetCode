//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 381 👎 0


package leetcode.editor.cn;

//Java：字符串相加
public class P415AddStrings {
    public static void main(String[] args) {
        Solution solution = new P415AddStrings().new Solution();
        // TO TEST
        System.out.println(solution.addStrings("1", "9"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder results = new StringBuilder();
            int carry = 0;
            for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
                char num1Char = i < 0 ? '0' : num1.charAt(i);
                char num2Char = j < 0 ? '0' : num2.charAt(j);
                int num = num1Char + num2Char + carry - '0' * 2;
                int numi = num % 10;
                carry = num / 10;
                results.append(numi);
            }
            if (carry > 0) {
                results.append(carry);
            }
            return results.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}