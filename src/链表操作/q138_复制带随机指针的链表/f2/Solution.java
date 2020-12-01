package 链表操作.q138_复制带随机指针的链表.f2;

/**
 * 在每一个链表的节点后都新连一个节点之后操作 时间o(n) 额外空间o(1)
 */
public class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Node ptr = head;  //指针 ，head 和ptr 同时指向node头位置
        while (ptr != null) {
            Node newNode = new Node(ptr.val);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }

        ptr = head;

        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        Node ptrOldList = head;
        Node ptrNewList = head.next;
        Node headOld = head.next;
        while (ptrOldList != null) {
            ptrOldList.next = ptrOldList.next.next;
            ptrNewList.next = (ptrNewList.next != null) ? ptrNewList.next.next : null;
            ptrOldList = ptrOldList.next;
            ptrNewList = ptrNewList.next;
        }
        return headOld;
    }

    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(6);
        Node node3 = new Node(4);
        Node node4 = new Node(7);
        node1.random=node2;
        node1.next=node2;
        node2.next =node3;
        node2.random=node4;
        node3.next=node4;
        new Solution().copyRandomList(node1);
    }
}
