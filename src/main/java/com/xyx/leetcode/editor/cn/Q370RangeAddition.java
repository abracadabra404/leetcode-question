package com.xyx.leetcode.editor.cn;

/**
 * @belongsProject: leetcode-question
 * @belongsPackage: com.xyx.leetcode.editor.cn
 * @author: yaxi.xu
 * @createTime: 2022-12-16  16:19
 * @description: TODO
 * @version: 1.0
 */
public class Q370RangeAddition {

    public static void main(String[] args) {
        
    }


    class Difference {

        private int[] diff;

        // 输入初始数组，区间操作在这个数组上进进行
        public Difference(int[] nums) {
            assert nums.length > 0;
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        // [i,j] 增加 val
        public void increment(int i, int j, int value) {
            diff[i] += value;
            if (j + 1 < diff.length) {
                diff[j + 1] -= value;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 0; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }


    }
}
