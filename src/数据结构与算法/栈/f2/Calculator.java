package 数据结构与算法.栈.f2;

/**
 *
 * 1 场景：使用栈 完成计算器 编写
 *
 * 2. 思路： 2.1 通过一个索引 index,来遍历我们得表达式
 * 2.2 ，如果表示式 是数字 ，放入stack1
 *      如果stack2是空。直接入栈，
 *      如果不为空，是判断当前符号和符号栈内符号优先级，
 *          如果当前符号优先级小于栈中符号，就数字栈中pop出两个数，
 *              在符号栈pop出一个符号进行运算。得到结果入数字栈，然后将当前符号入符号栈
 *          如果当前符号优先级大于栈中符号 ，直接入符号栈，
 * 3. 当表达式扫描完成后，顺序得从数栈和符号栈中pop出相应得数和符号，并运算
 * 4.最后 数栈中只有一数表示 结果
 *
 */
public class Calculator {

    public static void main(String[] args) {
        String expression = "3+2*6-2";
        ArrayStack numStack = new ArrayStack(5);
        ArrayStack operStack = new ArrayStack(5);

    }

    private String  p1 = "*/";
    private String  p2 = "+-";

    /**
     * 计算方法
     */
    public int cal(int num1 ,int num2){
        return 1;
    }

    /**
     * 是否为运算符
     */
    public boolean isOper(String oper){
        return p1.contains(oper) ||p2.contains(oper);
    }

    /**
     * 判断优先级
     */
    public  int priority(String oper){

        if (p1.contains(oper)){
            return 1;
        }else  if (p2.contains(oper)){
            return 0;
        }
        return 0;
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
}
