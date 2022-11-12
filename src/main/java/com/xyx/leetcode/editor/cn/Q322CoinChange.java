//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics广度优先搜索 | 数组 | 动态规划 
//
// 👍 2194, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.xyx.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Timer;

/**
 * @author xuyaxi
 */
public class Q322CoinChange {
    public static void main(String[] args) {
        Solution solution = new Q322CoinChange().new Solution();
        int[] coins = {1,5,2};
        int amount = 1188;
        long startMills = System.currentTimeMillis();
        System.out.println(solution.coinChange(coins,amount));
        System.out.println("this solution took: " + (System.currentTimeMillis() - startMills) + " mills");

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] memo;
        public int coinChange(int[] coins, int amount) {
            // 参考fibonacci memo
            memo = new int[amount + 1];
            Arrays.fill(memo,-8888);
            return dp(coins, amount);
        }

        private int dp(int[] coins, int amount) {
            // base case
            if (amount == 0) {
                return 0;
            }
            if (amount < 0) {
                return -1;
            }
            if (memo[amount] != -8888) {
                return memo[amount];
            }
            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                // 计算子问题的结果
                int subProblem = dp(coins, amount - coin);
                // 子问题无解则跳过
                if (subProblem == -1) {
                    continue;
                }
                // 子问题中选择最优解，然后+1
                res = Math.min(res,subProblem+1);
            }
            memo[amount] = (res == Integer.MAX_VALUE ? -1 : res);
            return memo[amount];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}