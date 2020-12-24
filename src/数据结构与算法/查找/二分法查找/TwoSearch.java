package 数据结构与算法.查找.二分法查找;

import java.util.ArrayList;
import java.util.List;

/**
 *   ,：
 *          1. 首先确定中间值下标 mid = l +r /2
 *          2. 然后将需要查找的数做比较
 *          3. 根据 arr[mid] = findVal ? 做递归
 *              退出条件： left > right  ,arr[mid] = findVal
 *
 *
 *          4. 1,2,3,4,5，5,6  查询出所有的5
 *              找到mid 值时，不要马上返回，
 *              向mid 索引值的左扫描，将满足所有查找元素存到缓存中
 *              向mid 索引值的右扫描，将满足所有查找元素存到缓存中
 */
public class TwoSearch {


    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        int search = search(arr, 0, arr.length -1, 7);
        System.out.println(search);
    }


    public static  int search(int[] arr,int left,int right,int findVal){
        List list= new ArrayList();
        if (left > right) {  //退出递归条件，
            return  -1 ;
        }
        int mid = (left + right) /2;
        int value = arr[mid];
        if (value > findVal){
            return search(arr,left,mid - 1,findVal);
        }else if (value < findVal){
            return search(arr,mid +1,right,findVal);
        } else {
            return mid;  //找到相等直接返回
        }
    }


    public static  ArrayList search2(int[] arr,int left,int right,int findVal){
        List list= new ArrayList();
        if (left > right) {  //退出递归条件，
            return  new ArrayList<Integer>() ;
        }
        int mid = (left + right) /2;
        int value = arr[mid];
        if (value > findVal){
            return search2(arr,left,mid - 1,findVal);
        }else if (value < findVal){
            return search2(arr,mid +1,right,findVal);
        } else {
            ArrayList resIndexList = new ArrayList();
            int temp = mid -1 ;
            while (true){
                if (temp < 0 || arr[temp] != findVal){  //查找左边相同的数
                    break;
                }
                resIndexList.add(temp);
                temp -- ;
            }
            resIndexList.add(mid);

            temp = mid + 1 ;
            while (true){
                if (temp > arr.length -1  || arr[temp] != findVal){ //查找右边相同的数
                    break;
                }
                resIndexList.add(temp);
                temp ++ ;
            }
            return resIndexList;  //找到相等直接返回
        }
    }
}
