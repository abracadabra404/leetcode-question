//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 2304, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.xyx.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q46Permutations {
    public static void main(String[] args) {
        Solution solution = new Q46Permutations().new Solution();
        int[] nums = {2, 1, 3};
        System.out.println(Arrays.asList(solution.permute(nums)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new LinkedList<>();
        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();

        public List<List<Integer>> permute(int[] nums) {
            // 路径中的元素会被标记为true，避免重复使用
            boolean[] used = new boolean[nums.length];
            backTrack(nums, track, used);
            return res;
        }

        // 路径：记录在track中
        // 选择列表：nums中不存在于track的那些元素（used[i]=false）
        //
        private void backTrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
            // base case,到达叶子节点
            if (track.size() == nums.length) {
                // 收集叶子节点上的值
                res.add(new LinkedList<>(track));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                // 已经存在track中的元素，不能重复选择
                if (used[i]) {
                    continue;
                }
                // 做选择
                track.add(nums[i]);
                used[i] = true;
                // 进入下一层回溯树
                backTrack(nums, track, used);
                // 取消选择
                track.removeLast();
                used[i] = false;
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}