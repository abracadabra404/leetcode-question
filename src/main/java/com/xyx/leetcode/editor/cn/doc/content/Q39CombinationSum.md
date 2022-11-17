<p>给你一个 <strong>无重复元素</strong> 的整数数组&nbsp;<code>candidates</code> 和一个目标整数&nbsp;<code>target</code>&nbsp;，找出&nbsp;<code>candidates</code>&nbsp;中可以使数字和为目标数&nbsp;<code>target</code> 的 所有<em>&nbsp;</em><strong>不同组合</strong> ，并以列表形式返回。你可以按 <strong>任意顺序</strong> 返回这些组合。</p>

<p><code>candidates</code> 中的 <strong>同一个</strong> 数字可以 <strong>无限制重复被选取</strong> 。如果至少一个数字的被选数量不同，则两种组合是不同的。&nbsp;</p>

<p>对于给定的输入，保证和为&nbsp;<code>target</code> 的不同组合数少于 <code>150</code> 个。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>candidates = <span><code>[2,3,6,7], </code></span>target = <span><code>7</code></span>
<strong>输出：</strong>[[2,2,3],[7]]
<strong>解释：</strong>
2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
7 也是一个候选， 7 = 7 。
仅有这两种组合。</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入: </strong>candidates = [2,3,5]<span><code>, </code></span>target = 8
<strong>输出: </strong>[[2,2,2,2],[2,3,3],[3,5]]</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入: </strong>candidates = <span><code>[2], </code></span>target = 1
<strong>输出: </strong>[]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= candidates.length &lt;= 30</code></li> 
 <li><code>2 &lt;= candidates[i] &lt;= 40</code></li> 
 <li><code>candidates</code> 的所有元素 <strong>互不相同</strong></li> 
 <li><code>1 &lt;= target &lt;= 40</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 回溯</details><br>

<div>👍 2253, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/NF8mmVyXVfC1ehdMOsO7Cw' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.0。**



<p><strong><a href="https://labuladong.github.io/article?qno=39" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[回溯算法秒杀所有排列/组合/子集问题](https://www.bilibili.com/video/BV1Yt4y1t7dK)

你需要先看前文 [回溯算法详解](https://labuladong.github.io/article/fname.html?fname=回溯算法详解修订版) 和 [回溯算法团灭子集、排列、组合问题](https://labuladong.github.io/article/fname.html?fname=子集排列组合)，然后看这道题就很简单了，无非是回溯算法的运用而已。

这道题的关键在于 `candidates` 中的元素可以复用多次，体现在代码中是下面这段：

```java
void backtrack(int[] candidates, int start, int target, int sum) {
    // 回溯算法框架
    for (int i = start; i < candidates.length; i++) {
        // 选择 candidates[i]
        backtrack(candidates, i, target, sum);
        // 撤销选择 candidates[i]
    }
}
```

对比 [回溯算法团灭子集、排列、组合问题](https://labuladong.github.io/article/fname.html?fname=子集排列组合) 中不能重复使用元素的标准组合问题：

```java
void backtrack(int[] candidates, int start, int target, int sum) {
    // 回溯算法框架
    for (int i = start; i < candidates.length; i++) {
        // 选择 candidates[i]
        backtrack(candidates, i + 1, target, sum);
        // 撤销选择 candidates[i]
    }
}
```

体会到控制是否重复使用元素的关键了吗？

**详细题解：[回溯算法秒杀所有排列/组合/子集问题](https://labuladong.github.io/article/fname.html?fname=子集排列组合)**

**标签：[回溯算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)**

## 解法代码

```java
class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        backtrack(candidates, 0, target, 0);
        return res;
    }

    // 记录回溯的路径
    LinkedList<Integer> track = new LinkedList<>();

    // 回溯算法主函数
    void backtrack(int[] candidates, int start, int target, int sum) {
        if (sum == target) {
            // 找到目标和
            res.add(new LinkedList<>(track));
            return;
        }

        if (sum > target) {
            // 超过目标和，直接结束
            return;
        }

        // 回溯算法框架
        for (int i = start; i < candidates.length; i++) {
            // 选择 candidates[i]
            track.add(candidates[i]);
            sum += candidates[i];
            // 递归遍历下一层回溯树
            backtrack(candidates, i, target, sum);
            // 撤销选择 candidates[i]
            sum -= candidates[i];
            track.removeLast();
        }
    }
}
```

**类似题目**：
  - [216. 组合总和 III 🟠](/problems/combination-sum-iii)
  - [40. 组合总和 II 🟠](/problems/combination-sum-ii)
  - [46. 全排列 🟠](/problems/permutations)
  - [47. 全排列 II 🟠](/problems/permutations-ii)
  - [77. 组合 🟠](/problems/combinations)
  - [78. 子集 🟠](/problems/subsets)
  - [90. 子集 II 🟠](/problems/subsets-ii)
  - [剑指 Offer II 079. 所有子集 🟠](/problems/TVdhkn)
  - [剑指 Offer II 080. 含有 k 个元素的组合 🟠](/problems/uUsW3B)
  - [剑指 Offer II 081. 允许重复选择元素的组合 🟠](/problems/Ygoe9J)
  - [剑指 Offer II 082. 含有重复元素集合的组合 🟠](/problems/4sjJUc)
  - [剑指 Offer II 083. 没有重复元素集合的全排列 🟠](/problems/VvJkup)
  - [剑指 Offer II 084. 含有重复元素集合的全排列 🟠](/problems/7p8L0Z)

</details>
</div>



