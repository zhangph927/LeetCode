package 动态规划.q70_爬楼梯.f1;

/**
 * @ClassName : Solution
 * @Description :70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * @Author : zph
 * @Date: 2020-07-18 19:03
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title climbStairs
     * @Description 动态规划
     * @Author zph
     * @Date 2020/7/18 19:04
     * @Param [n]
     * @return int
     */
    public int climbStairs(int n) {
        if(n==0||n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int i = solution.climbStairs(1);
        System.out.println(i);
    }
}
