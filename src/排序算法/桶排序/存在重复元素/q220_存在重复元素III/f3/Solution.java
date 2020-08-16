package 排序算法.桶排序.存在重复元素.q220_存在重复元素III.f3;

import java.util.HashMap;

/**
 * @ClassName : Solution
 * @Description :在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。
 * <p>
 * 如果存在则返回 true，不存在返回 false。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 * @Author : zph
 * @Date: 2020-08-10 18:14
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return boolean
     * @Title containsNearbyAlmostDuplicate
     * @Description 桶排序
     * @Author zph
     * @Date 2020/8/15 17:33
     * @Param [nums, k, t]
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (t < 0) {
            return false;
        }
        int length = nums.length;
        HashMap<Long, Long> d = new HashMap<>();
        long w=(long)t+1;
        for(int i=0;i<length;i++){
            long m=getID(nums[i],w);
            if(d.containsKey(m)){
                return true;
            }
            if(d.containsKey(m-1)&&Math.abs(nums[i]-d.get(m-1))<w){
                return true;
            }
            if(d.containsKey(m+1)&&Math.abs(nums[i]-d.get(m+1))<w){
                return true;
            }
            d.put(m,(long)nums[i]);
            if(i>=k){
                d.remove(getID(nums[i-k],w));
            }

        }
        return false;


    }

    private long getID(long x,long w){
        return x<0?(x+1)/w-1:x/w;
    }


}
