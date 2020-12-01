package 数组操作.q54_螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

public class Zk_Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }

        // 开始坐标位置 （0，0）
        int startx = 0;
        int starty = 0;
        //结尾的坐标位置 （4，4）
        int endx = matrix.length-1;
        int endy = matrix[0].length-1;

        while (startx < endx && starty < endy) {
            for (int i = starty; i < endy ; i++) {
                list.add(matrix[startx][i]);
            }
            for (int i = startx; i < endx ; i++) {
                list.add(matrix[i][endy]);

            }
            for (int i = endy; i > starty; i--) {
                list.add(matrix[endx][i]);

            }
            for (int i = endx ; i > startx; i--) {
                list.add(matrix[i][starty]);
            }
            startx++;
            endx--;
            starty++;
            endy--;
        }
        //只有一行时
        if(starty == endy){
            while (startx <= endx) {
                list.add(matrix[startx++][starty]);
            }
        }else {
            //只有一列时
            if(startx == endx){
                while (starty <= endy) {
                    list.add(matrix[startx][starty++]);
                }

            }

        }
        return list;
    }
}
