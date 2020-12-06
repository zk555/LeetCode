package 数据结构与算法.递归.八皇后;

/** 问题： 任意两个皇后不能摆在同一行，同一列，同一斜线
 *  思路：
 *      1.第一个皇后先放在第一行第一列
 *      2. 第二个皇后放在第二行第一列，然后判断是否OK，如果不ok，继续放到第二列，第三列，依次把所有的列都放完，找打合适的
 *      3. 继续第三列，直到第八列都没有冲突找打正确解读。
 *      4. 当得到一个正确解时，在栈回退到上一个栈时。开始回溯即将第一行所有的正确解找到
 *
 *      arra[8] = {0，4，7，5，2，6，1，3}  ，下标代表具体哪一个皇后
 */
public class bahuanghou {

    int max = 8 ; //共有多少个皇后

    static  int count=0 ;
    int[] array = new int[max];  //保存皇后最后位置，arra[8] = {0，4，7，5，2，6，1，3}
    public static void main(String[] args) {
            // 测试8皇后是否正确
        bahuanghou s  = new bahuanghou();
        s.check(0);
        System.out.println(count);
    }

    //放入第n个皇后 , n ++
    private void check(int n) { //0
        if (n == max){  // 代表已经放入 8个 完成
            print();
            return;
        }
        //依次放入皇后，并检查是否冲突  （回溯，每次冲突都需要重新计算）
        for (int i =0 ; i<max ;i ++) {
            //先把当前皇后放入第一列
            array[n] = i;  //a[0] = 0.  ,每次进入后 ，都从0 开始放入
            if (jude(n)){  //不冲突
                check(n +1 );  // i= 7时间  判断 n=i+1 ?
            }
            //如果冲突，继续执行array[n] = i, 即将第n个皇后后移个位置
        }
    }

    //查看放入的皇后去检查该皇后和前面已经摆放的皇后是否冲突,
    //数组下标 代表第几行

    //array[i] == array[n] 同一列， Math.abs(n-i) == Math.abs(array[n] -array[i]) 斜线，绝对值
    private boolean jude(int n) {
        for (int i=0 ;i<n;i++){
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    //将最后结果打印
    public  void print(){
        count ++;
        for(int i = 0 ; i <array.length; i ++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
