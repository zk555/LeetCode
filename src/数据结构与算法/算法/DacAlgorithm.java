package 数据结构与算法.算法;

/**
 * 分治算法 ， --汉罗塔
 */
public class DacAlgorithm {

    public static void main(String[] args) {
        sort(3,'A','B','C');
    }


    // 使用分治算法，完成汉罗塔
    private static void sort(int num,char a,char b, char c){
        //如果只有一个盘
        if (num == 1){
            System.out.println("第1个盘："+a+"-->"+ c);
        }else {
            //如果有大于等于2个盘，那么可以看成2个盘，最下面的盘和上面所有盘
            //1. 先把最上面的盘 A -->b上 ,移动过程会用到 c
            sort(num-1 ,a,c,b);

            //把A --> c
            System.out.println("第"+ num +"个盘:" + a + "-->" +c);

            //把B塔的所有盘从 b -->c， 移动过程种借助A
            sort(num-1,b,a,c);
        }
    }
}
