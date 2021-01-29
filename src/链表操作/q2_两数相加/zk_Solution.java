package 链表操作.q2_两数相加;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 思路 node1 + node2 每个位数相加 最后转换成一个新链表
 */
public class zk_Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rs = new ListNode(l1.val + l2.val); //初始化第一位
        ListNode node1 = l1.next;
        ListNode node2 = l2.next;
        ListNode temp = rs;
        while (node1 != null || node2 != null) {
            int a = 0;
            int b = 0;
            if (node1 != null) {
                a = node1.val;
            }
            if (node2 != null) {
                b = node2.val;
            }
            temp.next = new ListNode(a + b); //如果链表不为空，则存入下一个节点
            temp = temp.next;
            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
        }
        temp = rs;
        //  11 , 1 ,2
        while (temp != null) {
            if (temp.val > 10) {
                temp.val = temp.val - 10;
                if (temp.next == null) {
                    temp.next = new ListNode(0);
                }
                temp.next.val = temp.next.val + 1;
            }
            temp = temp.next;
        }
        return rs;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(7);
        node2.next = node3;
        node1.next = node2;
        // 5 6 4 , 6 4
        ListNode listNode = new zk_Solution().addTwoNumbers(node1, node2);
        while (listNode != null) {
            System.out.println("listNode = " + listNode.val);
            listNode = listNode.next;
        }
    }
}
