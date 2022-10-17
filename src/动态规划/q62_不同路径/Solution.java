package 动态规划.q62_不同路径;

import java.util.HashSet;
import java.util.Set;

/**
 * 动态规划 dp[i][j]是到达i, j的最多路径 dp[i][j] = dp[i-1][j] + dp[i][j-1] o(m*n)
 */
public class Solution {

    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().uniquePaths(4,2));

        int[] set = new int[] { 1, 2 ,3};

        Set<Set<Integer>> result = getSubSet(set);

        for (Set<Integer> subSet : result) {

            for (Integer num : subSet) {
                System.out.print(num);
            }



            System.out.println("");

        }
    }


    public static Set<Set<Integer>> getSubSet(int[] set) {

//用来存放子集的集合,如{{},{1},{2},{1,2}}

        Set<Set<Integer>> result = new HashSet<Set<Integer>>();

        int length = set.length;

//2的n次方

        int num = 1 << length;

//从0到2^n-1([00...00]到[11...11])

        for (int i = 0; i < num; i++) {

            Set<Integer> subSet = new HashSet<Integer>();

            int index = i;

            for (int j = 0; j < length; j++) {

//每次判断index最低位是否为1,为1则把集合set的第j个元素放到子集中

                if ((index & 1) == 1) {

                    subSet.add(set[j]);

                }

//右移一位

                index >>= 1;

            }

//把子集存储起来

            result.add(subSet);

        }

        return result;

    }



}
