//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 876, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

 
package com.xyx.leetcode.editor.cn;

import com.xyx.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xuyaxi
 */
public class Q111MinimumDepthOfBinaryTree{


      public static void main(String[] args) {
           Solution solution = new Q111MinimumDepthOfBinaryTree().new Solution();
          TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
          System.out.println(solution.minDepth(node));
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root 本身就是一层，depth初始化1
        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            // 将当前队列中的所有节点向四周扩算
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                // 判断是否到达终点
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                // 将cur的相邻节点加入队列
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            // 增加步数
            depth++;
        }
        return depth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }