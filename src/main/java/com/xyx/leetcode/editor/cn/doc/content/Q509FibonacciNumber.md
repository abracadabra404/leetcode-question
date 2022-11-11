<p><strong>斐波那契数</strong>&nbsp;（通常用&nbsp;<code>F(n)</code> 表示）形成的序列称为 <strong>斐波那契数列</strong> 。该数列由&nbsp;<code>0</code> 和 <code>1</code> 开始，后面的每一项数字都是前面两项数字的和。也就是：</p>

<pre>
F(0) = 0，F(1)&nbsp;= 1
F(n) = F(n - 1) + F(n - 2)，其中 n &gt; 1
</pre>

<p>给定&nbsp;<code>n</code> ，请计算 <code>F(n)</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 2
<strong>输出：</strong>1
<strong>解释：</strong>F(2) = F(1) + F(0) = 1 + 0 = 1
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 3
<strong>输出：</strong>2
<strong>解释：</strong>F(3) = F(2) + F(1) = 1 + 1 = 2
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>n = 4
<strong>输出：</strong>3
<strong>解释：</strong>F(4) = F(3) + F(2) = 2 + 1 = 3
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>0 &lt;= n &lt;= 30</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>递归 | 记忆化搜索 | 数学 | 动态规划</details><br>

<div>👍 550, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/NF8mmVyXVfC1ehdMOsO7Cw' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.0；[第 13 期刷题打卡](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) 最后几天报名！**



<p><strong><a href="https://labuladong.github.io/article?qno=509" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[动态规划框架套路详解](https://www.bilibili.com/video/BV1XV411Y7oE)

PS：这道题在[《算法小抄》](https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw) 的第 31 页。

这题本身肯定是没有难度的，但是斐波那契数列可以帮你由浅入深理解动态规划算法的原理，建议阅读详细题解。

**详细题解：[动态规划解题套路框架](https://labuladong.github.io/article/fname.html?fname=动态规划详解进阶)**

**标签：[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

## 解法代码

```java
class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            // base case
            return n;
        }
        // 分别代表 dp[i - 1] 和 dp[i - 2]
        int dp_i_1 = 1, dp_i_2 = 0;
        for (int i = 2; i <= n; i++) {
            // dp[i] = dp[i - 1] + dp[i - 2];
            int dp_i = dp_i_1 + dp_i_2;
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
    }
}
```

**类似题目**：
  - [322. 零钱兑换 🟠](/problems/coin-change)
  - [70. 爬楼梯 🟢](/problems/climbing-stairs)
  - [剑指 Offer 10- II. 青蛙跳台阶问题 🟢](/problems/qing-wa-tiao-tai-jie-wen-ti-lcof)
  - [剑指 Offer II 103. 最少的硬币数目 🟠](/problems/gaM7Ch)

</details>
</div>



