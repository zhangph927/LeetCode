package 动态规划.qLCP_19_秋叶收藏集.f1;

/**
 * @ClassName : Solution
 * @Description :LCP 19. 秋叶收藏集
 * 小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves， 字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
 * 出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于 1。每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
 *
 * 示例 1：
 *
 * 输入：leaves = "rrryyyrryyyrr"
 *
 * 输出：2
 *
 * 解释：调整两次，将中间的两片红叶替换成黄叶，得到 "rrryyyyyyyyrr"
 *
 * 示例 2：
 *
 * 输入：leaves = "ryr"
 *
 * 输出：0
 *
 * 解释：已符合要求，不需要额外操作
 *
 * 提示：
 *
 * 3 <= leaves.length <= 10^5
 * leaves 中只包含字符 'r' 和字符 'y'
 * @Author : zph
 * @Date: 2020-10-01 21:31
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title minimumOperations
     * @Description 动态规划
     * 由于我们想要将收藏集中树叶的排列调整成「红、黄、红」三部分，因此我们可以用 33 个状态分别表示其中的每一部分，即状态 00 和状态 22 分别表示前面和后面的红色部分，状态 11 表示黄色部分。
     *
     * 此时，我们就可以尝试使用动态规划解决本题了。我们用 f[i][j]f[i][j] 表示对于第 00 片到第 ii 片叶子（记为 \textit{leaves}[0..i]leaves[0..i]）进行调整操作，并且第 ii 片叶子处于状态 jj 时的最小操作次数。在推导状态转移方程时，我们可以分别对于每一种状态进行分析。
     *
     * 当 j=0j=0 时，我们需要将第 ii 片叶子变成红色，并且第 i-1i−1 片叶子也只能处于 j=0j=0 的状态（因为没有编号更小的状态了），因此有状态转移方程：
     *
     * f[i][0] = f[i-1][0] + \text{isYellow}(i)
     * f[i][0]=f[i−1][0]+isYellow(i)
     *
     * 其中 \text{isYellow}(i)isYellow(i) 为示性函数，当第 ii 片叶子为黄色时为 11，红色时为 00。
     *
     * 当 j=1j=1 时，我们需要将第 ii 片叶子变成黄色，而第 i-1i−1 片叶子既可以处于 j=1j=1 的状态，也可以处于 j=0j=0 的状态，我们选择其中的较小值，因此有状态转移方程：
     *
     * f[i][1] = \min \{ f[i-1][0], f[i-1][1] \} + \text{isRed}(i)
     * f[i][1]=min{f[i−1][0],f[i−1][1]}+isRed(i)
     *
     * 其中 \text{isRed}(i)isRed(i) 为示性函数，当第 ii 片叶子为红色时为 11，黄色时为 00。
     *
     * 当 j=2j=2 时，我们需要将第 ii 片叶子变成红色，而第 i-1i−1 片叶子即可以处于 j=2j=2 的状态，也可以处于 j=1j=1 的状态（注意这里不能处于 j=0j=0 的状态，因为每一种状态包含的叶子数量必须至少为 11），我们选择其中的较小值，因此有状态转移方程：
     *
     * f[i][2] = \min \{ f[i-1][1], f[i-1][2] \} + \text{isYellow}(i)
     * f[i][2]=min{f[i−1][1],f[i−1][2]}+isYellow(i)
     *
     * 最终的答案即为 f[n-1][2]f[n−1][2]，其中 nn 是字符串 \textit{leaves}leaves 的长度，也就是树叶的总数。
     *
     * 细节
     *
     * 由于 因为每一种状态包含的叶子数量必须至少为 11，因此不仅需要特别注意 j=2j=2 时的状态转移方程，还需要考虑每个状态本身是否是符合要求的。对于状态 f[i][j]f[i][j] 而言，它包含了 \textit{leaves}[0..i]leaves[0..i] 共 i+1i+1 片叶子以及 j+1j+1 个状态，因此 叶子的数量必须大于等于状态的数量，即满足 i \geq ji≥j。这样一来，所有 i < ji<j 的状态 f[i][j]f[i][j] 都是不符合要求的。观察上面的状态转移方程，我们在每一步转移时都是取最小值，因此我们可以将所有不符合要求的状态置为一个极大值（例如 n+1n+1 或整数类型的上限等）。
     *
     * 同时需要注意的是，当 i=0i=0 时，f[i][..]f[i][..] 会从 f[i-1][..]f[i−1][..] 转移而来，但后者是没有意义的，因此我们需要对 f[i][..]f[i][..] 进行特殊处理。由于当 i=0i=0 时，jj 也只能为 00，因此我们有：
     *
     * f[0][0] = \text{isYellow}(0)
     * f[0][0]=isYellow(0)
     *
     * 作为唯一的边界条件。
     *
     * @Author zph
     * @Date 2020/10/1 21:35
     * @Param [leaves]
     * @return int
     */
    public int minimumOperations(String leaves) {
        int length=leaves.length();
       int[][] dp= new int[length][3];
        char[] chars = leaves.toCharArray();

        //初始化
        dp[0][0]=chars[0]=='y'?1:0;
        dp[0][1]=dp[0][2]=dp[1][2]=Integer.MAX_VALUE;
        for(int i=1;i<length;i++){
            int isRed=chars[i]=='r'?1:0;
            int isYellow=chars[i]=='y'?1:0;
            dp[i][0]=dp[i-1][0]+isYellow;
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][1])+isRed;
            if(i>=2){
                dp[i][2]=Math.min(dp[i-1][1],dp[i-1][2])+isYellow;

            }
        }
        return dp[length-1][2];
    }
}
