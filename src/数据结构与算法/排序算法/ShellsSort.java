package 数据结构与算法.排序算法;

/**
 * 优化插入排序
 *    插入排序后的高效版本，缩小增量排序
 * 希尔排序的思想：
 *      希尔排序是把记录按下标的一定增量分组，对每组使用直接插入算法排序，
 *      随着增量的减少，每组包含的关键词越来越多，当增量为1时，分成1组 排序即可
 */
public class ShellsSort {

    public static void main(String[] args) {
        int[] nums = {8,9,1,7,6,3,2,10};
        sort1(nums);
//        for (int i = 0;i<nums.length;i++){
//            System.out.print(nums[i] + ",");
//        }
//        System.out.println();

    }

    // shells 交换排序
    public static void sort1(int[] nums){
        //希尔排序，第一轮，将10个数据分成5组，
        int num = 0;
        for (int gap =nums.length/2; gap>0; gap/=2) { //根据分析 每次按下标的一定增量分组
            for (int i = gap ; i < nums.length; i++) {  //每次处理1组组？
                for (int j = i - gap; j >= 0; j -= gap) {// 1,2,3,4   ,2>0 , i=2 ,i<4  / j=0  0 -2 = -2
                    if (nums[i] < nums[j]) {
                        num = nums[j];
                        nums[j] = nums[i];
                        nums[i] = num;
                    }
                }
            }
            for (int i = 0;i<nums.length;i++){
                System.out.print(nums[i] + ",");
            }
            System.out.println();
        }

    }

    // shells 移位排序
    public static void sort2(int[] nums){
        //希尔排序，第一轮，将10个数据分成5组，

        for (int gap =nums.length/2; gap>0; gap/=2) { //根据分析 每次按下标的一定增量分组
            for (int i = gap ; i < nums.length; i++) {  //每次处理1组组？
                int j = i;
                int temp =nums[j];
                if (nums[j] < nums[j-gap]){
                    while (j-gap >= 0&&temp<nums[j-gap]){
                        nums[j] = nums[j-gap];
                        j-=gap;
                    }
                    nums[j] = temp;
                }
            }
            for (int i = 0;i<nums.length;i++){
                System.out.print(nums[i] + ",");
            }
            System.out.println();
        }

    }
}
