package 数据结构与算法.递归;

import java.util.Arrays;

/**
 *  1. 执行一个方法时，就创建了一个栈空间
 *  2. 方法的局部变量是独立的，不会相互影响
 *  3. 如果方法中使用引用类型的变量，就会相互影响 ，例如 《堆中的数据，  多个栈都指向一个地址》
 *  4. 递归必须要有退出条件 （否则会出现栈溢出的情况）
 *
 *  迷宫问题： 1. 创建一个二维数组来模拟一个迷宫
 */
public class Solution2 {

    public static void main(String[] args) {

        int[][] map = new int[8][7];
        // 1 表示 墙
        for (int i = 0 ;i < 7 ;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0 ;i < 8 ;i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;
        for (int i =0;i < 8; i++){
            for (int j =0;j < 7; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        setWay(map,1,1);
        for (int i =0;i < 8; i++){
            for (int j =0;j < 7; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }


    /**
     * 使用递归找到小球的路径
     * 约定 ：map[i][j] ==0 ,代表表示该点没有走过 , 1 代表是墙 ，2 表示该点可以走  3，表示该点走过但是走不通
     * 在走迷宫时，需要制定一个策略 下 -->右 --> 上 --》 左 ，如果走不通，再回溯
     * @param map 地图
     * @param i
     * @param j
     * @return
     */
    public static boolean setWay(int[][] map,int i,int j){


        if (map[6][5] == 2){
            System.out.println("找到路！！！");
            return  true;
        }else {
            if (map[i][j] == 0){  //如果当前点没有走过
                //按照策略 策略 下 -->右 --> 上 --》 左
                map[i][j] = 2;
                if (setWay(map,i+1,j)){   //注意一个问题，  if（） 里面条件都会试着运行
                    return true;
                }else if (setWay(map,i,j+1)){  // 当 策略都走不通 ，那么会产生回溯
                    return true;
                }else if (setWay(map,i-1,j)){
                    return true;
                }else if (setWay(map,i,j-1)){
                    return true;
                }else {
                    map[i][j] =3 ; //标记走不通
                    return false;
                }
            }else {  // 如果map[i][j] !=0 ,可能是1 2 3
                return false;
            }
        }
    }
}
