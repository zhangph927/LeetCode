package 动态规划.q279_完全平方数.f4;

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
     * @Description 数学  四平方和定理
     * @Author zph
     * @Date 2020/10/18 15:54
     * @Param [n]
     */
    public int numSquares(int n) {
        //判断是否是 1
        if (isSquare(n)) {
            return 1;
        }

        //判断是否是 4
        int temp = n;
        while (temp % 4 == 0) {
            temp /= 4;
        }
        if (temp % 8 == 7) {
            return 4;
        }

        //判断是否是 2
        for (int i = 1; i * i < n; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }

        return 3;
    }

    //判断是否是平方数
    private boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

}
