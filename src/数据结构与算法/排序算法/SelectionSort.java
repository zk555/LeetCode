package 数据结构与算法.排序算法;

import java.util.Date;

/**
 *  属于内部排序，是从欲选择的数据中，按指定的规则选出某个元素，再依据规定交换位置，达到排序效果
 *
 *   1.每次找到 数组的最小值 放入第一位， 依次找到第二个 。。。
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = new int[80000];
        SelectionSort dubboSort = new SelectionSort();

        for (int i = 0;i<nums.length;i++){
            nums[i] = (int) (Math.random()*80000);
        }
        Date s = new Date();
        dubboSort.sort(nums);
        for (int i = 0;i<nums.length;i++){
            System.out.print(nums[i] + ",");
        }
        System.out.println();
        System.out.println("耗时：" + (new Date().getTime()-s.getTime()));
    }

    public void sort(int[] nums){
//        for (int i = 0 ;i <nums.length -1 ;i++){
//            int min = nums[i] ;
//            int minIndex = i;
//            for (int j = i+1 ;j <nums.length ;j++){
//                if (min > nums[j]){
//                    min=nums[j];
//                    minIndex = j ;
//                }
//            }
//            if (minIndex != i){
//                nums[minIndex] = nums[i];
//                nums[i] = min;
//            }
//        }


        for (int i = 0 ;i <nums.length -1 ;i++){
            int max  ;
            for (int j = i+1 ;j <nums.length ;j++){
                if (nums[i] < nums[j]){
                    max = nums[i];
                    nums[i]=nums[j];
                    nums[j]= max;
                }
            }

        }
    }
}
