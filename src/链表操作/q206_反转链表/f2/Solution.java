package 链表操作.q206_反转链表.f2;

/**
 * 遍历直接反向修改next指针 o(n)
 * <p>
 * 两个相邻指针一直向后移动，直到前面指针为空结束
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode temp = head;  //1->2->3->4->null  ,4->3->2->1->null
        while (temp != null) { //1
            ListNode t = temp.next; //2
            temp.next = pre; //1->null
            pre = temp; //pre =1
            temp = t;
        }
        return pre;
    }
}
