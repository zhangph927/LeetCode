package 数字.q172_阶乘后的零.f2;

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
     * @Description 计算因子 5
     * @Author zph
     * @Date 2020/8/29 16:50
     * @Param [n]
     * @return int
     */
    public int trailingZeroes(int n) {

        int zeroCount=0;
        for(int i=5;i<=n;i+=5){
            int curNum=i;
            while (curNum%5==0){
                curNum=curNum/5;
                zeroCount++;
            }
        }
        return zeroCount;
    }



}
