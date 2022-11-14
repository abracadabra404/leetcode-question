<p>给你一个整数数组&nbsp;<code>nums</code> ，数组中的元素 <strong>互不相同</strong> 。返回该数组所有可能的子集（幂集）。</p>

<p>解集 <strong>不能</strong> 包含重复的子集。你可以按 <strong>任意顺序</strong> 返回解集。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3]
<strong>输出：</strong>[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0]
<strong>输出：</strong>[[],[0]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10</code></li> 
 <li><code>-10 &lt;= nums[i] &lt;= 10</code></li> 
 <li><code>nums</code> 中的所有元素 <strong>互不相同</strong></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>位运算 | 数组 | 回溯</details><br>

<div>👍 1857, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/NF8mmVyXVfC1ehdMOsO7Cw' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.0；[第 13 期刷题打卡](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) 最后一天报名！**



<p><strong><a href="https://labuladong.github.io/article?qno=78" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[回溯算法秒杀所有排列/组合/子集问题](https://www.bilibili.com/video/BV1Yt4y1t7dK)

PS：这道题在[《算法小抄》](https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw) 的第 293 页。

有两种方法解决这道题，这里主要说回溯算法思路，因为比较通用，可以套前文 [回溯算法详解](https://labuladong.github.io/article/fname.html?fname=回溯算法详解修订版) 写过回溯算法模板。

本质上子集问题就是遍历这样用一棵回溯树：

![](https://labuladong.github.io/algo/images/子集/1.jpg)

**详细题解：[回溯算法秒杀所有排列/组合/子集问题](https://labuladong.github.io/article/fname.html?fname=子集排列组合)**

**标签：[回溯算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)，[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

## 解法代码

```cpp
class Solution {
    public:
    vector<vector<int>> res;
    vector<vector<int>> subsets(vector<int>& nums) {
        // 记录走过的路径
        vector<int> track;
        backtrack(nums, 0, track);
        return res;
    }

    void backtrack(vector<int>& nums, int start, vector<int>& track) {
        res.push_back(track);
        for (int i = start; i < nums.size(); i++) {
            // 做选择
            track.push_back(nums[i]);
            // 回溯
            backtrack(nums, i + 1, track);
            // 撤销选择
            track.pop_back();
        }
    }
};
```

**类似题目**：
  - [216. 组合总和 III 🟠](/problems/combination-sum-iii)
  - [39. 组合总和 🟠](/problems/combination-sum)
  - [40. 组合总和 II 🟠](/problems/combination-sum-ii)
  - [46. 全排列 🟠](/problems/permutations)
  - [47. 全排列 II 🟠](/problems/permutations-ii)
  - [77. 组合 🟠](/problems/combinations)
  - [90. 子集 II 🟠](/problems/subsets-ii)
  - [剑指 Offer II 079. 所有子集 🟠](/problems/TVdhkn)
  - [剑指 Offer II 080. 含有 k 个元素的组合 🟠](/problems/uUsW3B)
  - [剑指 Offer II 081. 允许重复选择元素的组合 🟠](/problems/Ygoe9J)
  - [剑指 Offer II 082. 含有重复元素集合的组合 🟠](/problems/4sjJUc)
  - [剑指 Offer II 083. 没有重复元素集合的全排列 🟠](/problems/VvJkup)
  - [剑指 Offer II 084. 含有重复元素集合的全排列 🟠](/problems/7p8L0Z)

</details>
</div>



