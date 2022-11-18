<p>给定一个二叉树，找出其最小深度。</p>

<p>最小深度是从根节点到最近叶子节点的最短路径上的节点数量。</p>

<p><strong>说明：</strong>叶子节点是指没有子节点的节点。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/12/ex_depth.jpg" style="width: 432px; height: 302px;" /> 
<pre>
<strong>输入：</strong>root = [3,9,20,null,null,15,7]
<strong>输出：</strong>2
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = [2,null,3,null,4,null,5,null,6]
<strong>输出：</strong>5
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>树中节点数的范围在 <code>[0, 10<sup>5</sup>]</code> 内</li> 
 <li><code>-1000 &lt;= Node.val &lt;= 1000</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 广度优先搜索 | 二叉树</details><br>

<div>👍 876, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/NF8mmVyXVfC1ehdMOsO7Cw' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.0。**



<p><strong><a href="https://labuladong.github.io/article?qno=111" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[BFS 算法核心框架套路](https://www.bilibili.com/video/BV1oT411u7Vn)

PS：这道题在[《算法小抄》](https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw) 的第 53 页。

基本的二叉树层序遍历方法，值得一提的是，BFS 算法框架就是二叉树层序遍历代码的衍生。

BFS 算法和 DFS（回溯）算法的一大区别就是，BFS 第一次搜索到的结果是最优的，这个得益于 BFS 算法的搜索逻辑，可见详细题解。

**详细题解：[BFS 算法解题套路框架](https://labuladong.github.io/article/fname.html?fname=BFS框架)**

**标签：[BFS 算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)，[二叉树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121994699837177859)**

## 解法代码

```java
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root 本身就是一层，depth 初始化为 1
        int depth = 1;

        while (!q.isEmpty()) {/**<extend down -200>

![](https://labuladong.github.io/algo/images/dijkstra/1.jpeg)
*/
            int sz = q.size();
            /* 遍历当前层的节点 */
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                /* 判断是否到达叶子结点 */
                if (cur.left == null && cur.right == null)
                    return depth;
                /* 将下一层节点加入队列 */
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            /* 这里增加步数 */
            depth++;
        }
        return depth;
    }
}
```

**类似题目**：
  - [752. 打开转盘锁 🟠](/problems/open-the-lock)
  - [剑指 Offer II 109. 开密码锁 🟠](/problems/zlDJc7)

</details>
</div>



