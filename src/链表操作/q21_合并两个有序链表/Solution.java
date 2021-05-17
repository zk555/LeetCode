package 链表操作.q21_合并两个有序链表;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @create 2021-05-17 16:25
 **/
public class Solution {

    // 递归 , 从最小值开始找，直到有一个链表为null
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    public static void main(String[] args) {
        //1 ，2

        //2 ，3

    }

}
