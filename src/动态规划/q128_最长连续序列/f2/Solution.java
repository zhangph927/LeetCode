package 动态规划.q128_最长连续序列.f2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName : Solution
 * @Description :128. 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * @Author : zph
 * @Date: 2020-10-11 20:48
 * @Version : V1.0
 */
public class Solution {

    /**
     * @return int
     * @Title longestConsecutive
     * @Description 哈希表
     * @Author zph
     * @Date 2020/10/11 22:48
     * @Param [nums]
     */
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            // 如果num不在任何已存在的区间
            if (!map.containsKey(num)) {
                // 当前num不存在于区间，找到以num-1为结尾的连续区间的长度
                int lLen = map.getOrDefault(num - 1, 0);
                // 找到以num+1为开始的连续区间的长度
                int rLen = map.getOrDefault(num + 1, 0);
                // 加入num之后最新的区间长度
                int curLen = lLen + rLen + 1;
                ans = Math.max(ans, curLen);
                // num为区间[num-lLen, num+rLen]中的值，无论存什么值都无所谓
                // 因为在找区间的时候只会找到num所在的连续序列的左右端点
                map.put(num, -1);
                // 更新左端点开始连续序列的长度
                map.put(num - lLen, curLen);
                // 更新右端点结尾连续序列的长度
                map.put(num + rLen, curLen);
            }
        }
        return ans;
    }


}
