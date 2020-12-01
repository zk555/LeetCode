package 数组操作.q73_矩阵置零;

import java.util.HashSet;
import java.util.Set;

/**
 *  1,0,3
 *  1,2,3
 *  1,2,3
 */
public class Zk_Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> row_zero = new HashSet<>();  // 0
        Set<Integer> col_zero = new HashSet<>();  // 1

        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i<row;i++){
            for (int j =0 ; j  < col; j++){
                if (matrix[i][j] == 0){
                    row_zero.add(i);
                    col_zero.add(j);
                }
            }
        }

        System.out.println("记录每个元素为零的位置 = 完成 " );

        for (int i = 0 ; i < row ; i ++){
            for (int j = 0; j < col; j++) {
                if (row_zero.contains(i) || col_zero.contains(j))
                    matrix[i][j] = 0;
            }
        }
    }
}
