package 数据结构与算法.树.q101_对称二叉树;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/6/15 17:24
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if(root==null) {
            return true;
        }
        //调用递归函数，比较左节点，右节点
        return dfs(root.left,root.right);

    }
    //终止条件：
    // left 和 right 不等，或者 left 和 right 都为空
    //递归的比较 left，left 和 right.right，递归比较 left，right 和 right.left

    // 左节点 、右节点
    boolean dfs(TreeNode left, TreeNode right) {
        //递归的终止条件是两个节点都为空
        //或者两个节点中有一个为空
        //或者两个节点的值不相等
        if(left==null && right==null) {
            return true;
        }
        if(left==null || right==null) {
            return false;
        }
        if(left.val!=right.val) {
            return false;
        }
        //再递归的比较 左节点的左孩子 和 右节点的右孩子
        //以及比较  左节点的右孩子 和 右节点的左孩子
        return dfs(left.left,right.right) && dfs(left.right,right.left);
    }

}
