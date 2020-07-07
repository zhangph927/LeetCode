package 数组操作.q560_和为K的子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : Solution
 * @Description :560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * @Author : zph
 * @Date: 2020-07-07 21:20
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title subarraySum
     * @Description 前缀和
     * @Author zph
     * @Date 2020/7/7 21:20
     * @Param [nums, k]
     * @return int
     */
    public int subarraySum(int[] nums, int k) {
        if(nums==null){
            return 0;

        }
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        prefixSumMap.put(0,1);
        int length=nums.length;
        int count=0;
        int pre=0;
        for(int i=0;i<length;i++){
            pre+=nums[i];
            if(prefixSumMap.containsKey(pre-k)){
                count+=prefixSumMap.get(pre-k);
            }
            prefixSumMap.put(pre,prefixSumMap.getOrDefault(pre,0)+1);
        }
        return  count;




    }
}
