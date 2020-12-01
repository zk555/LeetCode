package 数组操作.q945_使数组唯一的最小增量;

import java.util.Arrays;

/**
 * 排序
 */
public class Zk_solution {

    public static void main(String[] args) {
        int[] temp ;
        temp= new int[]{1,2,2,4,2};
        int i = new Zk_solution().minIncrementForUnique(temp);
        System.out.println("curmax = " + i);
    }

    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A); // 先排序
        int curmax = -1; // 当前数组最大值
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= curmax) {
                // 当前元素 A[i] 需要增加到 curmax + 1
                res += (curmax + 1 - A[i]); // 记录自增次数
            }
            curmax = Math.max(curmax + 1, A[i]);  // 取出当前节点 和 curMax的最大值
        }
        return res;
    }
}
