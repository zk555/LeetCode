package 数据结构与算法.链表;

/**
 * head 头节点的作用， 单链表的头
 */
public class HeroNode {

    int no ;

    String name ;

    String nickName;

    HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
