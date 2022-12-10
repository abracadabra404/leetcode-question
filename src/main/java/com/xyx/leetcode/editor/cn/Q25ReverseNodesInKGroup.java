//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics递归 | 链表 
//
// 👍 1868, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.xyx.leetcode.editor.cn;

import com.xyx.leetcode.ListNode;

public class Q25ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new Q25ReverseNodesInKGroup().new Solution();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(solution.reverseKGroup(listNode, 2));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 区间包含[a,b)个待反转的元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            // 找到k个节点后的b节点，不包含b
            b = b.next;
        }
        // 反转前k个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    private ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
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
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy;
            ListNode end = dummy;
            while (end.next != null) {
                for (int i = 0; i < k && end != null; i++) {
                    end = end.next;
                }
                if (end == null) {
                    break;
                }
                ListNode start = pre.next;
                ListNode next = end.next;
                end.next = null;
                pre.next = reverse(start);
                start.next = next;
                pre = start;
                end = pre;
            }
            return dummy.next;
        }

        public ListNode reverse(ListNode head) {
            ListNode pre, cur, nxt;
            pre = null;
            cur = head;
            while (cur != null) {
                nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            return pre;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}