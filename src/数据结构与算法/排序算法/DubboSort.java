package 数据结构与算法.排序算法;

import java.util.Date;

/**
 *  1. 冒泡排序
 *  2. int [] = {5,4,14,3,9,0}
 *
 *  规则：  排序次数 数组大小-1 循环
 *          每一趟排序的次数逐渐减少
 */
public class DubboSort {

    public static void main(String[] args) {

        int[] nums = new int[80000];
        DubboSort dubboSort = new DubboSort();

        for (int i = 0;i<nums.length;i++){
            nums[i] = (int) (Math.random()*80000);
        }
        Date s = new Date();
        dubboSort.sort(nums);
        System.out.println("耗时：" + (new Date().getTime()-s.getTime()));
    }

    /**
     *  第一次循环i=0 找到 最大值放在最后
     *  第二次循环i=1 找到最大值放在倒数第二位
     * @param nums
     */
    public void sort(int[] nums){
        int temp  = 0;
        // 执行lenght-1 次
        boolean flag = true;  // 1 2 3 4
        for (int i =0;i< nums.length -1 ;i++) {   // 一共需要遍历 n-1 次
            // 冒泡，每次确定最大的值
            for (int j = 0; j < nums.length-1-i ; j++) {  // 因为确定了最大值，所以每次最大值不需要比较
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }

    }
}
