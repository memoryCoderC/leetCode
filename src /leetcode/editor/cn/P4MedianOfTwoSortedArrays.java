//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治算法 
// 👍 3883 👎 0


package leetcode.editor.cn;

//Java：寻找两个正序数组的中位数
public class P4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new P4MedianOfTwoSortedArrays().new Solution();
        // TO TEST
        solution.findMedianSortedArrays(new int[]{}, new int[]{1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] A, int[] B) {
            int m = A.length;
            int n = B.length;
            int len = m + n;
            int left = -1, right = -1;
            int aStart = 0, bStart = 0;
            for (int i = 0; i <= len / 2; i++) {
                left = right;
                if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                    right = A[aStart++];
                } else {
                    right = B[bStart++];
                }
            }
            if ((len & 1) == 0)
                return (left + right) / 2.0;
            else
                return right;
        }

        /**
         * 排序暴力解法
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
            int[] nums = new int[nums1.length + nums2.length];
            int i = 0, j = 0;
            int target = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    nums[target++] = nums1[i++];
                } else {
                    nums[target++] = nums2[j++];
                }
            }
            if (i < nums1.length) {
                for (; i < nums1.length; i++) {
                    nums[target++] = nums1[i];
                }
            } else {
                for (; j < nums2.length; j++) {
                    nums[target++] = nums2[j];
                }
            }
            double result;
            if (nums.length == 1) {
                result = nums[0];
            } else if (nums.length % 2 == 0) {
                int r1 = nums[nums.length / 2 - 1];
                int r2 = nums[nums.length / 2];
                result = (r1 + r2) / 2.0;
            } else {
                result = nums[nums.length / 2];
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}