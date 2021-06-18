package 数字操作.q7_整数反转.f2;

/**
 * 求余（判断是否溢出有多种方式） o(log(n))
 */
public class Solution {
    public int reverseof(int x) {
        int rs = 0;
        while (true) {
            int y = x % 10; // 余数 ，反转头
            x = x / 10;     // 除10后的数据
            if (rs * 10 / 10 != rs) {
                return 0;
            }

            //余数每次 * 10 ,再加新余数
            rs = rs * 10 + y; //21

            //除尽
            if (x == 0) {
                break;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(-123%10);
    }
}
