package 数组操作.q35_搜索插入位置;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description: 排序数组和一个目标值，在数组中找到目标值，并返回其索引 ,如果不存在返回应该插入的位置
 * @create 2021-05-19 20:52
 **/
public class Solution {
    // 二分法，计算中间值
    // nums = [1,3,4]   target : 2
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {

            if (target<=nums[i]){
                return i;
            }

            if (target < nums[0]){
                return 0;
            }

            if (target > nums[nums.length -1 ]){
                return nums.length;
            }

        }
        return -1;
    }
}
