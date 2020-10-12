package 位运算.只出现一次的数字.q260_只出现一次的数字III.f1;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : Solution
 * @Description :260. 只出现一次的数字 III
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * 示例 :
 *
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 *
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * @Author : zph
 * @Date: 2020-10-11 23:04
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title singleNumber
     * @Description 哈希表
     * 建立一个值到频率的映射关系的哈希表，返回频率为 1 的数字。
     * @Author zph
     * @Date 2020/10/11 23:06
     * @Param [nums]
     * @return int[]
     */
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> hashmap = new HashMap();
        for (int n : nums)
            hashmap.put(n, hashmap.getOrDefault(n, 0) + 1);

        int[] output = new int[2];
        int idx = 0;
        for (Map.Entry<Integer, Integer> item : hashmap.entrySet())
            if (item.getValue() == 1) output[idx++] = item.getKey();

        return output;
    }

}
