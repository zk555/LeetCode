package 数字操作.q4.正序数组中位数;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description: 给出两个数组，合并后算出中位数
 * @create 2021-05-13 15:26
 **/
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m + n];
        if (m == 0) {
            if (n % 2 == 0) {
                //偶数
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                //奇数
                return nums2[n / 2];
            }
        }

        if (n == 0) {
            if (m % 2 == 0) {
                //偶数
                return (nums2[m / 2 - 1] + nums2[m / 2]) / 2.0;
            } else {
                //奇数
                return nums2[m / 2];
            }
        }

        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {
            if (Integer.valueOf(i) == Integer.valueOf(m)) {
                //num1 数组已经为空
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (Integer.valueOf(j) == Integer.valueOf(n)) {
                //num1 数组已经为空
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0) {
            //偶数
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            //奇数
            return nums[count / 2];
        }
    }
    /*合并成一个数组，再求中位数*/

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1,2,3},new int[]{4,5,6}));
    }
}