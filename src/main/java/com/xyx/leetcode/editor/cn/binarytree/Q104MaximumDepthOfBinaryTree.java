  //给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 1423, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package com.xyx.leetcode.editor.cn.binarytree;

  import com.xyx.leetcode.TreeNode;

  public class Q104MaximumDepthOfBinaryTree{
      public static void main(String[] args) {
           Solution solution = new Q104MaximumDepthOfBinaryTree().new Solution();
          TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15,new TreeNode(4),new TreeNode(5)), new TreeNode(7)));
          System.out.println(solution.maxDepth(treeNode));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 记录最大深度
    int res = 0;
    // 记录遍历到节点的深度
    int depth = 0;
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth ++;
        // 前序位置
        if (root.left == null && root.right == null) {
            res = Math.max(res, depth);
        }
        traverse(root.left);
        // 中序位置
        traverse(root.right);
        // 后序位置
        depth--;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }