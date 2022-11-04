  //给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
//
// Related Topics链表 | 双指针 
//
// 👍 640, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package com.xyx.leetcode.editor.cn;

  import com.xyx.leetcode.ListNode;

  public class Q86PartitionList{
      public static void main(String[] args) {
           Solution solution = new Q86PartitionList().new Solution();
          ListNode l1 = new ListNode(5, new ListNode(2));
          ListNode l2 = new ListNode(2, l1);
          ListNode l3 = new ListNode(3, l2);
          ListNode l4 = new ListNode(4, l3);
          ListNode l5 = new ListNode(1, l4);
          System.out.println(solution.partition(l5,3));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        // 存放小于x的的链表虚拟头结点
        ListNode dummy1 = new ListNode(-1);
        // 存放大于等于x的的链表虚拟头结点
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1, p2 = dummy2;
        // 这里p负责遍历原链表，类似合并两个有序链表的逻辑
        ListNode p = head;
        while (p != null) {
            if (p.val >= x) {
                p2.next = p;
                p2 = p2.next;
            } else {
                p1.next = p;
                p1 = p1.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }