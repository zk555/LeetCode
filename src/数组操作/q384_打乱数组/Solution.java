package 数组操作.q384_打乱数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 洗牌算法 o(n)
 *
 * 初始化原始数组和新数组，原始数组长度为n(已知)；
 *
 * 从还没处理的数组（假如还剩k个）中，随机产生一个[0, k)之间的数字p（假设数组从0开始）；
 *
 * 从剩下的k个数中把第p个数取出；
 *
 * 重复步骤2和3直到数字全部取完；
 *
 * 从步骤3取出的数字序列便是一个打乱了的数列。
 */
public class Solution {
    private int[] array;
    private int[] original;

    private Random rand = new Random();

    private List<Integer> getArrayCopy() {
        List<Integer> asList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            asList.add(array[i]);
        }
        return asList;
    }

    public Solution(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }

    public int[] shuffle() {
        List<Integer> aux =  getArrayCopy();

        //重新赋值数组 array[]
        for (int i = 0; i < array.length; i++) {
            int removeIdx = rand.nextInt(aux.size());
            array[i] = aux.get(removeIdx);
            aux.remove(removeIdx);
        }

        return array;
    }
}