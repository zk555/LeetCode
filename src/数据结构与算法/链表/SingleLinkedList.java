package 数据结构与算法.链表;

/**
 * 1 . 每个HeroNode对象代表一个节点
 */
public class SingleLinkedList {


    public static void main(String[] args) {
            HeroNode heroNode1 = new HeroNode(1,"松江","及时雨");
            HeroNode heroNode2 = new HeroNode(2,"松江1","及时雨1");
            HeroNode heroNode3 = new HeroNode(3,"松江2","及时雨2");
            HeroNode heroNode4 = new HeroNode(4,"松江3","及时雨3");
            LinkedList linkedList = new LinkedList();
            linkedList.addNode(heroNode1);
            linkedList.addNode(heroNode2);
            linkedList.addNode(heroNode3);
            linkedList.addNode(heroNode4);
            linkedList.list();
    }


}

class  LinkedList{

    private HeroNode headNode= new HeroNode(0,"","");

    public void addNode(HeroNode heroNode){
        HeroNode temp = headNode;
        while (temp.next != null){
            temp= temp.next;
        }
        temp.next = heroNode;
    }

    public void  list(){
        if (headNode.next == null){
            return;
        }

        HeroNode temp = headNode.next;

        while (temp.next !=null){
            System.out.println(temp.toString());
            temp =  temp.next;
        }

    }


}