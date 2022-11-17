//给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的
// 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。 
//
// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
//
// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入：candidates = [2,3,6,7], target = 7
//输出：[[2,2,3],[7]]
//解释：
//2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//7 也是一个候选， 7 = 7 。
//仅有这两种组合。 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 2 <= candidates[i] <= 40 
// candidates 的所有元素 互不相同 
// 1 <= target <= 40 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 2253, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.xyx.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class Q39CombinationSum {
    public static void main(String[] args) {
        Solution solution = new Q39CombinationSum().new Solution();
        int[] nums = {2, 3, 5};
        System.out.println(solution.combinationSum(nums, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        // 记录回溯的路径
        LinkedList<Integer> track = new LinkedList<>();
        // 记录track中的路径和
        int trackSum = 0;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if (candidates.length == 0) {
                return res;
            }
            backtrack(candidates, 0, target);
            return res;
        }

        private void backtrack(int[] nums, int start, int target) {
            // base case 找到目标和，记录结果
            if (trackSum == target) {
                res.add(new LinkedList<>(track));
            }
            // base case 超过目标和，停止向下遍历
            if (trackSum > target) {
                return;
            }
            // 回溯算法标准框架
            for (int i = start; i < nums.length; i++) {
                // 选择nums[i]
                trackSum += nums[i];
                track.add(nums[i]);
                // 递归遍历下一层回溯树
                // 同一参数可重复使用
                backtrack(nums, i, target);
                // 撤销选择nums[i]
                trackSum -= nums[i];
                track.removeLast();
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}