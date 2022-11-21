//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(n) 时间内解决此问题的算法吗？
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 2253, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

 
package com.xyx.leetcode.editor.cn;

import java.util.HashMap;

public class Q76MinimumWindowSubstring{
      public static void main(String[] args) {
           Solution solution = new Q76MinimumWindowSubstring().new Solution();
          String source = "EBBANCF";
          String target = "ABC";
          System.out.println(solution.minWindow(source,target));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        char[] sources = s.toCharArray();
        char[] targets = t.toCharArray();
        HashMap<Character, Integer> need = new HashMap<>(),window = new HashMap<>();
        for (Character character: targets) {
            need.put(character, need.getOrDefault(character, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖字串的起始索引以及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < sources.length) {
            // c是将移入窗口的字符
            char c = sources[right];
            // 扩大窗口
            right++;
            // 进行窗口内的数据一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 这里更新最小覆盖字串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d是将移出窗口的字符
                char d = sources[left];
                // 缩小窗口
                left++;
                // 进行窗口内的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid --;
                    }
                    window.put(d, window.getOrDefault(d,0) - 1);
                }
            }
        }
        // 返回最小覆盖字串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }