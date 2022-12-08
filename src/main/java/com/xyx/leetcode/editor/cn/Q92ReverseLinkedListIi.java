//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics链表 
//
// 👍 1451, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.xyx.leetcode.editor.cn;

import com.xyx.leetcode.ListNode;

public class Q92ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new Q92ReverseLinkedListIi().new Solution();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(solution.reverseBetween(listNode, 2, 4));
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == 1) {
                // 反转以head为起点的n个节点
                return reverseN(head, right);
            }
            head.next = reverseBetween(head.next, left - 1, right - 1);
            return head;
        }

        ListNode successor = null;

        private ListNode reverseN(ListNode head, int right) {
            if (right == 1) {
                // 记录第n+1个节点
                successor = head.next;
                return head;
            }
            ListNode last = reverseN(head.next, right - 1);
            head.next.next = head;
            // head指向第n+1个节点
            head.next = successor;
            return last;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}