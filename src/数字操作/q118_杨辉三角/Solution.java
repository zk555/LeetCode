package 数字操作.q118_杨辉三角;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * @Author zhaokai108
 * @Date 2021/7/6 21:08
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows == 0) {
            return new ArrayList<>();
        }
        List<Integer> inlist = new ArrayList<>();
        inlist.add(1);
        lists.add(inlist);
        // 列数
        for (int i = 2; i <=numRows; i++) {
            List<Integer> rows = lists.get(i - 2);
            List<Integer> newlist = new ArrayList<>();
            newlist.add(1); //左点
            for (int j = 0; j < rows.size() - 1; j++) {
                newlist.add(rows.get(j) + rows.get(j + 1)); // 上层相加
            }
            newlist.add(1); //右点
            lists.add(newlist);
        }
        return lists;
    }
}
