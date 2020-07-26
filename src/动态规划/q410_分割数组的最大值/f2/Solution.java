package 动态规划.q410_分割数组的最大值.f2;

import java.util.Arrays;

/**
 * @ClassName : Solution
 * @Description :410. 分割数组的最大值
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 * <p>
 * 注意:
 * 数组长度 n 满足以下条件:
 * <p>
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 示例:
 * <p>
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 * <p>
 * 输出:
 * 18
 * <p>
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * @Author : zph
 * @Date: 2020-07-25 18:31
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return int
     * @Title splitArray
     * @Description 二分+贪心
     * @Author zph
     * @Date 2020/7/25 19:36
     * @Param [nums, m]
     */
    public int splitArray(int[] nums, int m) {
        int length = nums.length;
        int left=0;
        int right=0;
        for(int i=0;i<length;i++){
            right+=nums[i];
            if(left<nums[i]){
                left=nums[i];
            }
        }
        while (left<right){
            int mid=left+(right-left)/2;
            if(check(nums,mid,m)){
                right=mid;
            }else {
                left=mid+1;

            }

        }
        return left;
    }

    private boolean check(int[] nums,int x,int m){
        int sum=0;
        int cut=1;
        int length=nums.length;
        for(int i=0;i<length;i++){
            if(sum+nums[i]>x){
                cut++;
                sum=nums[i];
            }else {
                sum+=nums[i];
            }

        }
        return cut<=m;

    }




    public static void main(String[] args) {

        Solution solution = new Solution();
       int[] nums = {7,2,5,10,8};
      int   m = 2;
        int i = solution.splitArray(nums, m);
        System.out.println(i);
    }
}
