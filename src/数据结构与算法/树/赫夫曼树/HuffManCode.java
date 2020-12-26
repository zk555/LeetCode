package 数据结构与算法.树.赫夫曼树;

import java.util.*;

public class HuffManCode {

    public static void main(String[] args) {
        String arr = "i like like like java do you like a java";
        byte[] bytes = getHeffmanCodeBytes(arr.getBytes());
        System.out.println("哈夫曼编码zip："+ Arrays.toString(bytes));
        byte[] decode = decode(heffmanCodes, bytes);
        System.out.println("哈夫曼编码decode："+new String(decode));
    }


    private static byte[] getHeffmanCodeBytes(byte[] c) {
        System.out.println(c.length);
        List<NodeC> nodes = getNodes(c);
        NodeC nodeC = craeteHuffmanTree(nodes);
//        preOrder(nodeC);// 前序遍历
        getCodes(nodeC,"",sb);
        return zip(c, heffmanCodes);
    }


    /**
     *
     * @param heffmanCodes  赫夫曼编码表
     * @param bytes  压缩后的数据
     * @return
     */
    private static byte[] decode(Map<Byte,String> heffmanCodes,byte[] bytes ){
        //1. 先得到压缩后的数据的对应的二进制的字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0 ; i < bytes.length ;i ++){
            //判断是否为最后一个字节
            Boolean flag = (i == bytes.length -1 );
            stringBuilder.append(bytetoString(!flag,bytes[i]));
        }

        Map<String,Byte> map = new HashMap<>();
        for(Map.Entry<Byte,String> entry:heffmanCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }

        //创建集合
        List<Byte> list = new ArrayList();
        for (int i = 0; i<stringBuilder.length();){
            int count = 1;
            boolean flag =true;
            Byte b =null;
            while (flag){
                //递增取出key 1
                String key =stringBuilder.substring(i,i+count); // count 递增在0001011中找到匹配的 二进制
                b=map.get(key);
                if (b == null){
                    count ++;
                }else {
                    flag =false;
                }

            }
            list.add(b);
            i += count;
        }
        byte [] bytes1 = new byte[list.size()];
        for (int i =0 ;i < bytes1.length;i++){
            bytes1[i] = list.get(i);
        }
        return  bytes1;
    }


    /**
     * 完全数据的解压
     *
     * 1. 将 bytes[] 转换为二进制的字符串
     * 2. 将赫夫曼编码对应的二进制字符串转换成“i like ”
     */
    public static String bytetoString(boolean flag,byte b){
        int temp = b;  // 将byte 转换成temp

        //如果是正整数，需要补高位
        if (flag){
            temp|=256; //按位 与 256
        }

        //获得二进制补码
        String s = Integer.toBinaryString(temp);
        if (flag){
            return s.substring(s.length() - 8);
        }else {
            return s;
        }

    }

    // 将字符串对应的byte[] 数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码，压缩后的byte[]

    /**
     *
     * @param bytes 原始的字符串 byte
     * @param heffmanCodes 生成的赫夫曼编码map
     * @return bytes[8]
     */
    private static byte[] zip(byte[] bytes, Map<Byte,String> heffmanCodes){
        StringBuilder stringBuilder= new StringBuilder();
        for (Byte v:bytes){
            stringBuilder.append(heffmanCodes.get(v));
        }

        //将字符串 011100101110110 转换成byte[]
        // 统计返回byte[]的lenght ，取整数
        int len = (stringBuilder.length() + 7) /8 ;
        //创建存储压缩后的数组
        byte[] by = new byte[len];
        int index =0; //记录是第几个byte
        for (int i = 0 ; i<stringBuilder.length();i +=8){
            String strByt;
            if (i+8 > stringBuilder.length()){
                 strByt =stringBuilder.substring(i);

            }else {
                 strByt =stringBuilder.substring(i,i+8);

            }
            //将strByt 转换成为byte 存入by
            by[index] = (byte)Integer.parseInt(strByt,2); // 转换为2进制
            index ++;
        }
        return  by;
    }


    /**
     * 通过赫夫曼树生成赫夫曼编码表
     * 将赫夫曼编码表存放到Map中  ，key: a ,value:001
     * 遍历赫夫曼树，通过StringBuilder 拼接
     */
    static Map<Byte,String> heffmanCodes = new HashMap<>();
    static StringBuilder sb = new StringBuilder();


    //生成赫夫曼编码
    private static void getCodes(NodeC nodeC,String code,StringBuilder sb){
        StringBuilder stringBuilder = new StringBuilder(sb);
        // code加入到StringBuilder中
        stringBuilder.append(code);
        if (nodeC !=null){  // nodeC == null 不处理
            //判断当前节点是叶子节点还是非叶子节点
            if (nodeC.data == null){
                getCodes(nodeC.left,"0",stringBuilder); //左递归
                getCodes(nodeC.right,"1",stringBuilder); //右递归
            }else {
                heffmanCodes.put(nodeC.data,stringBuilder.toString());
            }
        }

    }


    private static List<NodeC> getNodes(byte[] c){
        ArrayList<NodeC> nodeCS = new ArrayList<>();
        Map<Byte,Integer> count= new HashMap<>();
        for (Byte b:c) {
            Integer val = count.get(b);
            if (val == null){
                count.put(b,1);
            }else {
                count.put(b,val+1);
            }
        }

        //构建键值对node
        for (Map.Entry<Byte,Integer> entry:count.entrySet()) {
            nodeCS.add(new NodeC(entry.getKey(),entry.getValue()));
        }
        return nodeCS;
    }

    //创建赫夫曼树
    public static NodeC craeteHuffmanTree(List<NodeC> nodes){
        //循环处理list ,直到nodes ==1
        while (nodes.size() >1 ){
            //排序,小- 大
            Collections.sort(nodes);
            //取出根节点权值最小的节点
            NodeC leftNode =nodes.get(0);
            //取出第二位节点
            NodeC rightNode = nodes.get(1);
            //构建新的二叉树
            NodeC parent = new NodeC(null,leftNode.werght + rightNode.werght);
            parent.left =leftNode;
            parent.right =rightNode;

            //在ArryList 中删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            // 加入新构建的二叉树
            nodes.add(parent);

        }
        return nodes.get(0);
    }

    public static void preOrder(NodeC nodeC){
        nodeC.preOrder();
    }

}

class NodeC implements Comparable<NodeC>{
    Byte data ; // 存放的数据本身
    int werght; //权值，字符出现的次数
    NodeC left;
    NodeC  right;


    public NodeC(Byte data, int werght) {
        this.data = data;
        this.werght = werght;
    }

    @Override
    public int compareTo(NodeC nodeC) {
        return this.werght - nodeC.werght;
    }

    @Override
    public String toString() {
        return "NodeC{" +
                "data=" + data +
                ", werght=" + werght +
                '}';
    }

    public  void  preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }
}
