package com.xyx.leetcode.editor.test;

public class FindArrayIndex  {
    public static void main(String[] args){

        int[] array = {2, 4, 3, 6, 5};
        int value = 3;
//        System.out.println(findIndex(array, value));
        System.out.println(findIndex2(array, value));

    }

    public static int findIndex(int[] array, int value) {
        // 实现查找逻辑
        if (array == null || array.length == 0) {
            return -1;
        }
        int i = 0;
        while (i < array.length) {
            if (array[i] == value) {
                return i;
            }
            i++;
        }
        return -1;
    }

    // 可读性差
    public static int findIndex2(int[] array, int value) {
        int length = array.length;
        // 实现查找逻辑
        if (array == null || length == 0) {
            return -1;
        }
        // 准备替换n-1的值
        if (array[length - 1] == value) {
            return length - 1;
        }
        // 将n-1的值保存到临时变量中
        int temp = array[length - 1];
        // 将n-1的值替换为value
        array[length - 1] = value;
        int i = 0;
        while (array[i] != value) {
            i++;
        }
        array[length - 1] = temp;
        if (i != length - 1) {
            return i;
        } else {
            return -1;
        }
    }
}
