//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 1238, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.xyx.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new Q47PermutationsIi().new Solution();
        int[] nums = {1, 2, 2};
        System.out.println(solution.permuteUnique(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used;


        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            used = new boolean[nums.length];
            backtrack(nums);
            return res;
        }

        public void backtrack(int[] nums) {
            if (track.size() == nums.length) {
                res.add(new LinkedList<>(track));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                // 新添加的剪枝逻辑，固定相同的元素在排列中的相对位置
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                track.add(nums[i]);
                used[i] = true;
                backtrack(nums);
                track.removeLast();
                used[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}