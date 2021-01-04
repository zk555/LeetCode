package 数据结构与算法.算法.暴力匹配算法;

/**
 *  KMP 算法，解决字符串在文本串中是否出现过，如果出现过返回最早出现的位置
 */
public class ViolenceMath {

    public static void main(String[] args) {

    }

    public static int violenceMatch(String str1,String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;

        int i = 0;  //
        int j = 0;
        while (i < s1Len && j < s2Len) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
            if (j == s2Len) {
                return i - j;
            } else {
                return -1;
            }
        }
        return -1;
    }
}
