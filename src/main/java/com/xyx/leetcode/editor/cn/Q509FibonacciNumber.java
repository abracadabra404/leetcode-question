//斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给定 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
//
// Related Topics递归 | 记忆化搜索 | 数学 | 动态规划 
//
// 👍 550, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.xyx.leetcode.editor.cn;

public class Q509FibonacciNumber {
    public static void main(String[] args) {
        Solution solution = new Q509FibonacciNumber().new Solution();
        System.out.println(solution.fib(4));
    }

    class Solution1 {
        public int fib1(int n) {
            // momo initial 0
            int[] memo = new int[n + 1];
            // recursive with memo
            return helper(memo, n);
        }

        private int helper(int[] memo, int n) {
            // base caseÒ
            if (n == 0 || n == 1) {
                return n;
            }
            if (memo[n] != 0) {
                return memo[n];
            }
            memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
            return memo[n];
        }

        public int fib2(int n) {
            if (n == 0) {
                return 0;
            }
            int[] dp = new int[n + 1];
            // base case
            dp[0] = 0;
            dp[1] = 1;
            // 状态转移
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fib(int n) {
            // base case
            if (n == 0 || n == 1) {
                return n;
            }
            // 分别代表dp[i-1],dp[i-2]
            int dp_i_1 = 1,dp_i_2=0;
            // 状态转移
            for (int i = 2; i <= n; i++) {
                // dp[i] = dp[i-1]+dp[i-2]
                int dp_i = dp_i_1 + dp_i_2;
                dp_i_2 = dp_i_1;
                dp_i_1 = dp_i;
            }
            return dp_i_1;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}