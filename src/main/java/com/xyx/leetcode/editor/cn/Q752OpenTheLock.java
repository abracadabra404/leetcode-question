//你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9
//' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。 
//
// 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。 
//
// 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。 
//
// 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。 
//
// 
//
// 示例 1: 
//
// 
//输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//输出：6
//解释：
//可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
//注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
//因为当拨动到 "0102" 时这个锁就会被锁定。
// 
//
// 示例 2: 
//
// 
//输入: deadends = ["8888"], target = "0009"
//输出：1
//解释：把最后一位反向旋转一次即可 "0000" -> "0009"。
// 
//
// 示例 3: 
//
// 
//输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], 
//target = "8888"
//输出：-1
//解释：无法旋转到目标数字且不被锁定。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= deadends.length <= 500 
// deadends[i].length == 4 
// target.length == 4 
// target 不在 deadends 之中 
// target 和 deadends[i] 仅由若干位数字组成 
// 
//
// Related Topics广度优先搜索 | 数组 | 哈希表 | 字符串 
//
// 👍 569, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

 
package com.xyx.leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q752OpenTheLock{
      public static void main(String[] args) {
           Solution solution = new Q752OpenTheLock().new Solution();
           String[] deadends = {"0201","0101","0102","1212","2002"};
          String target = "0202";
          System.out.println(solution.openLock(deadends,target));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int openLock(String[] deadends, String target) {
        // 记录已经穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>();
        // 记录需要跳过的死亡密码
        Set<String> deads = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        for (String deadend : deadends) {
            deads.add(deadend);
        }
        // 从起点开始启动广度优先搜索
        int step = 0;
        q.offer("0000");
        visited.add("0000");
        while (!q.isEmpty()) {
            int sz = q.size();
            // 将当前队列中的所有节点向周围扩散
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                // 判断是否到达终点
                if (deads.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return step;
                }
                // 将一个节点的未遍历相邻节点加入队列
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            // 增加步数
            step++;
        }
        // 穷举完找不到目标密码，就是找不到
        return -1;
    }

          private String minusOne(String cur, int j) {
              char[] ch = cur.toCharArray();
              if (ch[j] == '0') {
                  ch[j]='9';
              }else {
                  ch[j] -= 1;
              }
              return new String(ch);
          }

          private String plusOne(String cur, int j) {
              char[] ch = cur.toCharArray();
              if (ch[j] == '9') {
                  ch[j]='0';
              }else {
                  ch[j] += 1;
              }
              return new String(ch);
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }