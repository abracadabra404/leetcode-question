<p>给定一个整数数组&nbsp;<code>prices</code>，其中 <code>prices[i]</code>表示第&nbsp;<code>i</code>&nbsp;天的股票价格 ；整数&nbsp;<code>fee</code> 代表了交易股票的手续费用。</p>

<p>你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。</p>

<p>返回获得利润的最大值。</p>

<p><strong>注意：</strong>这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>prices = [1, 3, 2, 8, 4, 9], fee = 2
<strong>输出：</strong>8
<strong>解释：</strong>能够达到的最大利润:  
在此处买入&nbsp;prices[0] = 1
在此处卖出 prices[3] = 8
在此处买入 prices[4] = 4
在此处卖出 prices[5] = 9
总利润:&nbsp;((8 - 1) - 2) + ((9 - 4) - 2) = 8</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>prices = [1,3,7,5,10,3], fee = 3
<strong>输出：</strong>6
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= prices.length &lt;= 5 * 10<sup>4</sup></code></li> 
 <li><code>1 &lt;= prices[i] &lt; 5 * 10<sup>4</sup></code></li> 
 <li><code>0 &lt;= fee &lt; 5 * 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>贪心 | 数组 | 动态规划</details><br>

<div>👍 821, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/NF8mmVyXVfC1ehdMOsO7Cw' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.0，第 14 期打卡训练营 [开始报名](https://aep.xet.tech/s/3ts7sQ)。**



<p><strong><a href="https://labuladong.github.io/article?qno=714" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

**提示：股票系列问题有共通性，但难度较大，初次接触此类问题的话很难看懂下述思路，建议直接看 [详细题解](https://labuladong.github.io/article/fname.html?fname=团灭股票问题)。**

股票系列问题状态定义：

```python
dp[i][k][0 or 1]
0 <= i <= n - 1, 1 <= k <= K
n 为天数，大 K 为交易数的上限，0 和 1 代表是否持有股票。
```

股票系列问题通用状态转移方程和 base case：

```python
状态转移方程：
dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])

base case：
dp[-1][...][0] = dp[...][0][0] = 0
dp[-1][...][1] = dp[...][0][1] = -infinity
```

特化到 `k` 无限制且包含手续费的情况，只需稍微修改 [122. 买卖股票的最佳时机 II](/problems/best-time-to-buy-and-sell-stock-ii)，手续费可以认为是买入价变贵了或者卖出价变便宜了。

状态转移方程如下：

```python
dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i] - fee)
解释：相当于买入股票的价格升高了。
```

注意状态转移方程改变后 base case 也要做出对应改变，详细思路解析和空间复杂度优化的解法见详细题解。

**详细题解：[一个方法团灭 LeetCode 股票买卖问题](https://labuladong.github.io/article/fname.html?fname=团灭股票问题)**

**标签：[三维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122017695998050308)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

## 解法代码

```java
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                // base case
                dp[i][0] = 0;
                dp[i][1] = -prices[i] - fee;
                //   dp[i][1]
                // = max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee)
                // = max(dp[-1][1], dp[-1][0] - prices[i] - fee)
                // = max(-inf, 0 - prices[i] - fee)
                // = -prices[i] - fee
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[n - 1][0];
    }
}
```

**类似题目**：
  - [121. 买卖股票的最佳时机 🟢](/problems/best-time-to-buy-and-sell-stock)
  - [122. 买卖股票的最佳时机 II 🟠](/problems/best-time-to-buy-and-sell-stock-ii)
  - [123. 买卖股票的最佳时机 III 🔴](/problems/best-time-to-buy-and-sell-stock-iii)
  - [188. 买卖股票的最佳时机 IV 🔴](/problems/best-time-to-buy-and-sell-stock-iv)
  - [309. 最佳买卖股票时机含冷冻期 🟠](/problems/best-time-to-buy-and-sell-stock-with-cooldown)
  - [剑指 Offer 63. 股票的最大利润 🟠](/problems/gu-piao-de-zui-da-li-run-lcof)

</details>
</div>



