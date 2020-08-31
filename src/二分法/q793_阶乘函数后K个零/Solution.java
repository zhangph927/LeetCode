package 二分法.q793_阶乘函数后K个零;

/**
 * @ClassName : Solution
 * @Description :793. 阶乘函数后K个零
 *  f(x) 是 x! 末尾是0的数量。（回想一下 x! = 1 * 2 * 3 * ... * x，且0! = 1）
 *
 * 例如， f(3) = 0 ，因为3! = 6的末尾没有0；而 f(11) = 2 ，因为11!= 39916800末端有2个0。给定 K，找出多少个非负整数x ，有 f(x) = K 的性质。
 *
 * 示例 1:
 * 输入:K = 0
 * 输出:5
 * 解释: 0!, 1!, 2!, 3!, and 4! 均符合 K = 0 的条件。
 *
 * 示例 2:
 * 输入:K = 5
 * 输出:0
 * 解释:没有匹配到这样的 x!，符合K = 5 的条件。
 * 注意：
 *
 * K是范围在 [0, 10^9] 的整数。
 * @Author : zph
 * @Date: 2020-08-29 17:50
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title preimageSizeFZF
     * @Description 二分查找
     * @Author zph
     * @Date 2020/8/29 17:52
     * @Param [K]
     * @return int
     */
    public int preimageSizeFZF(int K) {
        if(K==0){
            return 5;
        }
        return (int)(getRightIndex(K)- getLeftIndex(K)+1);
    }

    /**
     * @Title trailingZeroes
     * @Description 高效的计算因子 5
     * @Author zph
     * @Date 2020/8/29 16:50
     * @Param [n]
     * @return int
     */
    public long trailingZeroes(long n) {

        long zeroCount=0;
        while (n>0){
            n=n/5;
            zeroCount=zeroCount+n;
        }
        return zeroCount;
    }


    private  long getLeftIndex(int target){
        long left=0;
        long right=Long.MAX_VALUE;
        while (left<right){
            long mid=left+(right-left)/2;
           long  num= trailingZeroes(mid);
            if (num < target) {
                left = mid + 1;
            } else if (num > target) {
                right = mid;
            } else {
                right = mid;
            }
        }
        return  left;
    }
    private  long getRightIndex( int target){
        long left=0;
        long right=Long.MAX_VALUE;
        while (left<right){
            long mid=left+(right-left)/2;
            long  num= trailingZeroes(mid);
            if (num < target) {
                left = mid + 1;
            } else if (num > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        //一定存在
        return left-1;
    }
}
