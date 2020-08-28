package 深度优先DFS.汉诺塔问题.q_acwing_96_奇怪的汉诺塔;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :汉诺塔问题，条件如下：
 * <p>
 * 1、这里有A、B、C和D四座塔。
 * <p>
 * 2、这里有n个圆盘，n的数量是恒定的。
 * <p>
 * 3、每个圆盘的尺寸都不相同。
 * <p>
 * 4、所有的圆盘在开始时都堆叠在塔A上，且圆盘尺寸从塔顶到塔底逐渐增大。
 * <p>
 * 5、我们需要将所有的圆盘都从塔A转移到塔D上。
 * <p>
 * 6、每次可以移动一个圆盘，当塔为空塔或者塔顶圆盘尺寸大于被移动圆盘时，可将圆盘移至这座塔上。
 * <p>
 * 请你求出将所有圆盘从塔A移动到塔D，所需的最小移动次数是多少。
 * <p>
 * 河内塔.jpg
 * 汉诺塔塔参考模型
 * <p>
 * 输入格式
 * 没有输入
 * <p>
 * 输出格式
 * 对于每一个整数n(1≤n≤12),输出一个满足条件的最小移动次数，每个结果占一行。
 * @Author : zph
 * @Date: 2020-08-27 20:26
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title run
     * @Description 动态规划
     * @Author zph
     * @Date 2020/8/27 20:32
     * @Param []
     * @return void
     */
    void run() {

        three.add(0);
        for (int i = 1; i <= 12; i++) three.add(2 * three.get(three.size() - 1) + 1);
        four.add(0);
        four.add(1);
        for (int i = 2; i <= 12; i++) {
            int res = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++)
                res = Math.min(res, four.get(j) * 2 + three.get(i - j));
            four.add(res);
        }

        for (int i = 1; i <= 12; i++) System.out.println(four.get(i));
    }


    private List<Integer> three = new ArrayList<>();
    private List<Integer> four = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

}
