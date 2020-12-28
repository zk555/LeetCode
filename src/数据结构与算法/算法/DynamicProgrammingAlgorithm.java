package 数据结构与算法.算法;

/**
 * 动态规划算法：
 *  核心思想：将大问题划分为小问题进行解决，从而一步步获取最优解的处理算法
 *           动态规划和分治算法类似，其基本思想也是将待求解划分成多个子问题，先求子解，然后重子解中找到原问题的解
 *           与分治算法不同的是，适用于动态规划求解的问题，经求解得到的子问题往往不是相互独立的
 *           即 下个问题的解可能建立在上一个问题的解
 *
 * 问题： 背包总量 10kg,
 *  给定几个物品分别有重量价格，问怎么组合才能使价值最大，且装入物品不能重复、
 *  思路：v:代表物品的价值 w:代表重量
 *      01背包和完全背包 ， 01背包每个问题只能放一次，完全背包 无限制
 *      (1)、v[i][0] =v[0][i]=0
 *     （2)、w[i] >j 时， v[i][j] = v[i-1][j]   //打算新增的商品容量> 当前背包的容量，直接使用上一个单元格物品
 *      (3)、j >w[i]时，v[i][j] =max{v[i-1][j],v[i-1][j-w[i]]+v[i]}
 *      //当准备新增的商品的容量<=当前商品容量，
 *      v[i-1][j-w[i]] 到剩余空间j-w[i]的最大值 ，
 *      v[i] 表示当前商品的价值
 *
 *      v[3][4] =max{v[2][4],v[3]+v[2][1]}
 *      */
public class DynamicProgrammingAlgorithm {

    public static void main(String[] args) {
        int[] w = {1, 4, 3};  //物品的重量
        int[] val = {1500, 3000, 2000};//物品的价值,v[i]

        int m = 4; //背包容量
        int n = val.length;

        //创建二维数组 v[i][j] : 表示前面i个物品能够装入容量为j的背包中的最大价值
        int[][] v = new int[n + 1][m + 1];
        //保存商品的情况
        int[][] path = new int[n + 1][m + 1];
        //初始v[0][] 和v[i][0]
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }



        //根据前面的公式，来动态规划处理
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[i].length; j++) {
                if(w[i-1] >j){
                    v[i][j] =v[i-1][j];
                }else {
                    // i的坐标
//                    v[i][j] =Math.max(v[i-1][j],v[i-1][j-w[i-1]]+val[i-1]);

                    //记录商品，修改代码
                    if (v[i-1][j] < v[i-1][j-w[i-1]]+val[i-1] ){
                        v[i][j] = v[i-1][j-w[i-1]]+val[i-1];
                        path[i][j]= 1;
                    }else {
                        v[i-1][j] = v[i-1][j];
                    }
                }
            }
        }

        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
    }

}
