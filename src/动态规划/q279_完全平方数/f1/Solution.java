package 动态规划.q279_完全平方数.f1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : Solution
 * @Description :279. 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * @Author : zph
 * @Date: 2020-10-18 15:53
 * @Version : V1.0
 */
public class Solution {


    /**
     * @return int
     * @Title numSquares
     * @Description 动态规划
     * @Author zph
     * @Date 2020/10/18 15:54
     * @Param [n]
     */
    Map<Integer,Integer>  map=new HashMap<Integer, Integer>();
    public int numSquares(int n) {
        return numSquaresHelper(n);
    }

    private int numSquaresHelper(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) {
            return 0;
        }
        int count = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            count = Math.min(count, numSquaresHelper(n - i * i) + 1);
        }
        map.put(n, count);
        return count;
    }


}
