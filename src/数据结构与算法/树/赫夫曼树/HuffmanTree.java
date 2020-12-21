package 数据结构与算法.树.赫夫曼树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 问题：数组：[13,7,8,3,29,6,1] ,转换成赫夫曼树
 */
public class HuffmanTree {

    public static void main(String[] args) {

        int [] arr = {13,7,8,3,29,6,1};
        Node node = craeteHuffmanTree(arr);
        preOrder(node);
    }

    public static void preOrder(Node node){
        node.preOrder();
    }

    //创建赫夫曼树
    public static Node craeteHuffmanTree(int[] arr){
        //遍历数组

        //将arr 构建node ,可以排序

        //放入arrList
        List<Node> nodes = new ArrayList<>();
        for (int value:arr){
            nodes.add(new Node(value));
        }

        //循环处理list ,直到nodes ==1
        while (nodes.size() >1 ){
            //排序,小- 大
            Collections.sort(nodes);

            System.out.println(nodes);

            //取出根节点权值最小的节点
            Node leftNode =nodes.get(0);
            //取出第二位节点
            Node rightNode = nodes.get(1);
            //构建新的二叉树
            Node parent = new Node(leftNode.getValue() + rightNode.getValue());
            parent.left =leftNode;
            parent.right =rightNode;

            //在ArryList 中删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            // 加入新构建的二叉树
            nodes.add(parent);

            System.out.println("第一次处理后："+ nodes);
        }

        return nodes.get(0);
    }
}


//节点
class Node implements Comparable<Node>{

    private int value ;

    public Node left;

    public Node right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node(int value) {
        this.value = value;
    }

    public void preOrder(){
        System.out.println(this);
        if (this.left !=null){
            this.left.preOrder();
        }
        if (this.right !=null){
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value; //表示从小到大排序
    }
}