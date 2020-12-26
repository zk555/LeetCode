package 数据结构与算法.树.二叉排序树;

public class BinarySortTreeDemo {

    public static void main(String[] args) {

        int[] arr = {7,3,10,12,5,1,9,2};

        BinarySortTree tree = new BinarySortTree();
        for (int i =0 ;i< arr.length;i++){
            tree.add(new Node(arr[i]));
        }
        tree.preOrder();
        tree.delete(2);
        System.out.println("删除节点：");
        tree.preOrder();
    }


}


class BinarySortTree{
    private Node root;

    //查找当前节点
    public Node search(int value){
        if (root == null){
            return null;
        }else {
            return root.search(value);
        }
    }

    //查找当前节点的父节点
    public Node searchParent(int value){
        if (root == null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }

    public void add(Node node){
        if (root ==null){
            root = node;
        }else {
            root.add(node);
        }
    }

    /**找到当前节点右子树的最小值，将该节点删除，并且把值赋值给要删除的节点
     *
     * @param node  传入的节点，当做二叉排序树的根节点
     * @return 返回以node 为根节点的二叉排序树的最小节点值
     */
    public int delRightTreeMin(Node node){
        Node target = node;
        // 找到当前节点右子树的最小值，将该节点删除，并且把值赋值给要删除的节点
        while (target.left != null) {
            target =target.left;
        }
        //删除最小节点值
        delete(target.val);
        return target.val;
    }

    //删除节点
    public void delete(int val){
        if (root ==null){
            return;
        }else {
            //先查到要删除的节点
            Node node = search(val);
            if (node == null){
                return;
            }
            //如果当前二叉树只有一个节点
            if (root.left ==null && root.right ==null){
                root = null;
                return;
            }
            //查 要删除的节点的父节点
            Node parentNode = searchParent(val);
            //1. 如果要删除的节点是叶子节点
            if (node.left ==null && node.right ==null){
                //要删除的节点是叶子节点，现在要判断要删除节点的父节点的左子节点还是右子节点
                if (parentNode.left != null && parentNode.left.val ==val ){
                    parentNode.left = null;
                }else if (parentNode.right != null && parentNode.right.val ==val){
                    parentNode.right = null;
                }
            }else if (node.left !=null && node.right !=null){ // 当前要删除的节点包含左子树和右子树
                int min = delRightTreeMin(node.right);
                node.val = min;
            }else {
                //如果要删除的节点，有左子节点
                if (node.left != null){
                    if (parentNode !=null){
                        // 如果要删除的节点是parent的左子节点
                        if (parentNode.left.val ==val){
                            parentNode.left = node.left;
                        }else {
                            //当前为右子节点
                            parentNode.right = node.left;
                        }
                    }else {
                        root = node.left;
                    }

                }else {
                    if (parentNode !=null) {
                        // 如果要删除的节点是parent的左子节点
                        if (parentNode.left.val == val) {
                            parentNode.left = node.right;
                        } else {
                            //当前为右子节点
                            parentNode.right = node.right;
                        }
                    }else {
                        root = node.right;
                    }
                }
            }
        }
    }

    public void preOrder(){
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("is null");
        }
    }
}

class Node{
    int val;
    Node left;
    Node  right;

    public Node(int val) {
        this.val = val;
    }
    /**
     * 删除节点
     * @param value
     */
    public Node delete(int value){
        return null;
    }
    /**
     *  查找要删除的节点
     * @param value
     * @return
     */
    public Node search(int value){
        if (value == this.val){
            return this;
        }else if (value < this.val){ //递归查找左子树
            if (this.left == null){
                return null;
            }
            return this.left.search(value);
        }else { //递归查找右子树
            if (this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }
    /**
     *  查找要删除节点的父节点
     * @param value
     * @return
     */
    public Node searchParent(int value){
       if ((this.left!=null && this.left.val ==value)
               || (this.right!=null && this.right.val ==value)){ // 当前节点是父节点
           return this;
       }else {
           //如果查找的值小于当前节点的值，并且当前节点的左子节点不为null
           if (value < this.val && this.left != null){
               return this.left.searchParent(value);  //左子树递归查找
           }else if (value >= this.val && this.right != null){
               return this.right.searchParent(value);
           }else {
               return null;
           }
       }
    }
    //按照二叉排序树方式添加
    public void add(Node node){
        if (node == null){
            return;
        }
        if (node.val < this.val){  //当前节点和根节点的关系
            if (this.left ==null){
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else {
            if (this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }
    public void preOrder(){
        if (this.left != null){
            this.left.preOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.preOrder();
        }
    }
    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}