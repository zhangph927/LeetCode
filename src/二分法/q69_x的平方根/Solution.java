package 二分法.q69_x的平方根;

/**
 * @ClassName : Solution
 * @Description :69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * @Author : zph
 * @Date: 2020-07-06 22:16
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title mySqrt
     * @Description 二分法
     * @Author zph
     * @Date 2020/7/22 23:33
     * @Param [x]
     * @return int
     */
    public int mySqrt(int x) {
        long left=0;
        long right=Integer.MAX_VALUE;
        while (left<right){
            long mid=left+(right-left+1)/2;
            if(mid*mid>x){
                right=mid-1;
            }else {
                left=mid;
            }
        }
        return (int)left;
    }
}
