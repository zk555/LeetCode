package 数据结构与算法.图;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    private ArrayList<String> vertextList; //存储顶点集合
    private int[][] edges ; //存储图对应的邻接矩阵
    private int numOfEdges; //表示边的数目
    //记录某个节点是否被访问过
    private boolean[] isVisited ;

    public static void main(String[] args) {
        int n = 5; //节点的个数
        String verTextValue [] = {"A","B","C","D","E"};

        Graph graph =new Graph(n);
        for (String value :verTextValue){
            graph.insertVerText(value);
        }

        //添加边
        // A-b, A-c,b-c,b-d,b-e
        graph.insertEdges(0,1,1);
        graph.insertEdges(0,2,1);
        graph.insertEdges(1,2,1);
        graph.insertEdges(1,3,1);
        graph.insertEdges(1,4,1);

        graph.showGrahp();

        //dfs
        System.out.println("深度遍历");
//        graph.dfs();
        System.out.println("广度遍历");
        graph.bfs();
    }

    //初始化矩阵和vertextList
    public Graph(int n) {
        edges = new int[n][n];
        vertextList = new ArrayList<>(n);
        isVisited = new boolean[5];
        numOfEdges = 0 ;
    }



    /**
     * //得到第一个邻接节点的下标
     * @param index
     * @return
     */
    public int getFristNeighBorIndex(int index){//  横坐标=0，纵坐标依次往后查找
        for (int j =0 ;j < vertextList.size();j++){
            if (edges[index][j] >0){
               return j;
            }
        }
        return -1;
    }

    /**
     *  根据前一个邻接节点的下标获取下一个邻接节点
     * @param v1,v2  ， v1= 0 ,v2= 1
     * @return
     */
    public int getNextNeighBorIndex(int v1,int v2){
        for (int j =v2+1;j<vertextList.size();j++){ // 结合二维数组查看坐标来理解
            if (edges[v1][j] >0){
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历算法, i表示第一个元素
    public void dfs(boolean[] isVisited,int i){
        System.out.println(getValueByIndex(i) + "-->");
        isVisited[i] =true;
        //查找节点i 的第一个邻接节点
        int w = getFristNeighBorIndex(i);
        while (w != -1){
            if (!isVisited[w]){ // 如果节点存在，并且没有被访问过
                dfs(isVisited,w);
            }
            //如果节点已经被访问过
            w = getNextNeighBorIndex(i,w);
        }
    }

    //重载dfs,遍历所有的节点，进行dfs
    public void dfs(){
        //遍历所有节点进行dfs,[回溯]
        for (int i =0; i<getNumofVertex();i++){
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }


    //对一个节点进行广度优先遍历
    public void bfs(boolean[] isVisited,int i){
        int u ; //表示队列的头节点对应的下标
        int w ; //表示邻接节点的下标
        //队列存放节点按顺序遍历
        LinkedList<Object> queue = new LinkedList<>();
        //输出节点
        System.out.println(getValueByIndex(i) + "-->");
        isVisited[i] =true; //标记为已经访问
        //将节点加入队列
        queue.addLast(i);

        while (!queue.isEmpty()){
            u = (int) queue.removeFirst(); //取出队头下标
            w = getFristNeighBorIndex(u);  //得到第一个邻接节点下标
            while (w!= -1) {
                //找到 相邻下标
                if(!isVisited[w]){
                    System.out.println(getValueByIndex(w)+ "==>");
                    //标记已经访问过
                    isVisited[w] =true;
                    //入队
                    queue.addLast(w);
                }
                // 如果访问过，以u为前驱，找到w的邻接节点
                w = getNextNeighBorIndex(u,w);   //提现出我们的广度优先，（将队列头节点依次全部遍历）
            }
        }
    }

    //遍历所有节点，进行广度优先搜索
    public void bfs(){
        for (int i=0;i <getNumofVertex();i++){
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    //返回节点的个数
    public int getNumofVertex(){
        return vertextList.size();
    }

    //返回边的个数
    public int getNumOfEdges(){
        return numOfEdges;
    }

    //返回v1和v2对应的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    //显示图对应的矩阵
    public void showGrahp(){
        for (int[] link :edges){
            System.out.println(Arrays.toString(link));
        }
    }

    //返回节点i(下标对应的数据)，0 -->A ,1-->B
    public String getValueByIndex(int i){
        return vertextList.get(i);
    }

    //插入顶点
    public void insertVerText(String vertex){
        vertextList.add(vertex);
    }

    /**添加边
     *
     * @param v1  表示点的下标即第几个顶点,"A--B": A=0,B=1
     * @param v2  表示第二个顶点对应的下标即第几个顶点,"A--B": A=0,B=1
     * @param weight  ，表示关联
     */
    public void insertEdges(int v1,int v2 ,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;  //无向图
        numOfEdges ++;
    }
}
