package 字符串操作.q14_最长公共前缀;


/**
 * 水平扫描 o(n)
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String pre = "";
        int i = 0;
        while (true) {
            if (strs[0].length() == i) {
                return pre;
            }
            char temp = strs[0].charAt(i);
            for (int k = 1; k < strs.length; k++) {
                // 返回条件，字符串前缀不等 || 找到最短字符串
                if (strs[k].length() == i || temp != strs[k].charAt(i)) {
                    return pre;
                }
            }
            pre += temp;
            i++;
        }
    }

    public static void main(String[] args) {
        String[] s = new String[]{"c", "c"};
        System.out.println(new Solution().longestCommonPrefix(s));
    }
}
