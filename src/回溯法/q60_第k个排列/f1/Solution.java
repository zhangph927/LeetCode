package 回溯法.q60_第k个排列.f1;

import java.util.Arrays;

/**
 * @ClassName : Solution
 * @Description :60. 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * @Author : zph
 * @Date: 2020-09-05 23:32
 * @Version : V1.0
 */
public class Solution {

    private boolean used[];
    private int[] factorial;
    private int n;
    private int k;

    /**
     * @Title getPermutation
     * @Description 回溯搜索算法 + 剪枝 ，直接来到叶子结点
     * @Author zph
     * @Date 2020/9/5 23:35
     * @Param [n, k]
     * @return java.lang.String
     */
    public String getPermutation(int n, int k) {
        this.k=k;
        this.n=n;
        factorial=new int[n+1];
        used=new boolean[n+1];
        //计算阶乘
        calculateFactorial(n);

        Arrays.fill(used,false);
        StringBuffer path = new StringBuffer();

        dfs(0,path);
        return path.toString();

    }

    /**
     * @Title dfs
     * @Description TODO
     * @Author zph
     * @Date 2020/9/6 12:00
     * @Param [index 在这一步之前已经选择了几个数字，其值恰好等于这一步需要确定的下标位置,
     * path]
     * @return void
     */
    private void dfs(int index,StringBuffer path){
        if(index==n){
            return;
        }
        // 计算还未确定的数字的全排列的个数，第 1 次进入的时候是 n - 1
        int cnt=factorial[n-1-index];
        for(int i=1;i<=n;i++){
            if(used[i]){
                continue;
            }
            if(cnt<k){
                k=k-cnt;
                continue;
            }
            path.append(i);
            used[i]=true;
            dfs(index+1,path);
            // 注意 1：没有回溯（状态重置）的必要

            // 注意 2：这里要加 return，后面的数没有必要遍历去尝试了
            return;

        }

    }

    private void calculateFactorial(int n){

        factorial[0]=1;
        for(int i=1;i<=n;i++){
            factorial[i]=factorial[i-1]*i;
        }
    }
}
