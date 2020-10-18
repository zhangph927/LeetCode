package 数学.q172_阶乘后的零.f1;

import java.math.BigInteger;

/**
 * @ClassName : Solution
 * @Description :172. 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 * @Author : zph
 * @Date: 2020-08-29 16:44
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title trailingZeroes
     * @Description 计算阶乘
     * @Author zph
     * @Date 2020/8/29 16:50
     * @Param [n]
     * @return int
     */
    public int trailingZeroes(int n) {
        BigInteger nFactorial=BigInteger.ONE;
        for(int i=2;i<=n;i++){
            nFactorial=nFactorial.multiply(BigInteger.valueOf(i));
        }
        int zeroCount=0;
        while (nFactorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)){
            zeroCount++;
            nFactorial=nFactorial.divide(BigInteger.TEN);
        }

        return zeroCount;
    }



}
