package 数组操作.q78_子集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 不考虑 nums 有重复元素
 */
public class Zk_solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result =new ArrayList<>();
        //放入空子集
        result.add(new ArrayList<>());
        for (int i = 0 ; i <nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> temp = new ArrayList<>(result.get(j)); // 构建一个新的集合
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        new Zk_solution().subsets(nums);
    }
}
