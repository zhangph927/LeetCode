package 动态规划.背包dp.背包问题原型.q01背包问题;

import java.util.Scanner;

/**
 * @ClassName : Solution
 * @Description :2. 01背包问题
 *    题目
 *    讨论
 *    题解
 *    视频讲解
 *
 * 有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。
 *
 * 第 i 件物品的体积是 vi，价值是 wi。
 *
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 * 输出最大价值。
 *
 * 输入格式
 * 第一行两个整数，N，V，用空格隔开，分别表示物品数量和背包容积。
 *
 * 接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 件物品的体积和价值。
 *
 * 输出格式
 * 输出一个整数，表示最大价值。
 *
 * 数据范围
 * 0<N,V≤1000
 * 0<vi,wi≤1000
 * 输入样例
 * 4 5
 * 1 2
 * 2 4
 * 3 4
 * 4 5
 * 输出样例：
 * 8
 * @Author : zph
 * @Date: 2020-09-24 00:39
 * @Version : V1.0
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        // 读入数据的代码
        Scanner reader = new Scanner(System.in);
        // 物品的数量为N
        int N = reader.nextInt();
        // 背包的容量为V
        int V = reader.nextInt();
        // 一个长度为N的数组，第i个元素表示第i个物品的体积；
        int[] v = new int[N + 1] ;
        // 一个长度为N的数组，第i个元素表示第i个物品的价值；
        int[] w = new int[N + 1] ;

        for (int i=1 ; i <= N ; i++){
            // 接下来有 N 行，每行有两个整数:v[i],w[i]，用空格隔开，分别表示第i件物品的体积和价值
            v[i] = reader.nextInt();
            w[i] = reader.nextInt();
        }
        reader.close() ;

        // 正式算法的代码
        // 将dp优化为一维数组
        /*
        注意，这里第二层循环的时候，还是小到大循环的话，那么

        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-v[i]] + w[i])
        实际上变成了
        dp[i][j] = Math.max(dp[i][j], dp[i][j-v[i]] + w[i]);

        因为i-1的值已经在前面被更新过了，覆盖了
        为了避免这个问题，所以要逆序更新，即先更新第i个，然后更新第i-1个，从而保证第i-1个不被覆盖

        如果不逆序的话，输出结果为10，dp数组实际为：
        0 0 0 0 0 0
        0 2 4 6 8 10
        0 2 4 6 8 10
        0 2 4 6 8 10
        0 2 4 6 8 10
        */
        int[] dp = new int[V+1];
        dp[0] = 0;
        for(int i = 1; i <= N; i++){
            for(int j = V; j >= v[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-v[i]] + w[i]);
            }
            // for(int j = 0; j <= V; j++){
            //     System.out.print(dp[j]);
            //     System.out.print(" ");
            // }
            // System.out.print("\n");
        }
        System.out.println(dp[V]);
    }

}
