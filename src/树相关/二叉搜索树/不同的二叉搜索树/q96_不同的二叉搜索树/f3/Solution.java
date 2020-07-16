package 树相关.二叉搜索树.不同的二叉搜索树.q96_不同的二叉搜索树.f3;

import java.util.HashMap;
import java.util.Map;

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
     * @Description 递归
     * @Author zph
     * @Date 2020/7/15 22:59
     * @Param [n]
     * @return int
     */
    public int numTrees(int n) {
      if(n==0){
          return 1;
      }
        Map<Integer, Integer> memo = new HashMap<>();
     return helper(n,memo);

    }
    private int helper(int n,Map<Integer, Integer> memo){
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        int ans=0;
        if(n==0||n==1){
            return 1;
        }
        for(int i=1;i<=n;i++){
            int leftNum=helper(i-1,memo);
            int rightNum=helper(n-i,memo);
            ans+=leftNum*rightNum;
        }
        memo.put(n,ans);
        return ans;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.numTrees(3);
        System.out.println(i);
    }
}
