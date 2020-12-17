package 数据结构与算法.查找.差值查找算法;

/**
 * 对于二法查找的 优化，  计算中值更快
 *
 * int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
 *
 *     对于数据量较大，关键字分布比较均匀的查找表来说，采用插值查找, 速度较快.
 *     关键字分布不均匀的情况下，该方法不一定比折半查找要好
 */
public class InterpolatQuery {

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        int search = insertValueSearch(arr, 0, arr.length -1, 5);
        System.out.println(search);
    }


    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        //注意：findVal < arr[0]  和  findVal > arr[arr.length - 1] 必须需要
        //否则我们得到的 mid 可能越界
        if (left > right || findVal < arr[left] || findVal > arr[right]) {
            return -1;
        }

        // 求出mid, 自适应
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) { // 说明应该向右边递归
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 说明向左递归查找
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }

    }
}
