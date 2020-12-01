package 数字操作.q43_字符串相乘;

/**
 *  两个巨大数相乘
 */
public class Zk_Solution {

    public String multiply(String num1, String num2) {

        if (num1 == null|| num2 == null) {
            return null;
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        //将两个字符串转换成char 类型数组
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;
        int[] resInts = new int[length1 + length2];

        int sum = 0;

        for (int i =length1-1 ;i >= 0 ; i--){
            for (int j = length2 - 1; j >= 0; j--){
                sum = (chars1[i] - '0') * (chars2[j] - '0') + resInts[i + j + 1];
                resInts[i + j + 1] = sum % 10;  // 当前位 仅保存 计算结果的 个位
                resInts[i + j] += sum/10;   // 进位值 += 就算值/10
                // （注意：此处的 进位值 的 ‘+=’ 操作是因为可能还有别的数组单元也会进到此位）
            }
        }
        // 将 int数组 转换为 字符串
        StringBuilder resStr = new StringBuilder();
        for (int i = 0; i < length1 + length2; i++) {
            if (i == 0 && resInts[i] == 0) {    // 首位 不一定 进位
                continue;
            }
            resStr.append(resInts[i]);
        }
        return resStr.toString();
    }
}
