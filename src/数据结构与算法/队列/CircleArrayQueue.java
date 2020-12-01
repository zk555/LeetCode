package 数据结构与算法.队列;

import java.util.Scanner;

/**
 * 环形队列
 */
class CircleArrayQueue {
    private int maxSize; //数组的最大容量
    private int front; //front指向队列的第一个元素,初始值为0
    private int rear;  //rear指向队列的最后一个元素的后一个位置,因此希望空出一个空间作为约定,初始值为0
    private int[] arr; //该数组用于存放数据，模拟队列

    //创建队列的构造器
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
    }

    // 判断队列是否已满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满,不能加入数据了");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //将rear后移，这里需要取模
        rear = (rear + 1) % maxSize;
    }

    // 获取队列的数据，出队列
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            //跑出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        // 1. 先把front值保存到一个临时变量
        int value = arr[front];
        // 2. 将front后移，考虑取模
        front = (front + 1) % maxSize;
        // 3. 将临时保存的变量返回
        return value;
    }

    //显示队列的所有数据
    public void showQueue() {
        //为空判断
        if (isEmpty()) {
            System.out.println("队列空的，没有数据");
            return;
        }
        //遍历
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //显示队列的头数据，不取出数据
    public int headQueue() {
        //为空判断
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        return arr[front];
    }

    //求出当前队列有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(4);
        char key; // 用于接收用户输入
        int res; //用于取出队列中的数据
        Scanner sc = new Scanner(System.in);
        boolean loop = true;    //判断是否需要继续执行

        // 提示信息
        System.out.println("s(show): 显示队列");
        System.out.println("e(exit): 退出队列");
        System.out.println("a(add): 添加数据到队列");
        System.out.println("g(get): 从队列取出数据");
        System.out.println("h(head): 查看队列头的数据");

        while (loop) {
            key = sc.next().charAt(0); //接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数用于插入队列");
                    int varlue = sc.nextInt();
                    queue.addQueue(varlue);
                    break;
                case 'g':
                    try {
                        res = queue.getQueue();
                        System.out.printf("从队列取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    res = queue.headQueue();
                    System.out.printf("队列头的数据是%d\n", res);
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序运行结束");
    }
}