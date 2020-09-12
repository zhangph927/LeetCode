package 数组.两数之和.q167_两数之和II输入有序数组.f1;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : Solution
 * @Description :167. 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * @Author : zph
 * @Date: 2020-07-20 22:47
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title twoSum
     * @Description 哈希表
     * @Author zph
     * @Date 2020/7/20 22:55
     * @Param [numbers, target]
     * @return int[]
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        if (numbers == null || numbers.length == 0) {
            return ans;
        }
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            int num=numbers[i];

            if(map.containsKey(target-num)){
                Integer secondIndex = map.get(target - num);
                if(secondIndex>i){
                    ans[0]=i+1;
                    ans[1]=secondIndex+1;
                }else {
                    ans[0]=secondIndex+1;
                    ans[1]=i+1;
                }
            }
            map.put(num,i);

        }
        return ans;


    }
}
