package 数组操作.q26_删除有序数组中的重复项;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description: 有序数组， 删除重复元素
 * @create 2021-05-18 14:52
 **/
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int p = 0;  //记录升序指针
        int q = 1;  // 后指针
        while (q != nums.length - 1) {
            if (nums[p] != nums[q]) { // 找到升序最后一个
                nums[++p] = nums[q];
            }
            q++;
        }
        return p + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(nums));
    }
}
