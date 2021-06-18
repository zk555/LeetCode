package 字符串操作.滑动窗口.q3_最长子串的长度;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaokai108
 * @version 0.0.1  "pwwkew"
 * @description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @create 2021-05-11 20:34
 *
 * 思路：构建队列，遇到相同的字符删除对头部，同时更新left 下标
 **/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> charsMap = new HashMap<>();
        int max = 0;  // 最大步长
        int left = 0;  // 左边界值
        for (int i = 0; i < s.length(); i++) {
            if (charsMap.containsKey(s.charAt(i))) {
                //确定左边界值
                left = Math.max(left, charsMap.get(s.charAt(i))+ 1);
            }
            charsMap.put(s.charAt(i), i); //a,b,c   || a  = 0  b = 1 c = 2  || a
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}

