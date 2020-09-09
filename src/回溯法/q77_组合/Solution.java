package 回溯法.q77_组合;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * @Author : zph
 * @Date: 2020-09-08 23:28
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title combine
     * @Description 回溯
     * @Author zph
     * @Date 2020/9/8 23:33
     * @Param [n, k]
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> combine(int n,int k){
        List<List<Integer>> res = new ArrayList<>();
        if(k<=0){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(res,path,n,k,1);

        return res;

    }

    private void dfs(List<List<Integer>> res,Deque<Integer> path,
                     int n,int k,int start){
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<=n;i++){
            path.addLast(i);
            dfs(res,path,n,k,i+1);
            path.removeLast();
        }

    }
}
