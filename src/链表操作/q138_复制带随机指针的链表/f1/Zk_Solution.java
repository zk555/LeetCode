package 链表操作.q138_复制带随机指针的链表.f1;

import java.util.HashMap;

/**
 *  map ,hash存储
 */
public class Zk_Solution {
    //  key 存储 node 每个节点， value 存储 新建节点（没有 next 和random）
    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if(head == null) return  null;

        Node p = head;
        //初始化 Map
        while (p != null){
            visitedHash.put(p,new Node(p.val));
            p= p.next;
        }
        p = head;
        //给每个map 的value 的 next 和 random 赋值
        while (p !=null){
            visitedHash.get(p).next = visitedHash.get(p.next);
            visitedHash.get(p).random = visitedHash.get(p.random);
            p = p.next;
        }
        return visitedHash.get(head);
    }
}
