package 二分法.q287_寻找重复数.f2;

/**
 * @ClassName : Solution
 * @Description :287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * @Author : zph
 * @Date: 2020-07-25 17:35
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return int
     * @Title findDuplicate
     * @Description 二进制
     * @Author zph
     * @Date 2020/7/25 17:36
     * @Param [nums]
     */
    public int findDuplicate(int[] nums) {
        int n = nums.length, ans = 0;
        int bit_max=31;
        while (((n-1)&bit_max)==0){
            bit_max--;
        }
        for (int bit=0;bit<bit_max;bit++){
            int x=0;
            int y=0;

            for(int i=0;i<n;i++){
                if((nums[i]&(1<<bit))!=0){
                    x++;
                }
                if(i>=1&&((i&(1<<bit))!=0)){
                    y++;
                }
            }
            if(x>y){
                ans|=1<<bit;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={1,3,4,2,2};
        int duplicate = solution.findDuplicate(nums);
        System.out.println(duplicate);

    }

}
