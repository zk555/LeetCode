package 数组操作.q88_合并两个有序数组;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/6/3 20:38
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int l1 = m - 1;
        int l2 = n - 1;
        // 集合总长度
        int l = m + n - 1;
        while (l1 >= 0 && l2 >= 0) {
            nums1[l--] = nums1[l1] > nums2[l2] ? nums1[l1--] : nums2[l2--];
        }

        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        System.arraycopy(nums2, 0, nums1, 0, l2 + 1);

    }
}

/*
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。

*/