package 数据结构与算法.排序算法;

import java.util.Date;

/**
 *
 *
 * 快速排序（二分法排序）
 *    是对冒泡排序的一种改进
 * 思路： 通过一次排序将排序数据分割独立的两部分m1，m2 。 其中m1中所有的数 要 小于m2 ， 递归处理数据直到排序完成
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = new int[8000];

        for (int i = 0;i<arr.length;i++){
            arr[i] = (int) (Math.random()*8000);
        }
        Date s = new Date();
        sort(arr,0,arr.length-1);

//        for (int i = 0;i<arr.length;i++){
//            System.out.print(arr[i] + ",");
//        }
//        System.out.println();
        System.out.println("耗时：" + (new Date().getTime()-s.getTime()));

    }


    /**
     *
     * @param arr  数组
     * @param left  左下标
     * @param right    右下标
     */
    public static void sort(int[] arr,int left,int right){
        int l = left; //左下标
        int r = right;
        //中值
        int pivot = arr[(left + right)/2] ;
        int temp = 0;
        // 比pivot值小的放在中值左边，比pivot大的放在中值右边
        while (l < r){  //1，2，3，4，5
            //在pivot的左边一直找，直到大于等于prvot值，退出
            while (arr[l] < pivot){
                    l += 1;
            }
            //在pivot的右边一直找，直到小于等于prvot值，退出
            while (arr[r] > pivot){
                r -=1;
            }
            // pivot的左边和右边值已经全部分堆了
            if ( l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 交换完成后，发现这个arr[l] = pivot值 应该pivot前移动
            if (arr[l] == pivot){
                r -= 1;
            }
            // 交换完成后，发现这个arr[r] = pivot值 应该pivot后移动
            if (arr[r] == pivot){
                l += 1;
            }
        }
        if (l == r) {
            l +=1 ;
            r -=1 ;
        }
        //递归 处理左面排序
        if (left < r ){
            sort(arr,left,r);
        }
        //递归 处理右面排序
        if (right > l  ){
            sort(arr,l,right);
        }
    }

}
