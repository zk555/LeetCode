package 数据结构与算法.排序算法;

import java.util.Arrays;

/**
 *
 * 归并排序： 采用经典的分治策略，将问题分成小的问题然后递归求解，最后将小阶段的结果合并成为想要的结果
 *
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr  = {8,4,1,3};
        int[] temp= new int[arr.length];
        mergeSort(arr,0,arr.length -1,temp);
        System.out.println("arr = " + Arrays.toString(arr));
    }


    public static void mergeSort(int[] arr ,int left , int right,int[] temp){
            if (left <right){
                int mid =(left +right)/2;
                mergeSort(arr,left,mid,temp);
                mergeSort(arr,mid+1,right,temp);  //递归 ， 以空间换取时间

                //上部分并结束， 开始合并
                merge(arr,left,mid,right,temp);
            }
    }


    /**
     * 合并的方式
     * @param arr  排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid    中间索引
     * @param right  右边索引
     * @param temp      临时数组
     */
    public static void merge(int[] arr ,int left ,int mid, int right,int[] temp){
        int i = left;  //初始化数组左边索引，
        int j = mid + 1 ; //右边有序序列索引
        int t = 0;      //指向temp 临时索引

        // 左、右两边有序的数组按照指定规则，依次排序放入到临时数组中，直到左、右一边处理完成位置
        while (i <=mid && j<=right){

            //（一）
            //如果左边当前元素小于等于右边当前元素，即左边当前元素放入到临时数组中，
            //然后t++,i++
            if (arr[i] <= arr[j]){
                temp[t] =arr[i];
                t +=1;
                i +=1 ;
            }else {  //反之，将右边有序序列的当前元素。填充到temp数组中
                temp[t] = arr[j];
                t +=1 ;
                j +=1;
            }
        }

            //二
            //把剩余数据全部填充到temp中
        while ( i <= mid ){  //左边有剩余
            temp[t] =arr[i];
            t+=1;
            i+=1;
        }

        while ( j <= right ){  //右边有剩余
            temp[t] =arr[j];
            t+=1;
            j+=1;
        }
//三
        // 拷贝，将temp数组的元素拷贝到arr中
        // 不是拷贝所有
        t = 0 ;
        int tempLeft =left;
        while (tempLeft <= right){
            arr[tempLeft] =temp[t];
            t +=1;
            tempLeft +=1;
        }

    }
}
