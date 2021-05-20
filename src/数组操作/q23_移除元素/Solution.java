package 数组操作.q23_移除元素;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description: 删除给定数组中的指定元素、返回删除后的长度
 * @create 2021-05-19 20:39
 **/
public class Solution {

    public int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0; // 辅助索引，从0 ,存放不等于val
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
