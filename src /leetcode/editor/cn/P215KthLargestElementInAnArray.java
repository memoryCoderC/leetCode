//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 1066 👎 0


package leetcode.editor.cn;

import java.util.PriorityQueue;

//Java：数组中的第K个最大元素
public class P215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        // TO TEST
        solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findKthLargest(int[] nums, int k) {
            int len = nums.length;
            int left = 0;
            int right = len - 1;

            // 转换一下，第 k 大元素的索引是 len - k
            int target = len - k;

            while (true) {
                int index = partition(nums, left, right);
                if (index == target) {
                    return nums[index];
                } else if (index < target) {
                    left = index + 1;
                } else {
                    right = index - 1;
                }
            }
        }

        /**
         * 在数组 nums 的子区间 [left, right] 执行 partition 操作，返回 nums[left] 排序以后应该在的位置
         * 在遍历过程中保持循环不变量的语义
         * 1、[left + 1, j] < nums[left]
         * 2、(j, i] >= nums[left]
         *
         * @param nums
         * @param left
         * @param right
         * @return
         */
        public int partition(int[] nums, int left, int right) {
            int pivot = nums[left];
            int j = left;
            for (int i = left + 1; i <= right; i++) {
                if (nums[i] < pivot) {
                    // 小于 pivot 的元素都被交换到前面
                    j++;
                    swap(nums, j, i);
                }
            }
            // 在之前遍历的过程中，满足 [left + 1, j] < pivot，并且 (j, i] >= pivot
            swap(nums, j, left);
            // 交换以后 [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
            return j;
        }

        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}