//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics回溯 
//
// 👍 1195, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.xyx.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xuyaxi
 */
public class Q77Combinations {
    public static void main(String[] args) {
        Solution solution = new Q77Combinations().new Solution();
        System.out.println(Arrays.asList(solution.combine(3,2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new LinkedList<>();
        // 记录回溯算法的递归路径
        LinkedList<Integer> track = new LinkedList<>();

        public List<List<Integer>> combine(int n, int k) {
            backtrack(1, n, k);
            return res;
        }

        public void backtrack(int start, int n, int k) {
            // base case
            if (k == track.size()) {
                // 遍历到了k层，收集当前节点的值
                res.add(new LinkedList<>(track));
            }
            // 回溯算法标准框架
            for (int i = start; i <= n; i++) {
                // 选择
                track.addLast(i);
                // 通过start参数控制树枝的遍历，避免产生重复的子集
                backtrack(i + 1, n, k);
                // 撤销选择
                track.removeLast();
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}