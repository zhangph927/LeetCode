package 数组操作.两数之和.q18_四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 * @Author : zph
 * @Date: 2020-09-02 18:23
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title fourSum
     * @Description 排序 + 双指针
     * @Author zph
     * @Date 2020/9/2 18:23
     * @Param [nums, target]
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int length=nums.length;
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<length-3;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<length-2;j++){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int k=j+1;
                int l=length-1;
                while(k<l){
                    if(k>j+1&&nums[k]==nums[k-1]){
                        k++;
                        continue;
                    }
                    if(l<length-1&&nums[l]==nums[l+1]){
                        l--;
                        continue;
                    }
                    int s=nums[i]+nums[j]+nums[k]+nums[l];
                    if(target==s){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                        l--;
                    }else if(s>target){
                        l--;
                    }else{
                        k++;
                    }
                }
            }
        }
        return ans;

    }
}
