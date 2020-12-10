package 数据结构与算法.排序算法;

import java.util.Date;

/**
 * 是对欲排序的元素以插入的方式找寻该元素的适当位置，以达到排序的目的
 *
 * 思想：
 *     把待排序的元素 看成两表 ，一个有序表和一个无序表
 *     开始时有序表只有一个元素，无序表中含有n-1个元素
 *
 *     每次确定一个元素大小，如果把每次要确定的元素放在合理的位置
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] nums = new int[80000];
        InsertSort dubboSort = new InsertSort();

        for (int i = 0;i<nums.length;i++){
            nums[i] = (int) (Math.random()*80000);
        }
        Date s = new Date();
        dubboSort.sort(nums);
        for (int i = 0;i<nums.length;i++){
            System.out.print(nums[i] +",");
        }
        System.out.println("耗时：" + (new Date().getTime()-s.getTime()));
    }


    //插入排序
    public void sort(int[] nums){
        for (int i = 1 ; i <nums.length ; i++){ //1 ,0
            //拿到要确定的元素
           int value = nums[i];  // 本次要插入的数, value =0
           int index = i-1;  //开始对比的位置    // i=1 ，1,0 index =0
           while (index >= 0 ){ // 数组不越界 并且 插入值
               if ( value < nums[index]){
                   nums[index + 1] = nums[index];  //如果不是插入位置，元素后移
                   index -- ;
               }else {
                   if (index < i-1 ){
                       nums[index + 1] =value;
                   }
                   break;
               }
           }
            if (index < 0) {
                nums[index + 1] =value;
            }
//           if (index < i-1 ){  // 如果 插入位置 == 要比对的位置
//               nums[index + 1] =value;
//           }

        }
    }
}
