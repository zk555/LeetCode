package 数据结构与算法.遗传算法;

/**
 * ClassName MainRun
 * Description
 * Create by zhaokai108
 * Date 2020/12/8 14:49
 */
public class MainRun {

    public static void main(String[] args) {
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        SpeciesPopulation speciesPopulation = new SpeciesPopulation();
        SpeciesIndividual bestRate=geneticAlgorithm.run(speciesPopulation);
        //打印路径与最短距离
        bestRate.printRate();
    }
}
