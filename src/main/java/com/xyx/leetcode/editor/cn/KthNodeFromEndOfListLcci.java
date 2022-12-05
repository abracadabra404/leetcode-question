//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。 
//
// 注意：本题相对原题稍作改动 
//
// 示例： 
//
// 输入： 1->2->3->4->5 和 k = 2
//输出： 4 
//
// 说明： 
//
// 给定的 k 保证是有效的。 
//
// Related Topics链表 | 双指针 
//
// 👍 116, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.xyx.leetcode.editor.cn;

import com.xyx.leetcode.ListNode;

public class KthNodeFromEndOfListLcci {
    public static void main(String[] args) {
        Solution solution = new KthNodeFromEndOfListLcci().new Solution();
        ListNode listNode = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(2, new ListNode(5, new ListNode(6))))));
        System.out.println(solution.kthToLast(listNode, 3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int kthToLast(ListNode head, int k) {
            ListNode p1 = head;
            // p1先走k步
            for (int i = 0; i < k; i++) {
                p1 = p1.next;
            }
            ListNode p2 = head;
            // p1,p2同时走n-k步
            while (p1 != null) {
                p2 = p2.next;
                p1 = p1.next;
            }
            // 此时p2指向第n-k+1步，即倒数第k个节点
            return p2.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}