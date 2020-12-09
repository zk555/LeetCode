package hash相关.q1_两数之和.f2;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 一遍hash o(n)
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Date dd =new Date();
        int[] nums= {1,2,3,4,5,6};
        int[] ints = solution.twoSum(nums, 6);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
        System.out.printf("耗时：" + (new Date().getTime()-dd.getTime()) );
    }
}
