package 二叉搜索树相关.q94_中序遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/6/8 20:28
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class Solution {
    List<Integer> list = null;
    public List<Integer> inorderTraversal(TreeNode root) {

        if (list == null) {
            list = new ArrayList<>();
        }
        if (root == null) {
            return null;
        }
        inorderTraversal(root.left);
//        System.out.println(root.val);
        list.add(root.val);
        inorderTraversal(root.right);

        return list;
    }
}
