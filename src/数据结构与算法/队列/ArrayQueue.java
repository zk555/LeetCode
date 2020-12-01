package 数据结构与算法.队列;

/**
 * 数组实现队列
 */
public class ArrayQueue {
    public static void main(String[] args) {
        Queue queue = new Queue(3);
        queue.addQueue(1);
        queue.addQueue(2);
        queue.addQueue(3);
    }
}

class Queue{

    private int maxSize;

    private int front;   //初始化  队列头前一个位置

    private int rear;   // 队尾

    private int[] arr ;

    public Queue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;  //初始化 头和尾都指向 头部位置
        rear = -1;
    }

    //判断队列是否已满

    public boolean isFull(){
        return rear == maxSize -1 ;
    }
    //队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n ){
        if (isFull()){
            System.out.println("队列已满");
            return;
        }
        rear ++ ;
        arr[rear] = n;
    }

    public int task(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }

        front++;
        return arr[front];
    }

    public void list(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        for (int i = 0 ; i <arr.length ;i ++){
            System.out.println(arr[i]);
        }
    }

    //出栈头
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front+1];
    }
}
