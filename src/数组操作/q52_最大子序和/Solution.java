package 数组操作.q52_最大子序和;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @create 2021-05-21 18:21
 **/
public class Solution {
    /**
     *功能：不懂
     * @param nums 1
     * @version 0.0.1
     * @return int
     * @author zhaokai108
     * @date 2021/5/24 20:45
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];   //1,2,3,-1,2,3,4
        int sum = 0;
        // 1 、 从index  开始 找到正数
        for (int i = 0; i < nums.length; i++) {
            //
            if (sum > 0) {
                sum += nums[i];  //1  ,, 3 ,,  6
            } else {
                sum = nums[i];
            }
            max = Math.max(max, sum); // 1 ,3   6
        }
        return max;
    }
}
