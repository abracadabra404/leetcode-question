//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// Related Topics哈希表 | 双指针 | 字符串 | 滑动窗口 
//
// 👍 801, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

 
package com.xyx.leetcode.editor.cn;

import java.util.HashMap;

public class Q567PermutationInString{
      public static void main(String[] args) {
           Solution solution = new Q567PermutationInString().new Solution();
          String s1 = "ab";
          String s2 = "eidbaooo";
          System.out.println(solution.checkInclusion(s1,s2));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] sources = s2.toCharArray();
        char[] targets = s1.toCharArray();
        HashMap<Character, Integer> need = new HashMap<>(),window = new HashMap<>();
        for (Character character: targets) {
            need.put(character, need.getOrDefault(character, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
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
                    return true;
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
        // 未找到合适的子串
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }