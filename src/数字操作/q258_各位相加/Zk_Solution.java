package 数字操作.q258_各位相加;

/**
 *   100 = 1
 *   22  = 4
 *   66  = 3
 *
 *   10  -9  =1
 *   11 - 9 = 2
 *   12 - 9 = 3
 *   17 - 9 =9
 *   18- 9  =9
 *   19 - 9 = 10 - 9
 */
public class Zk_Solution {

    public int addDigits(int num) {

        if (num % 9 == 0 && num != 0) {
            num = 9;
        } else{
           num %= 9;
        }

        return num ;
    }
}
