package 数组操作.q384_打乱数组;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Zk_solution {

    private int[] array;
    private int[] original;

    private Random rand = new Random();

    public Zk_solution(int[] nums) {
        array = nums;
        original =nums;
    }

    public int[] reset() {
        return original;

    }

    //每次在K 长度的数组随机拿出一个数据，
    public int[] shuffle() {
        List<Integer> aux =  getArrayCopy();

        //重新赋值数组 array[]
        for (int i = 0; i < array.length; i++) {
            int removeIdx = rand.nextInt(aux.size());
            array[i] = aux.get(removeIdx);
            aux.remove(removeIdx);
        }

        return array;
    }
    private List<Integer> getArrayCopy() {
        List<Integer> asList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            asList.add(array[i]);
        }
        return asList;
    }
}
