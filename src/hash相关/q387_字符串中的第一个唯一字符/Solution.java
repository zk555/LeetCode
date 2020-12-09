package hash相关.q387_字符串中的第一个唯一字符;

import java.util.HashMap;

/**
 * Hash o(n)
 */
public class Solution {

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            Integer orDefault = count.getOrDefault(c, 0);
            System.out.println(orDefault);
            count.put(c, count.getOrDefault(c, 0) + 1); //有key 就直接取出key ,没key使用默认值
        }

        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "aa";
        Solution solution  = new Solution();
        int i = solution.firstUniqChar(s);
    }
}
