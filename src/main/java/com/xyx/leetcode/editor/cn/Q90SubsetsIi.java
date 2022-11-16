//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics位运算 | 数组 | 回溯 
//
// 👍 968, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.xyx.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q90SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new Q90SubsetsIi().new Solution();
        int[] nums = {1, 2, 2};
        System.out.println(solution.subsetsWithDup(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new LinkedList<>();
        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            // 排序，相同 的元素排在一起
            Arrays.sort(nums);
            backtrack(nums, 0);
            return res;
        }

        private void backtrack(int[] nums, int start) {
            // 前序位置，每个节点的值都是一个子集
            res.add(new LinkedList<>(track));

            for (int j = start; j < nums.length; j++) {
                // 剪枝逻辑，值相同的相邻树枝，只遍历第一条
                if (j > start && nums[j] == nums[j - 1]) {
                    continue;
                }
                track.addLast(nums[j]);
                backtrack(nums, j + 1);
                track.removeLast();
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}