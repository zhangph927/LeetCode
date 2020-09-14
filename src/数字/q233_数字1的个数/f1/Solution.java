package 数字.q233_数字1的个数.f1;

/**
 * @ClassName : Solution
 * @Description :233. 数字 1 的个数
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 *
 * 示例:
 *
 * 输入: 13
 * 输出: 6
 * 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
 * @Author : zph
 * @Date: 2020-08-29 17:11
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title countDigitOne
     * @Description 暴力
     * @Author zph
     * @Date 2020/8/29 17:21
     * @Param [n]
     * @return int
     */
    public int countDigitOne(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            int temp=i;
            while (temp>0){
                if(temp%10==1){
                    count++;
                }
                temp=temp/10;
            }
        }
        return count;

    }



}
