package 数据结构与算法.约瑟夫问题.f1;

/**
 * ClassName Solution
 * Description ： 已知n个人（以编号1，2，3…n分别表示）围坐在一张圆桌周围。
 * 从编号为k的人开始报数，数到m的那个人出列；他的下一个人又从1开始报数，
 * 数到m的那个人又出列；依此规律重复下去，直到圆桌周围的人全部出列。
 * Create by zhaokai108
 * Date 2020/12/2 21:22
 */
public class Solution {

    public static void main(String[] args) {
        //测试
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);//加入5个小孩
        circleSingleLinkedList.show();

        circleSingleLinkedList.countBoy(1,2,5);
    }

    /**
     * 创建环形单向链表
     */
    static class CircleSingleLinkedList{

        private Boy frist =null;

        //根据用户输入，计算出圈顺序

        /**
         *
         * @param StartNo  表示从第几个小孩开始数数
         * @param countNum  表示数几下
         * @param nums  表示小孩总数
         */
        public void countBoy(int StartNo,int countNum,int nums){
            //数据校验
                if(frist ==null || StartNo<1 || StartNo>nums){
                    System.out.println("数据输入有误，请重新输入");
                    return;
                }
                //创建一个辅助指针，帮助小孩出圈
                Boy helper = frist;
                while (true){
                    if(helper.getNext() == frist){//说明helper指向了最后一个节点
                        break;
                    }
                    helper = helper.getNext();
                }
                //先让first和helper移动到报数的那个小孩位置,移动k-1次
                for(int j=0;j<StartNo -1;j++){
                    frist = frist.getNext();
                    helper = helper.getNext();
                }
                //当小孩报数，first和helper移动m-1次，然后出圈
                while (true){
                    if(frist == helper){//说明圈中只有一个人
                        break;
                    }
                    for (int j=0;j<countNum-1;j++){
                        frist = frist.getNext();
                        helper = helper.getNext();
                    }
                    //此时first指向的小孩出圈
                    System.out.printf("小孩%d出圈\n",frist.getNo());
                    //出圈
                    frist = frist.getNext();
                    helper.setNext(frist);
                }
                System.out.printf("最后留在圈的小孩%d \n",frist.getNo());
        }


        //添加小孩节点创建单向环形链表
        public void addBoy(int nums){
            if (nums < 1){
                return;
            }

            Boy temp =null; //辅助指针帮助构成环形链表， 该指针作用，指向每次添加的节点
            for (int i =1 ;i <= nums;i++){
                Boy boy = new Boy(i); //根据编号创建小孩节点
                if (i==1 ){
                    frist = boy;
                    frist.setNext(frist);
                    temp = frist;
                }else {
                    temp.setNext(boy);  //
                    boy.setNext(frist); //添加的节点 指向头节点
                    temp =boy;
                }
            }
        }

        //遍历链表 ,frist ： 始终会指向头头节点
        public void show(){
           if (frist == null){
               return;
           }
           Boy curBoy = frist;
            while (true){
                System.out.println(curBoy.getNo());
                if (curBoy.next == frist){
                    break;
                }
                curBoy = curBoy.next;
            }
        }


    }

    //创建一个boy类，表示一个节点
    static  class Boy{

        private int no; //编号

        private Boy next; //指向下一个小孩

        public Boy(int no) {
            this.no = no;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public Boy getNext() {
            return next;
        }

        public void setNext(Boy next) {
            this.next = next;
        }
    }
}
