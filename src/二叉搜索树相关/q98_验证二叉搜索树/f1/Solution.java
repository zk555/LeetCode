package 二叉搜索树相关.q98_验证二叉搜索树.f1;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归的中序遍历（二叉搜索树的中序遍历是有序的）o(n)
 * 二叉搜索树 ： 特点 ，左子树的值小于跟节点  右子树的值都大于根节点
 *
 */
public class Solution {

    List<Integer> rs = new ArrayList<>();

    /**
     * 二叉树 初始化到list 集合 ，再去比较 list 集合 index(0) ,index(1)的大小
     *
     * @param root
     * @return
     */
    private List<Integer> ldr(TreeNode root) {
        if (root == null) {
            return rs;
        }
        ldr(root.left);
        rs.add(root.val);
        ldr(root.right);
        return rs;
    }

    public boolean isValidBST(TreeNode root) {
        ldr(root);
        if (rs.size() < 2) {
            return true;
        }
        int a = rs.get(0);
        for (int i = 1; i < rs.size(); i++) {
            if (rs.get(i) <= a) {
                return false;
            }
            a = rs.get(i);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(7);
        root.left = n1;
        root.right = n2;
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(8);
        n2.left = n3;
        n2.right = n4;
        System.out.println(new Solution().isValidBST(root));
    }
}
