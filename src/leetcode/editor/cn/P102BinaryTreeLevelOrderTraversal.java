//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 882 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：二叉树的层序遍历
public class P102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();
        // TO TEST
    }

//leetcode submit region begin(Prohibit modification and deletion)

    //  Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            ArrayList<TreeNode> list = new ArrayList<>();
            if(root == null){
                return result;
            }
            list.add(root);
            floor(list, result);
            return result;
        }

        private void floor(List<TreeNode> aboveFloor, List<List<Integer>> result) {
            if (aboveFloor.isEmpty()) {
                return;
            }
            List<TreeNode> thisFloor = new LinkedList<>();
            List<Integer> resultFloor = new LinkedList<>();
            for (TreeNode node : aboveFloor) {
                if (node.left != null) thisFloor.add(node.left);
                if (node.right != null) thisFloor.add(node.right);
                resultFloor.add(node.val);
            }
            result.add(resultFloor);
            floor(thisFloor, result);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}