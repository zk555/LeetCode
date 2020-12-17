package 数据结构与算法.哈希表;

public class HashTable {

    public static void main(String[] args) {
        //创建hash表
        HashTableEmp hashTableEmp = new HashTableEmp(7);

        hashTableEmp.add(new Emp(1,"100"));
        hashTableEmp.add(new Emp(2,"1001"));
        hashTableEmp.add(new Emp(3,"1002"));
        hashTableEmp.list();
        Emp emp = hashTableEmp.get(2);
        System.out.printf("emp: " + emp.name);
    }
}



//表示一个雇员
class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}


//创建EmpLinkedList，表示链表
class EmpLinkedList{

    private Emp head; //头指针


    //添加链表
    public void add(Emp e){
        if (head ==null){
            head =e;
            return;
        }
        Emp currentEmp =head;
        while (currentEmp.next != null){
            currentEmp =currentEmp.next;
        }
        currentEmp.next = e;

    }

    //遍历链表
    public void list(int num){
        if (head ==null){
            System.out.println(num + "条链表:" +" is null");
            return;
        }
        Emp currentEmp =head;
        while (currentEmp!=null){
            System.out.println(num + "条链表:" +currentEmp.id+"====>" + currentEmp.name);
            currentEmp = currentEmp.next;
        }
    }

    public Emp get(int id) {
        if (head ==null){
            System.out.println("条链表:" +" is null");
            return null;
        }
        Emp currentEmp =head;
        while (currentEmp!=null){
            if (currentEmp.id == id){
                return currentEmp;
            }
            currentEmp = currentEmp.next;
        }
        System.out.println("find  is null");
        return null;
    }
}

//创建hashtable。
class HashTableEmp{

    private EmpLinkedList[] empLinkedLists;

    private int size;

    public HashTableEmp(int size) {
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        for (int i =0; i < size ;i ++){
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    // 添加雇员
    public void add(Emp e){
        //根据员工ID， 判断该员工添加到哪条链表
        int empLinkedListNo = hash(e.id);
        empLinkedLists[empLinkedListNo].add(e);
    }

    // 遍历hash表
    public void list(){
       for (int i= 0 ; i <size ;i++){
           empLinkedLists[i].list(i);
       }
    }

    //编写散列函数，取模
    public int hash(int id){
        return id % size ;
    }

    //根据ID 查找雇员
    public Emp get(int id){
        return empLinkedLists[id % size].get(id) ;
    }
}