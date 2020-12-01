package 数组操作.q945_使数组唯一的最小增量;

import java.util.Arrays;

/**
 * 先排序再遍历一次 o(n*log(n))
 *
 * 1 2 2 3 3 4
 *
 * t = 1
 */
public class Solution {

    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 0 || A.length == 1) {
            return 0;
        }

        int rs = 0;
        Arrays.sort(A);

        int t = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= t) {
                rs = rs + t - A[i] + 1;
                A[i] = t + 1;
            }
            t = A[i];
        }
        return rs;
    }

    public static void main(String[] args) {
        int[] temp ;
        temp= new int[]{1,2,2,4,7};
        int i = new Solution().minIncrementForUnique(temp);
        System.out.println("curmax = " + i);
    }
}
