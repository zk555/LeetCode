package 数据结构与算法.树.线索化二叉树;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建二叉树
        HeroNode root =new HeroNode(1,"宋江");
        HeroNode node1 =new HeroNode(2,"吴用");
        HeroNode node2 =new HeroNode(3,"卢俊义");
        HeroNode node3 =new HeroNode(4,"林冲");
        HeroNode node4 =new HeroNode(5,"关胜");
    }
}


class BinaryTree {

    private HeroNode root;

    private HeroNode pre = null;  //总是指向前驱节点

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //线索化二叉树 ,node 当前线索化节点
    public void threaddelNodes(HeroNode node){
        if (node == null){
            return;
        }
        // 1. 先线索化处理左子树
        threaddelNodes(node.getLeft());
        // 2. 线索化当前节点
        // 2.1 处理当前节点的左指针
        if (node.getLeft() == null){
            // 当前节点的做指针 指向 前驱节点
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //2.2 处理后继节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);  // 前驱节点的右指针 指向当前节点
            pre.setRighType(1);
        }
        // 每处理一个节点，让当前节点是下一个节点的前驱节点 ( 指针后移完成后，再计算前一个节点的后继节点)
        pre = node;
        // 3. 线索化右子节点
        threaddelNodes(node.getRight());
    }

    //遍历线索化二叉树
    public void threadedList(){
        HeroNode node = root; // 存储当前遍历的节点，root 开始
        while (node != null){

            // 找到线索化的第一个节点 leftType ==1
            while (node.getLeftType() == 0 ){
                node = node.getLeft();
            }

            //打印当前节点，
            System.out.println(node);
            //如果当前节点的右指针是后继节点直接输出
            while (node.getRighType() == 1){
                node =node.getRight();
                System.out.println(node.getRight());
            }
            //当 不是后序节点 ，是右子树
            node =node.getRight();
        }
    }

    //删除节点
    public void delNode(int no){
        if (root != null){
            if (root.getNo() == no){
                root =  null;
            }else {
                this.root.delNode(no);
            }
        }else {
            System.out.println("tree is null");
        }
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

class HeroNode{

    private int no;

    private String name;

    private HeroNode left;  //左子

    private HeroNode right;

    private int leftType;//0 左子树， 1 前序节点

    private int righType; //0 右子树， 1 后继节点

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRighType() {
        return righType;
    }

    public void setRighType(int righType) {
        this.righType = righType;
    }

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


    //删除节点
    public void delNode(int no){
        if (this.left != null && this.left.no ==no){
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no ==no){
            this.right = null;
            return;
        }
        if (this.left != null){
            this.left.delNode(no);
        }
        if (this.right != null){
            this.right.delNode(no);
        }
    }
}