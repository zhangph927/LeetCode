package 双指针.q283_移动零.f2;

/**
 * @ClassName : Solution
 * @Description :283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * @Author : zph
 * @Date: 2020-10-18 16:09
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title moveZeroes
     * @Description 一次遍历
     * @Author zph
     * @Date 2020/10/18 16:12
     * @Param [nums]
     * @return void
     */
    public void moveZeroes(int[] nums) {
        if(nums==null||nums.length==0){
            return;
        }

        int j=0;
        int length=nums.length;
        for(int i=0;i<length;i++){
            if(nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j++]=temp;
            }
        }


    }
}
