package 数据结构与算法.算法.二分查找算法;

/**
 * 二分查找算法（非递归）
 */
public class BinarySearchAlgorithm {

    public static void main(String[] args) {
        int [] arr = {1,3,5,6,7,8,9};
        int i = binarySearch(arr, 3);
        System.out.println(i);
    }

    /**
     *
     * @param arr  待查找的数组
     * @param target  要查找的数
     * @return
     */
    public static int binarySearch(int []arr,int target){
        int left = 0;
        int right =arr.length -1 ;
        while (left < right){  //1,2,3,4   //2
            int mid = (left +right)/2;  // 0， 4 /mid =2
            if (arr[mid] == target){
                return mid;
            }else if (arr[mid] >target){
                right = mid -1;  //需要向左查找
            }else {
                left = mid +1;   //需要向右查找
            }
        }
        return -1;
    }
}
