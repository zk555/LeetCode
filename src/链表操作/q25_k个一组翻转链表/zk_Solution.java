package 链表操作.q25_k个一组翻转链表;

/**
 * 1. 思路： 正整数 K，把一个链表划分成多个子链表，最后
 *           把子链表连接到一起
 */
public class zk_Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head ==null || head.next ==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        while (pointer != null) {
            // 记录上一个子链表的尾
            ListNode lastGroup = pointer;
            int i = 0;
            for (;i < k;++i){
                pointer = pointer.next;
                if (pointer == null){ //如果到达链表的尾部 直接跳出循环
                    break;
                }
            }

            //反转子链表 (如果当前 i=k) 说明 子链表的长度 =K
            if (i == k){
                ListNode nextGroup = pointer.next; // 记录下一个子链表的头
                // 反转当前子链表，reverse 函数返回反转后子链表的头
                ListNode reversedList = reverse(lastGroup.next, nextGroup);
                // lastGroup 是上一个子链表的尾，其 next 指向当前反转子链表的头
                // 但是因为当前链表已经被反转，所以它指向的是反转后的链表的尾
                pointer = lastGroup.next;

                // 将上一个链表的尾连向反转后链表的头
                lastGroup.next = reversedList;

                // 当前反转后的链表的尾连向下一个子链表的头
                pointer.next = nextGroup;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null, temp = null;
        // 第一次循环  头节点 与下一个节点换位置
        // prev = 头节点   temp = 头节点的下一个节点
        while ((head != null) && (head != tail)) {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(7);
        node2.next = node3;
        node1.next = node2;
        node3.next = node4;
        new zk_Solution().reverseKGroup(node1,3);
    }
}
