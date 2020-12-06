package 数据结构与算法.递归;

/**
 * 1 递归; 递归就是方法自己调用自己，每次调用时传入不同的参数，递归有助于编程者解决复杂的问题，同时让代码简洁
 *
 * 2. 递归调用的规则：
 *      1，当程序执行到一个方法时，就会开辟一个独立的空间（栈）
 *      2. 每个空间内的数据（局部变量）都是独立的
 */
public class Solution1 {

    public static void main(String[] args) {
//        test(5);
        ;
        System.out.println("n =" + factorial(4));
    }
    // 打印问题
    public static void test(int n){
        if (n>2 ){
            System.out.println("n==" + n);
            test(n-1);
        }

        System.out.println(n);
    }


    //阶乘问题
    public static int factorial(int n){
        if (n ==1) {
            return 1;
        }else {
            return factorial(n-1) *n;
        }
    }
}
