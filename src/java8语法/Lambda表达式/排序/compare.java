package java8语法.Lambda表达式.排序;

import java8语法.entry.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhaokai108
 * @version 0.1.0
 * @description:
 * @create 2021-02-24 18:17
 * @since 0.1.0
 **/
public class compare {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(1,""));
        apples.add(new Apple(0,""));
        apples.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(apples.get(0));
    }
}
