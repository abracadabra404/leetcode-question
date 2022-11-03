package com.xyx.leetcode;

/**
 * @belongsProject: leetcode-question
 * @belongsPackage: com.xyx.leetcode
 * @author: yaxi.xu
 * @createTime: 2022-11-03  14:19
 * @description: TODO
 * @version: 1.0
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(val);
        if (next != null) {
            sb.append("->").append(next);
        }
        return sb.toString();
    }
}
