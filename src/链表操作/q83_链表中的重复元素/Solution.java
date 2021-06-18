package 链表操作.q83_链表中的重复元素;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/6/3 20:21
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode temp = head;

        while (head != null && head.next !=null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            }else {
                head = head.next;
            }
        }
        return temp;
    }
}

//  1，1，1
/*
   存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。返回同样按升序排列的结果链表。
 * @date 2021/6/3 20:21
 */