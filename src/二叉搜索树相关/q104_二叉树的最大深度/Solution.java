package 二叉搜索树相关.q104_二叉树的最大深度;

/**
 * @Description: 给定一个二叉树，找出其最大深度。  二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * @Author zhaokai108
 * @Date 2021/6/28 16:13
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class Solution {

    //深度优先搜索
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            // 优先遍历左子树 ，再遍历右子树 分别计算其深度
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
