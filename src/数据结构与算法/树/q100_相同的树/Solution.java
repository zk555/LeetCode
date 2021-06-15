package 数据结构与算法.树.q100_相同的树;

/**
 * @Description: 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * @Author zhaokai108
 * @Date 2021/6/15 16:59
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        while (true) {
            if (p == null && q != null) {
                return false;
            }
            if (p != null && q == null) {
                return false;
            }
            if (p != null && q != null) {
                if (p.val == q.val) {
                    p = p.next;
                    q = q.next;
                } else {
                    return false;
                }
            }
            if (p == null && q == null) {
                return true;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(3);
        p.next = p1;
        p1.next = p2;

        TreeNode q = new TreeNode(1);
        TreeNode q1 = new TreeNode(1);
        TreeNode q2 = new TreeNode(3);
        q.next = q1;
        q1.next = q2;

        Solution s = new Solution();
        boolean sameTree = s.isSameTree(p, q);
        System.out.println(sameTree);

    }
}
