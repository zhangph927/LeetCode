package 树相关.二叉搜索树.不同的二叉搜索树.q96_不同的二叉搜索树.f1;

/**
 * @ClassName : Solution
 * @Description :96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * @Author : zph
 * @Date: 2020-07-15 22:43
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title numTrees
     * @Description 动态规划
     * (3,7)=G(2)⋅G(4)。 因此，我们可以得到以下公式：
     *
     * F(i, n) = G(i-1) \cdot G(n-i) \qquad \qquad (2)
     * F(i,n)=G(i−1)⋅G(n−i)(2)
     *
     * 将公式 (1)(1)，(2)(2) 结合，可以得到 G(n)G(n) 的递归表达式：
     *
     * G(n) = \sum_{i=1}^{n}G(i-1) \cdot G(n-i) \qquad \qquad (3)
     * G(n)=
     * i=1
     * ∑
     * n
     * ​
     *  G(i−1)⋅G(n−i)(3)
     *
     * @Author zph
     * @Date 2020/7/15 22:59
     * @Param [n]
     * @return int
     */
    public int numTrees(int n) {
       int[] dp= new int[n+1];
       dp[0]=1;
       dp[1]=1;
       for(int i=2;i<=n;i++){
           for(int j=1;j<=i;j++){
               dp[i]+=dp[j-1]*dp[i-j];
           }
       }
       return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.numTrees(3);
        System.out.println(i);
    }
}
