<p>给定一个&nbsp;<code>n</code>&nbsp;个元素有序的（升序）整型数组&nbsp;<code>nums</code> 和一个目标值&nbsp;<code>target</code> &nbsp;，写一个函数搜索&nbsp;<code>nums</code>&nbsp;中的 <code>target</code>，如果目标值存在返回下标，否则返回 <code>-1</code>。</p>

<p><br> <strong>示例 1:</strong></br></p>

<pre><strong>输入:</strong> <span><code>nums</code></span> = [-1,0,3,5,9,12], <span><code>target</code></span> = 9
<strong>输出:</strong> 4
<strong>解释:</strong> 9 出现在 <span><code>nums</code></span> 中并且下标为 4
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> <span><code>nums</code></span> = [-1,0,3,5,9,12], <span><code>target</code></span> = 2
<strong>输出:</strong> -1
<strong>解释:</strong> 2 不存在 <span><code>nums</code></span> 中因此返回 -1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol> 
 <li>你可以假设 <code>nums</code>&nbsp;中的所有元素是不重复的。</li> 
 <li><code>n</code>&nbsp;将在&nbsp;<code>[1, 10000]</code>之间。</li> 
 <li><code>nums</code>&nbsp;的每个元素都将在&nbsp;<code>[-9999, 9999]</code>之间。</li> 
</ol>

<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>

<div>👍 1037, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/NF8mmVyXVfC1ehdMOsO7Cw' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.0；[第 13 期刷题打卡](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) 最后几天报名！**



<p><strong><a href="https://labuladong.github.io/article?qno=704" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[二分搜索核心框架套路](https://www.bilibili.com/video/BV1Gt4y1b79Q)

PS：这道题在[《算法小抄》](https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw) 的第 71 页。

二分搜索的基本形式，不过并不实用，比如 `target` 重复出现多次，本算法得出的索引位置是不确定的。

更常见的二分搜索形式是搜索左侧边界和右侧边界，即对于 `target` 重复出现多次的情景，计算 `target` 的最小索引和最大索引。

这几种二分搜索的形式的详细探讨见详细题解。

**详细题解：[我写了首诗，把二分搜索算法变成了默写题](https://labuladong.github.io/article/fname.html?fname=二分查找详解)**

**标签：[二分搜索](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

## 解法代码

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }
}
```

**类似题目**：
  - [34. 在排序数组中查找元素的第一个和最后一个位置 🟠](/problems/find-first-and-last-position-of-element-in-sorted-array)
  - [剑指 Offer 53 - I. 在排序数组中查找数字 I 🟢](/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof)

</details>
</div>



