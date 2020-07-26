package 动态规划.q1478_安排邮筒;

import java.util.Arrays;

/**
 * @ClassName : Solution
 * @Description :1478. 安排邮筒
 * 给你一个房屋数组houses 和一个整数 k ，其中 houses[i] 是第 i 栋房子在一条街上的位置，现需要在这条街上安排 k 个邮筒。
 * <p>
 * 请你返回每栋房子与离它最近的邮筒之间的距离的 最小 总和。
 * <p>
 * 答案保证在 32 位有符号整数范围以内。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：houses = [1,4,8,10,20], k = 3
 * 输出：5
 * 解释：将邮筒分别安放在位置 3， 9 和 20 处。
 * 每个房子到最近邮筒的距离和为 |3-1| + |4-3| + |9-8| + |10-9| + |20-20| = 5 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：houses = [2,3,5,12,18], k = 2
 * 输出：9
 * 解释：将邮筒分别安放在位置 3 和 14 处。
 * 每个房子到最近邮筒距离和为 |2-3| + |3-3| + |5-3| + |12-14| + |18-14| = 9 。
 * 示例 3：
 * <p>
 * 输入：houses = [7,4,6,1], k = 1
 * 输出：8
 * 示例 4：
 * <p>
 * 输入：houses = [3,6,14,10], k = 4
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == houses.length
 * 1 <= n <= 100
 * 1 <= houses[i] <= 10^4
 * 1 <= k <= n
 * 数组 houses 中的整数互不相同。
 * @Author : zph
 * @Date: 2020-07-25 20:50
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return int
     * @Title minDistance
     * @Description 动态规划
     * @Author zph
     * @Date 2020/7/25 20:51
     * @Param [houses, k]
     */
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        int length = houses.length;
        // dis[i][j] 表示范围[i,j]的房子共用一个邮筒时的最短距离
        int[][] dic = new int[length + 1][length + 1];
        for (int i = 1; i <= length; i++) {
            for (int j = i; j <= length; j++) {
                for (int x = i, y = j; x < y; x++, y--) {
                    dic[i][j] += houses[y - 1] - houses[x - 1];
                }
            }


        }
        // dp[i][j]表示前i个房子摆j个邮筒时的最短距离
        int[][] dp = new int[length + 1][k + 1];
        for (int i = 0; i <= length; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                for (int p = i; p >= 1; p--) {
                    if (dp[p - 1][j - 1] != -1 && (dp[i][j] == -1 || dp[i][j] > (dp[p - 1][j - 1] + dic[p][i]))) {

                        dp[i][j] = dp[p - 1][j - 1] + dic[p][i];
                    }

                }

            }

        }

        return dp[length][k];


    }




    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] houses = {1, 4, 8, 10, 20};
        int k = 3;
        int i = solution.minDistance(houses, k);
        System.out.println(i);
    }
}
