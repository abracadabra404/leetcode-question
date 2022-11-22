//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 1043, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

 
package com.xyx.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Q438FindAllAnagramsInAString{
      public static void main(String[] args) {
           Solution solution = new Q438FindAllAnagramsInAString().new Solution();
          String s = "cbaebabacd";
          String p = "abc";
           System.out.println(solution.findAnagrams(s,p));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        char[] sources = s.toCharArray();
        char[] targets = p.toCharArray();
        HashMap<Character, Integer> need = new HashMap<>(),window = new HashMap<>();
        for (Character character: targets) {
            need.put(character, need.getOrDefault(character, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();
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
            while (right -left >= targets.length) {
                // 这里找到了合法的字串
                if (valid == need.size()) {
                    res.add(left);
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
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }