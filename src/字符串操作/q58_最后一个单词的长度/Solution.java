package 字符串操作.q58_最后一个单词的长度;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description: 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * @create 2021-05-24 20:45
 **/
public class Solution {
    // 右 --> 左遍历  第一个非空格开始,再遇到空格结束
    public int lengthOfLastWord(String s) {
        int length = s.length() -1;
        int count = 0;
        while (length >= 0) {
            if (s.charAt(length) == ' '){
                if (count == 0){
                    length -- ;
                    continue;
                }
                break;
            }
            count ++;
            length -- ;
        }
        return count;
    }
}
