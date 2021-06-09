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
        System.out.println(Arrays.toString(solution.sortArray(new int[]{-4, 0, 7, 4, 9, -5, -1, 0, -7, -1})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] sortArray(int[] nums) {
            return heapSort(nums);
        }

        /**
         * 快速排序
         *
         * @param nums
         * @return
         */
        public int[] heapSort(int[] nums) {
            buildHeap(nums);
            for (int i = nums.length - 1; i > 0; ) {
                swap(nums, 0, i);
                i--;
                adjustHeap(nums, 0, i);
            }
            return nums;
        }

        private void buildHeap(int[] nums) {
            for (int i = (int) Math.floor(nums.length / 2); i >= 0; i--) {
                adjustHeap(nums, i, nums.length);
            }
        }

        private void adjustHeap(int[] nums, int i, int len) {
            int leftChild = 2 * i + 1;
            int rightChild = leftChild + 1;
            int maxPos = i;
            if (leftChild < len && nums[leftChild] > maxPos) {
                maxPos = leftChild;
            }
            if (rightChild < len && nums[rightChild] > maxPos) {
                maxPos = rightChild;
            }
            if (maxPos != i) {
                swap(nums, maxPos, i);
                adjustHeap(nums, i, len);
            }
        }

        /**
         * 快速排序
         *
         * @param nums
         * @return
         */
        public void quickSort(int[] nums, int left, int right) {
            if (left < right) {
                int partition = partition(nums, left, right);
                quickSort(nums, left, partition - 1);
                quickSort(nums, partition + 1, right);
            }
        }

        public int partition(int[] nums, int left, int right) {
            int pivot = nums[left];
            int i = left;
            int j = right;
            while (i < j) {
                while (nums[j] > pivot && i < j) {
                    j--;
                }
                if (i < j)
                    nums[i++] = nums[j];
                while (nums[i] <= pivot && i < j) {
                    i++;
                }
                if (i < j)
                    nums[j--] = nums[i];

            }
            nums[i] = pivot;
            return i;
        }

        /**
         * 归并排序
         *
         * @param nums
         * @return
         */
        public int[] mergeSort(int[] nums) {
            mergeSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void mergeSort(int[] nums, int left, int right) {
            if (left >= right) {
                return;
            }
            int mid = left + (right - left) / 2;//防止溢出！！
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            mergeTwoArrays(nums, left, right, mid);
        }

        private void mergeTwoArrays(int[] nums, int low, int high, int mid) {
            int[] tmp = new int[high - low + 1];
            int i = low, j = mid + 1, k = 0;
            while (i <= mid && j <= high) {
                if (nums[i] < nums[j]) {
                    tmp[k++] = nums[i++];
                } else {
                    tmp[k++] = nums[j++];
                }
            }
            while (i <= mid) tmp[k++] = nums[i++];
            while (j <= high) tmp[k++] = nums[j++];
            for (int index = 0; index < k; index++) {
                nums[low + index] = tmp[index];
            }
        }

        /**
         * 插入排序
         *
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