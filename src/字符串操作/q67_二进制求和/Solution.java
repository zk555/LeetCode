package 字符串操作.q67_二进制求和;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/6/2 9:01
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class Solution {

    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder(); //结果

        int i = a.length() - 1;
        int k = b.length() - 1;  // 重个位开始遍历

        int t = 0;  //进位

        //如果没有遍历完两个数，或者还有进位
        while (i >= 0 || k >= 0 || t != 0) {
            if (i >= 0) {
                t = t + a.charAt(i--) - '0';  // -‘0’ 得到19进制值
            }

            if (k >= 0) {
                t += b.charAt(k--) - '0';
            }

            ans.append(t % 2);
            t /= 2; //进位
        }
        return ans.reverse().toString();
    }


    public static void main(String[] args) {
        String a = "1111";
        String b = "1001";
        Solution solution = new Solution();
        System.out.println(solution.addBinary(a, b));
    }
}
