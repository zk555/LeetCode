package 数据结构与算法.栈.f1;

/**
 *   栈。 特点： 先进后出 ，
 *   数组模拟栈： 1 定义一个top表示栈顶，初始值 -1
 *   2.入栈操作， top++ ，stack[top] =data ,
 *   3.出栈 ： temp =stack[top] ,top-- ,return temp
 *   应用场景：
 *
 */
public class Stack {

    public static void main(String[] args) {
        //测试
        ArrayStack arrayStack =new ArrayStack(4);

        arrayStack.push(1);
        arrayStack.push(2);

//        int pop = arrayStack.pop();

//        System.out.printf(""+pop);

        arrayStack.list();
    }

    static class  ArrayStack{

        private int maxSize; //栈最大值  栈满： ,maxSize - 1 == top;

        private int[] stack;  //数组 模拟栈

        private int top = -1;  //初始化栈顶值

        public ArrayStack(int maxSize) {
            this.maxSize = maxSize;
            this.stack = new int[5];
        }

        public boolean isFull(){
            return  top == maxSize -1 ;
        }

        public boolean isEmpty(){
            return top == -1 ;
        }


        //入栈
        public void  push(int value){
            if (isFull()){
                return;
            }
            top ++;
            stack[top] = value;
        }


        //出栈
        public  int pop(){
            if (isEmpty()){
                throw new RuntimeException("is null");
            }
            int temp = stack[top];
            top -- ;
            return temp;

        }

        //遍历
        public void  list(){
            if (isEmpty()){
                throw new RuntimeException("is null");
            }
            int num = top ;
            for (int i =0 ;i <= num  ; i++){
                System.out.println("stack = " + stack[top]);
                top --;
                if (top ==-1 ){
                    break;
                }
            }
        }
    }

    /**
     *
     */
    static class LinkedStack{

    }
}
