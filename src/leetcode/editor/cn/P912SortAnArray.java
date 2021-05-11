//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// 👍 286 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：排序数组
public class P912SortAnArray {
    public static void main(String[] args) {
        Solution solution = new P912SortAnArray().new Solution();
        // TO TEST
        System.out.println(Arrays.toString(solution.sortArray(new int[]{5, 2, 3, 1})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] sortArray(int[] nums) {
            return insertionSort(nums);
        }

        /**
         * 插入排序
         * @param nums
         * @return
         */
        public int[] insertionSort(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int temp = nums[i];
                for (int j = i - 1; j > -1; j--) {
                    if (nums[j] < temp) {
                        break;
                    }
                    swap(nums, j, j + 1);
                }
            }
            return nums;
        }

        /**
         * 冒泡排序
         *
         * @param nums
         * @return
         */
        public int[] bubbleSort(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length - i - 1; j++) {
                    if (nums[j] > nums[j + 1]) {
                        swap(nums, j, j + 1);
                    }
                }
            }
            return nums;
        }

        /**
         * 选择排序
         *
         * @param nums
         * @return
         */
        public int[] selectionSort(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int min = i;
                for (int j = i; j < nums.length; j++) {
                    if (nums[min] > nums[j]) {
                        min = j;
                    }
                }
                swap(nums, min, i);
            }
            return nums;
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}