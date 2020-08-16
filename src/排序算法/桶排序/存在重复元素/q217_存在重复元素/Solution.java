package 排序算法.桶排序.存在重复元素.q217_存在重复元素;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName : Solution
 * @Description :217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * @Author : zph
 * @Date: 2020-08-10 17:10
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title containsDuplicate
     * @Description 哈希表
     * @Author zph
     * @Date 2020/8/10 17:12
     * @Param [nums]
     * @return boolean
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;

    }
}
