package 数据结构与算法.数组;

/**
 *   稀疏数组  与  二维数组转换
 */
public class SparseArray {

    public static void main(String[] args) {

        int[][] sparse = new int[11][11];
        sparse[1][2] = 1;
        sparse[2][3] = 2;

        // 转换 稀疏数组
        int sum = 0;

        for (int i =0 ;i<sparse.length ;i ++){
            for (int j =0; j < sparse[i].length; j++){
                if (sparse[i][j]!=0){
                    sum ++;
                }
            }
        }
        //赋值
        int[][] sparseArr = new int[sum + 1 ][3];
        sparseArr[0][0] = sparse.length;
        sparseArr[0][1] = sparse[0].length;
        sparseArr[0][2] = sum;
        for (int i =0 ;i<sparse.length ;i ++){
            for (int j = 0; j < sparse[i].length; j++){
                if (sparse[i][j]!=0){
                    sparseArr[i+1][0] = i;
                    sparseArr[i+1][1] = j;
                    sparseArr[i+1][2] = sparse[i][j];
                }
            }
        }


        // 稀疏数组 --》 二维数组
        int chessArr[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1 ; i < sparseArr.length;i++){
                chessArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
    }
}
