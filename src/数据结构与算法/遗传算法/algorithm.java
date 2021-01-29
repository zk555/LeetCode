package 数据结构与算法.遗传算法;

import java.math.BigInteger;
import java.util.*;

/**
 * ClassName algorithm
 * Description
 * Create by zhaokai108
 * Date 2020/12/8 13:58
 *
 * 概念1 ： 基因和染色体，   数学建模：在遗传算法中，首先需要将解决问题映射成一个数学问题，
 *           一个问题的可行解被称作一条染色体，一个可行解一般由多个元素组成，那么每个元素称为染色体上的基因
 *           例如：3x+4y+5z<100   可行解有3个：[1,2,3]、[1,3,2]、[3,2,1]， 那么这些可行解在遗传算法中均被称为染色体。
 *           这些可行解一共有三个元素构成，那么在遗传算法中，每个元素就被称为组成染色体的一个基因。
 * 概念2 ：适应度函数：在遗传算法中，如何衡量染色体的优劣呢？这就是由适应度函数完成的。
 *                      遗传算法在运行的过程中会进行N次迭代，每次迭代都会生成若干条染色体。
 *                      适应度函数会给本次迭代中生成的所有染色体打个分，来评判这些染色体的适应度，
 *                      然后将适应度较低的染色体淘汰掉，只保留适应度较高的染色体，从而经过若干次迭代后染色体的质量将越来越优良
 *                      染色体i被选择的概率 = 染色体i的适应度 / 所有染色体的适应度之和
 *
 * 概念3：交叉：遗传算法每一次迭代都会生成N条染色体，在遗传算法中，这每一次迭代就被称为一次“进化”。
 *              每次进化新生成的染色体是如何来的？ 交叉
 *              交叉的过程需要从上一代的染色体中寻找两条染色体，一条是爸爸，一条是妈妈。然后将这两条染色体的某一个位置切断，并拼接在一起，从而生成一条新的染色体。
 *              如果确定爸爸和妈妈的基因：轮盘赌算法
 * 概念4：变异:  交叉能保证每次进化留下优良的基因，但它仅仅是对原有的结果集进行选择，基因还是那么几个，只不过交换了他们的组合顺序。结果只能接近最优解，但是无法得到最优解
 *              变异很好理解。当我们通过交叉生成了一条新的染色体后，需要在新染色体上随机选择若干个基因，然后随机修改基因的值，
 *              从而给现有的染色体引入了新的基因，突破了当前搜索的限制，更有利于算法寻找到全局最优解。
 *
 *
 * 概念5：复制：每次进化中，为了保留上一代优良的染色体，需要将上一代中适应度最高的几条染色体直接原封不动地复制给下一代。
 *              假设每次进化都需生成N条染色体，那么每次进化中，通过交叉方式需要生成N-M条染色体，剩余的M条染色体通过复制上一代适应度最高的M条染色体而来。
 *
 * 遗传算法的流程： （1） 在算法初始阶段，它会随机生成一组可行解，也就是第一代染色体。
 *                  （2） 然后采用适应度函数分别计算每一条染色体的适应程度，并根据适应程度计算每一条染色体在下一次进化中被选中的概率
 *                  （3） 通过“交叉”，生成N-M条染色体；
 *                  （4） 再对交叉后生成的N-M条染色体进行“变异”操作；
 *                  （5） 然后使用“复制”的方式生成M条染色体；
 *                  N条染色体生成完毕！紧接着分别计算N条染色体的适应度和下次被选中的概率。  一次进化的过程
 * 究竟需要进化多少次？
 *              每一次进化都会更优，因此理论上进化的次数越多越好，但在实际应用中往往会在结果精确度和执行效率之间寻找一个平衡点，
 *                  （1）、限定进化次数：通过大量实验发现：不管输入的数据如何变化，算法在进化N次之后就能够得到最优解，那么你就可以将进化的次数设成N
 *                  （2）、限定允许范围 ：也就是在精准度和系统的效率之间找到个平衡点，我们可以事先设定一个可以接收的结果范围，当
 *                  算法进行X次进化后，一旦发现了当前的结果已经在误差范围之内了，那么就终止算法。
 *  应用场景：采用遗传算法解决负载均衡调度问题
 *             问题：假设有N个任务，需要负载均衡器分配给M个服务器节点去处理。每个任务的任务长度、每台服务器节点的处理速度已知，请给出一种任务分配方式，使得所有任务的总处理时间最短。
 */
public class algorithm {

    //1. 数学建模，将这个实际问题映射成遗传算法的数学模型


    public static void main(String[] args) {
        List<WarehourcePriorityGoods> wpgList = new ArrayList<>();
        WarehourcePriorityGoods warehourcePriorityGoods = new WarehourcePriorityGoods("100",10);
        WarehourcePriorityGoods warehourcePriorityGoods1 = new WarehourcePriorityGoods("101",11);
        WarehourcePriorityGoods warehourcePriorityGoods2 = new WarehourcePriorityGoods("102",12);
        WarehourcePriorityGoods warehourcePriorityGoods3 = new WarehourcePriorityGoods("103",13);
        wpgList.add(warehourcePriorityGoods);
        wpgList.add(warehourcePriorityGoods1);
        wpgList.add(warehourcePriorityGoods2);
        wpgList.add(warehourcePriorityGoods3);

        Map<String, List<String>> warehouseForGoods = new LinkedHashMap<>();
        List<String> goodsNos = new ArrayList<>();
        goodsNos.add("100");
        goodsNos.add("101");
        warehouseForGoods.put("200",goodsNos);

        List<String> goodsNos1 = new ArrayList<>();
        goodsNos.add("102");
        goodsNos.add("103");
        warehouseForGoods.put("300",goodsNos);

        String[][] strings = initialPopulation(wpgList, warehouseForGoods);

        for(int m=0;m<strings.length;m++){//控制行数
            for(int n=0;n<strings[m].length;n++){//一行中有多少个元素（即多少列）
                System.out.print(strings[m][n]+" ");
            }
            System.out.println();
        }

    }

    /**
     * @param wpgList  仓库待排序列表，仓库覆盖商品数和仓库优先级
     * @param warehouseForGoods  key :goodsNo value: 库房号  linkedHashMap 有序，很重要
     * @return  初始种群 种群中某一个染色体的排列顺序是跟 warehouseForGoods 一致的
     */
    public static String[][]  initialPopulation(List<WarehourcePriorityGoods> wpgList, Map<String, List<String>> warehouseForGoods) { // 初始化NP个字符串，代表一个种群
        String[][] ipop = new String[50][]; //ipop为字符串数组，族群大小
        for (int i = 0; i < 50; i++) {
            //ipop[i] = initialPop(sku);
            //如果是第一个选择所有组合中最佳的一个，剩余的随机选取
            String[] bestPopulation=new String[warehouseForGoods.size()];
            if(i==0){
                Iterator<Map.Entry<String, List<String>>> iterator = warehouseForGoods.entrySet().iterator();
                int j=0;
                while (iterator.hasNext()){
                    List<String> warehouseno=iterator.next().getValue();
                    List<WarehourcePriorityGoods> li=new ArrayList<WarehourcePriorityGoods>();
                    for(String str:warehouseno){
                        for(WarehourcePriorityGoods wpg:wpgList){
                            if(str.equals(wpg.getWareHouseNo())){
                                li.add(wpg);
                                continue;
                            }
                        }

                    }
                    Collections.sort(li);
                    bestPopulation[j]=li.get(0).getWareHouseNo();
                    j++;
                }
                ipop[i] =bestPopulation;
            }else{
                String[] bestPopulationtem=new String[warehouseForGoods.size()];
                Random random=new Random();
                int j=0;
                Iterator<Map.Entry<String, List<String>>> iterator = warehouseForGoods.entrySet().iterator();
                while (iterator.hasNext()){
                    List<String> warehouseno=iterator.next().getValue();
                    bestPopulationtem[j]=warehouseno.get(random.nextInt(warehouseno.size()));
                    j++;
                }
                ipop[i] =bestPopulationtem;
            }

        }
        return ipop;
    }
}


class WarehourcePriorityGoods implements Comparable<WarehourcePriorityGoods>{

    private String wareHouseNo;

    private int level;

    public WarehourcePriorityGoods(String wareHouseNo, int level) {
        this.wareHouseNo = wareHouseNo;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getWareHouseNo() {
        return wareHouseNo;
    }

    public void setWareHouseNo(String wareHouseNo) {
        this.wareHouseNo = wareHouseNo;
    }

    @Override
    public int compareTo(WarehourcePriorityGoods o) {
        return this.level - o.getLevel();
    }
}
