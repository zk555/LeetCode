package 数字操作.q00_最大公约数;

public class Sulotion { /**
 * 普通暴力枚举解法求最大公约数
 *
 * 从较小整数的一半开始，试图找到一个合适的整数i,看这个整数是否被a和b同时整除
 * @param a
 * @param b
 * @return
 */
public static int getGreatestCommonDivisor(int a,int b){
    int big = a>b?a:b;
    int small = a<b?a:b;
    if (big%small == 0){
        return small;
    }
    for (int i=small/2;i>1;i--){
        if (small%i==0 && big%i==0){
            return i;
            //这个整数 i 从2开始循环累加，一直累加到numberA和numberB中较小参数的一半为止。
            //循环结束后，上一次寻找到的能够被两数整除的最大 i 值，就是两数的最大公约数。
        }
    }
    return 1;
}

    /**
     * 辗转相除法
     *
     * 两个正整数a 和 b（a>b）,他们的最大公约数等于a除以b的余数c和b之间的最大公约数
     * 把两个较大整数之间的运算简化成两个较小整数之间的运算，直到两个数可以整除，或者其中一个数减小到1为止
     *
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisorV2(int a,int b){
        int big = a>b?a:b;
        int small = a<b?a:b;
        if (big%small == 0){
            return small;
        }
        return getGreatestCommonDivisorV2(big%small,small);
    }

    /**
     * 更相减损法
     * 两个正整数a和b(a>b),他们的最大公约数等于a-b的差值c和较小数b的最大公约数
     * 把两个较大整数之间的运算简化成两个较小整数之间的运算，直到两个数可以相等为止，最大公约数就是最终相等的这两个数的值
     * @param a
     * @param b
     * @return
     */

    public static int getGreatestCommonDivisorV3(int a,int b){
        if (a == b){
            return a;
        }
        int big = a>b?a:b;
        int small = a<b?a:b;
        return getGreatestCommonDivisorV3(big-small,small);
    }

    /**
     * 移位运算
     *
     * 当a和b都是偶数的时候，gcb(a,b) = 2*gcb(a/2,b/2) = 2*gb(a>>1,b>>1)
     * 当a是偶数,b是奇数的时候，gcb(a,b) = gcb(a/2,b) = 2*gb(a>>1,b)
     * 当a是奇数，b是偶数的时候，gcb(a,b) = gcb(a,b/2) = 2*gb(a,b>>1)
     * 当a和b都是奇数的时候，先利用更相减损术运算一次，gcb(a,b) = gcb(b,a-b),此时a-b必然是偶数，可以继续移位运算
     *
     * 判断整数就行的方法是让整数和1进行与运算，如果(a&1)==0,则说明整数a是偶数，如果(a&1)!=0,则说明整数a是奇数
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisorV4(int a,int b){
        if (a == b){
            return a;
        }
        if ((a&1)==0 && (b&1) == 0){
            return getGreatestCommonDivisorV4(a>>1,b>>1)<<1;
        }else if ((a&1)==0 && (b&1) != 0){
            return getGreatestCommonDivisorV4(a>>1,b);
        }else if ((a&1)!=0 && (b&1) == 0){
            return getGreatestCommonDivisorV4(a,b>>1);
        }else{
            int big = a>b ? a:b;
            int small = a<b ? a:b;
            return getGreatestCommonDivisorV4(big-small,small);
        }
    }



    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(25,5));
        System.out.println(getGreatestCommonDivisor(100,80));
        System.out.println(getGreatestCommonDivisor(27,14));
    }
}
