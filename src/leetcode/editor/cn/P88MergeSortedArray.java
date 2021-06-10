//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 
// 👍 968 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：合并两个有序数组
public class P88MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new P88MergeSortedArray().new Solution();
        // TO TEST
        int[] nums1 = {-1, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0};
        solution.merge(nums1, 5, new int[]{-1, -1, 0, 0, 1, 2}, 6);
        System.out.println(Arrays.toString(nums1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = 0, j = 0;
            while (i < m || j < n) {
                if (j >= n) {
                    return;
                }
                if (i >= m + j) {
                    nums1[i] = nums2[j];
                    j++;
                } else if (nums1[i] > nums2[j]) {
                    for (int t = m + j; t > i; t--) {
                        nums1[t] = nums1[t - 1];
                    }
                    nums1[i] = nums2[j];
                    j++;
                }
                i++;
            }
        }

        /**
         * 　从后往前计算不用移动数组
         *
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         */
        public void merge1(int[] nums1, int m, int[] nums2, int n) {
            int len1 = m - 1;
            int len2 = n - 1;
            int len = m + n - 1;
            while (len1 >= 0 && len2 >= 0) {
                // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
                nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
            }
            // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
            System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}