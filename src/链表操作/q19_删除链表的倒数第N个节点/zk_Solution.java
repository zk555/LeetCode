package 链表操作.q19_删除链表的倒数第N个节点;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class zk_Solution {

    /**
     * 删除后数第N个节点 ，也就是删除正数L-n + 1个节点
     * @param head  链表
     * @param n 要删除的节点号
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (head != null) {
            length ++;
            head = head.next;
        }
        length -= n;
        first = dummy;
        while (dummy !=null){
            length --;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    /**
     * 删除后数第N个节点 ，也就是删除正数L-n + 1个节点
     * @param head  链表
     * @param n 要删除的节点号
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0); //引入哑节点防止head被删除
        dummy.next = head;
        ListNode first = dummy;  //0 --> 1
        ListNode second = dummy; // 0 -- >1
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

}
