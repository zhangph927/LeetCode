package 二分法.q34_在排序数组中查找元素的第一个和最后一个位置;

import com.sun.jmx.snmp.SnmpNull;

/**
 * @ClassName : Solution
 * @Description :34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * @Author : zph
 * @Date: 2020-07-06 21:46
 * @Version : V1.0
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums= {5,7,7,8,8,10};
        int target=8;

        int[] ints = solution.searchRange(nums, target);



    }


    /**
     * @Title searchRange
     * @Description 二分实现
     * @Author zph
     * @Date 2020/7/6 21:47
     * @Param [nums, target]
     * @return int[]
     */
    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return  new int[]{-1,-1};

        }
      int first=  geFirstIndex(nums,target);
      if(first==-1){
          return new int[]{-1,-1};
      }
        int last=  getLastIndex(nums,target);


      return new int[]{first,last};


    }
    private  int geFirstIndex(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        if(target==nums[left]){
            return  left;
        }
        return -1;
    }
    private  int getLastIndex(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=left+(right-left+1)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else {
                left=mid;
            }
        }
        //一定存在
        return left;
    }
}
