package 树的遍历.q111_二叉树的最小深度;

/**
 * @Description: 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * @Author zhaokai108
 * @Date 2021/6/30 17:44
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class Solution {

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if (root.left ==null && root.right == null){
            return 1;
        }
        int ans = Integer.MAX_VALUE;
        //找到左节点的最小值
        if(root.left != null) {
            ans = Math.min(minDepth(root.left), ans);
        }
        //比较左节点和右节点 取最小值
        if(root.right != null) {
            ans = Math.min(minDepth(root.right), ans);
        }
        return ans + 1;

    }

}


    /*
        终止条件、返回值和递归过程：
            当前节点 root 为空时，说明此处树的高度为 0，0 也是最小值
            当前节点 root 的左子树和右子树都为空时，说明此处树的高度为 1，1 也是最小值
            如果为其他情况，则说明当前节点有值，且需要分别计算其左右子树的最小深度，返回最小深度 +1，+1 表示当前节点存在有 1 个深度
         时间复杂度：O(n)O(n)，nn为树的节点数量
    */
