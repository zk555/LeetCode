package 树的遍历.q110_平衡二叉树.f1;

/**
 * 从顶至底遍历 o(n^2)
 *
 * 平衡二叉树：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
 */
public class Solution {

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int lh = getHeight(root.left);
            int rh = getHeight(root.right);
            return Math.max(lh, rh) + 1;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        //判断左节点和右节点的高度差
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        } else {
            //分别判断左子树和右子树是否都是平衡二叉树
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;
        System.out.println(new Solution().isBalanced(root));
    }
}
