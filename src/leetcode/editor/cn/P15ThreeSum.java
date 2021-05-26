//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3361 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：三数之和
public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        // TO TEST
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            if (nums == null || nums.length < 3) return ans;
            Arrays.sort(nums);
            for (int first = 0; first < nums.length; first++) {
                if (nums[first] > 0) break;
                if (first > 0 && nums[first] == nums[first - 1]) continue;
                int second = first + 1;
                int third = nums.length - 1;
                while (second < third) {
                    int result = nums[second] + nums[third];
                    int target = -nums[first];
                    if (result == target) {
                        ans.add(new ArrayList<>(Arrays.asList(nums[first], nums[second], nums[third])));
                        second++;
                        third--;
                        while (second < third && nums[second] == nums[second - 1]) second++;
                        while (second < third && nums[third] == nums[third + 1]) third--;
                    } else if (result < target) {
                        second++;
                    } else {
                        third--;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}