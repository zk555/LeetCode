package 数据结构与算法.树.二叉树;

/**
 * 分析：
 *      1， 创建要一个二叉树。
 *      2.前序遍历
 *           2.1 先输出当前节点，
 *           2.2 如果左子节点不为null ，递归遍历左子树
 *           2.3 如果右子节点不为空，递归遍历右子树
 *      3.前序遍历
 *          3.1 如果左子节点不为null ，递归遍历左子树
 *          3.2 输出当前节点，
 *          3.3 如果右子节点不为空，递归遍历右子树
 *      4. 后续遍历
 *          4.1 如果左子节点不为null ，递归遍历左子树
 *  *       4.2 如果右子节点不为空，递归遍历右子树
 *  *       4.3 输出当前节点，
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        //创建二叉树
        HeroNode root =new HeroNode(1,"宋江");
        HeroNode node1 =new HeroNode(2,"吴用");
        HeroNode node2 =new HeroNode(3,"卢俊义");
        HeroNode node3 =new HeroNode(4,"林冲");
        HeroNode node4 =new HeroNode(5,"关胜");

        root.setLeft(node1);
        root.setRight(node2);
        node2.setRight(node3);
        node2.setLeft(node4);


//        System.out.println("前序遍历");
        BinaryTree binaryTree =new BinaryTree();
        binaryTree.setRoot(root);
//        binaryTree.preOrder();
        System.out.println("中序遍历");
        binaryTree.infixOrder();
//
//        System.out.println("后序遍历");
//        binaryTree.postOrder();
    }
}


class BinaryTree {

    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }
    }

    //前序
    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }
    }

    //前序
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }
    }
}


//创建 节点
class HeroNode{

    private int no;

    private String name;

    private HeroNode left;  //左子

    private HeroNode right;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void preOrder(){
        System.out.println(this);  //父节点
        if (this.left != null){   //左子树
            this.left.preOrder();
        }

        if (this.right != null){  //右子树
            this.right.preOrder();
        }
    }

    public void infixOrder(){
        if (this.left != null){   //左子树
            this.left.infixOrder();
        }
        System.out.println(this);  //父节点

        if (this.right != null){   //右子树
            this.right.infixOrder();
        }
    }

    public void postOrder(){
        if (this.left != null){   //左子树
            this.left.postOrder();
        }
        if (this.right != null){   //右子树
            this.right.postOrder();
        }
        System.out.println(this);  //父节点
    }
}