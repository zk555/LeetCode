package 链表操作.q138_复制带随机指针的链表.f1;

import 链表操作.q25_k个一组翻转链表.ListNode;
import 链表操作.q25_k个一组翻转链表.zk_Solution;

import java.util.HashMap;

/**
 * 用Map存储遍历过的节点，时间o(n)，额外空间o(n)
 */
public class Solution {

    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

        public Node copyRandomList(Node head) {

            if (head == null) {
                return null;
            }
            if (this.visitedHash.containsKey(head)) {
                return this.visitedHash.get(head);
            }

            Node node = new Node(head.val);

            this.visitedHash.put(head, node);
            node.next = this.copyRandomList(head.next);
            node.random = this.copyRandomList(head.random);

            return node;
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