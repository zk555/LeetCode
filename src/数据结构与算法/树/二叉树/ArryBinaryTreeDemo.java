package 数据结构与算法.树.二叉树;


/**
 *   使用数组存储二叉树
 */
public class ArryBinaryTreeDemo {

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7};
    }
}

//编写一个ArryBinnaryTree,实现顺序存储二叉树

class ArrBinaryTree{

    private int[] arr ;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }



    public void preOrder(int index){
        if (arr == null ||arr.length ==0){
            System.out.printf("arr is null");
            return;
        }
        System.out.println(arr[index]);

        if ((2*index+1) < arr.length){
            preOrder(2*index +1);
        }

        if ((2*index+2) < arr.length){
            preOrder(2*index +2);
        }
    }
}
