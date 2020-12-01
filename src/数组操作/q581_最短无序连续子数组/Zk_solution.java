package 数组操作.q581_最短无序连续子数组;

/**
 * [2, 6, 4, 8, 10, 9, 15]
 *
 * 升序的最小数组 ：[6, 4, 8, 10, 9]
 */
public class Zk_solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int max = nums[0];   //记录遍历过程中的最大值
        int min = nums[len-1];
        int l = 0, r = -1;
        for(int i=0;i<len;i++){
            // 找到 需要改变顺序右边界 R的位置
            if(max>nums[i]){
                r = i;
            }else{
                max = nums[i];
            }
            // 找到 需要改变顺序左边界 L的位置
            if(min<nums[len-i-1]){
                l = len-i-1;
            }else{
                min = nums[len-i-1];
            }
        }
        return r-l+1;
    }
    public static void main(String[] args) {
        int[] temp ;
        temp= new int[]{2, 6, 4, 8, 10, 9, 15};
        int i = new Zk_solution().findUnsortedSubarray(temp);
        System.out.println("curmax = " + i);
    }
}
