package 数据结构与算法.排序算法;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int [] arr = {4,6,8,5,9};
        heapSort(arr);

    }

    //堆排序的方法
    public static void heapSort(int[] arr){
//        System.out.println("堆排序");
//        adJustHeap(arr,1,arr.length);
//        System.out.println("第一次调整："+Arrays.toString(arr));
//        adJustHeap(arr,0,arr.length);
//        System.out.println("第二次调整："+Arrays.toString(arr));

        // 将 arr 调整成为大顶堆
        for (int i =arr.length/2 -1 ;i >=0 ;i --){
            adJustHeap(arr,i,arr.length);
        } // 96854  --》4 6859
        int temp =0;
        for (int j =arr.length -1 ;j >0 ;j --){
            //交换最大值位置
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adJustHeap(arr,0,j);
        }
        System.out.println("排序后："+Arrays.toString(arr));

    }


    /**
     *  功能：将以i对应的非叶子节点的树调整成为大顶堆，将数组转换成大顶堆
     * @param arr  待调整的数组
     * @param i         非叶子节点在数组中的索引
     * @param lenght    共有多少数组要调整，递减
     */
    public static void adJustHeap(int[] arr,int i,int lenght){
        int temp =arr[i]; //保存要调整 的非叶子节点
        //开始调整
        //k = i*2 +1 ,表示 i 节点的左子节点

        for (int k = i*2 +1 ; k <lenght; k= k*2 +1){

            if (k+1 < lenght && arr[k] < arr[k+1]){  // 左子节点的值 小于右子节点的值
                k ++;
            }
            if (arr[k] >temp){  //子节点 大于 父节点
                arr[i] =arr[k]; // 把较大的值赋给当前节点
                i = k;      // i指向k， 继续循环比较， 后续调整位置使用
            }else {
                break;  // 说明父节点最大 不用调整
            }
        }
        // 循环结束后，已经把以i为父节点树的最大值调整成为大顶堆
        arr[i] =temp;
    }

}
