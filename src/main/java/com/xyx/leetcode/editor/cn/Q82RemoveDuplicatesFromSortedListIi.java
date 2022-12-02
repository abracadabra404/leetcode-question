//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics链表 | 双指针 
//
// 👍 1030, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.xyx.leetcode.editor.cn;

import com.xyx.leetcode.ListNode;

public class Q82RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new Q82RemoveDuplicatesFromSortedListIi().new Solution();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        System.out.println("before node:" + listNode);
        System.out.println("after node:" + solution.deleteDuplicates(listNode));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            // 设置虚拟头结点
            ListNode dummy = new ListNode(-1);
            // 将虚拟头结点与原链接头结点连接起来
            dummy.next = head;
            // 从虚拟头结点开始访问
            ListNode cur = dummy;
            // 只要当前节点的下一个节点与下下节点都存在，就继续访问下去
            while (cur.next != null && cur.next.next != null) {
                // 访问过程，下一个节点与下下节点相同，说明与这个节点的值所有的节点都应该删除掉
                if (cur.next.val == cur.next.next.val) {
                    // 删除的方法是先记录这个值
                    int value = cur.next.val;
                    // while 循环，不断的查找相同的节点
                    while (cur.next != null && cur.next.val == value) {
                        cur.next = cur.next.next;
                    }
                    // 下个节点与下下节点相同，说明cur可以加入到最终的结果链表
                } else {
                    // 继续访问后面的节点
                    cur = cur.next;
                }
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}