package 数据结构与算法.栈.f2;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *  前缀表达式：
 *  例如：（6+1）*4 -2
 *   前缀表达式在计算机中得运算，
 *      1.
 *
 *
 *      后缀表示式：（3+4）*5-6  ，计算机步骤如下：
 *      1.从左到右扫描，将3和4压入栈中，
 *      2.  + ，弹出栈顶和次顶元素，进行运算
 *      3. 将5压入栈
 *      4，接下来是*运算符，弹出栈顶和次栈 5 * 7
 *      5. 将6和压入栈中，
 *      6.最后弹出6 和 35 ， 35 -6 =？
 */
public class PrefixCalculator {

    /**
     *  先定义逆波兰表达式，（后缀表示式）
     *  1. （3+4）*5-6  ————》 3 4 + 5 *6-
     *  2 . 先将元素存入ArrayList 中
     *  3. 遍历集合，配合栈完成计算
     */

    public static void main(String[] args) {
        String suffixEx = "3 4 + 5 * 6 - ";
    }

    // 元素 转化到集合中
    public static List<String> getListString(String ex){
        return Arrays.asList(ex.split(""));
    }


    public static int calculate(List<String> ls){
        //创建一个栈
        Stack<String> stack = new Stack<>();
        for (String s : ls) {
            // 使用正则表达式 取出数字
            if (s.matches("\\d+")){
                stack.push(s);
            }else {
                // pop出两个数字运算后再入栈
                int num2 = Integer.valueOf(stack.pop());
                int num1 = Integer.valueOf(stack.pop());

                //判断符号 进行运算，最后把结果压入栈中
                //除法和 减法   num2 /num1
                stack.push(String.valueOf(num1+num2));
            }
        }
        return Integer.valueOf(stack.pop());
    }

}
