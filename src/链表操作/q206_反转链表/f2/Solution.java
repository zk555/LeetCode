package 链表操作.q206_反转链表.f2;

/**
 * 遍历直接反向修改next指针 o(n)
 *
 * 两个相邻指针一直向后移动，直到前面指针为空结束

 *
 *
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre  = null;

        ListNode temp = head;

        while (temp != null) {
            ListNode t = temp.next;
            temp.next = pre;
            pre = temp;
            temp = t;
        }
        return pre;
    }
}
