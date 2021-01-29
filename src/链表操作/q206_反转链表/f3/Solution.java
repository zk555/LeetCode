package 链表操作.q206_反转链表.f3;

/**
 * @author zhaokai108
 * @version 0.1.0
 * @description:
 * @create 2021-01-29 17:11
 * @since 0.1.0
 **/
public class Solution {


    public ListNode reverseList(ListNode node) {
        if (node.next != null) {
            reverseList(node.next);
        }
        System.out.println(node.val);
        return node;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = null;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Solution solution = new Solution();
        solution.reverseList(node1);
    }
}
