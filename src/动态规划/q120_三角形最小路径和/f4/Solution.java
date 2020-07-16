package 动态规划.q120_三角形最小路径和.f4;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 * <p>
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * @Author : zph
 * @Date: 2020-07-14 18:06
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title minimumTotal
     * @Description 动态规划 从底到顶
     * @Author zph
     * @Date 2020/7/14 22:27
     * @Param [triangle]
     * @return int
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int r = triangle.size();
        int[][] dp = new int[2][r];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < r; i++) {
            int curr=i%2;
            int pre=1-curr;
            dp[curr][0] = dp[pre][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[curr][j] = Math.min(dp[pre][j], dp[pre][j - 1]) + triangle.get(i).get(j);
            }
            dp[curr][i] = dp[pre][i - 1] + triangle.get(i).get(i);
        }
        int ans = dp[(r - 1)%2][0];
        for (int i = 1; i < r; i++) {
            ans = Math.min(ans, dp[(r - 1)%2][i]);
        }
        return ans;


    }

    public static void main(String[] args) {
        List<List<Integer>> triangle=new ArrayList<>();
        List<Integer> t1=new ArrayList<>();
        t1.add(2);
        List<Integer> t2=new ArrayList<>();
        t2.add(3);
        t2.add(4);
        List<Integer> t3=new ArrayList<>();
        t3.add(5);
        t3.add(6);
        t3.add(7);
        List<Integer> t4=new ArrayList<>();
        t4.add(4);
        t4.add(1);
        t4.add(8);
        t4.add(3);
        triangle.add(t1);
        triangle.add(t2);
        triangle.add(t3);
        triangle.add(t4);
        Solution solution = new Solution();

        int i = solution.minimumTotal(triangle);
        System.out.println(i);





    }
}
