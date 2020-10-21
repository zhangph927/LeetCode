package 数组.q581_最短无序连续子数组.f2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * @ClassName : Solution
 * @Description :581. 最短无序连续子数组
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 *
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 *
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 * @Author : zph
 * @Date: 2020-10-20 22:51
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title findUnsortedSubarray
     * @Description 使用栈
     * @Author zph
     * @Date 2020/10/20 23:53
     * @Param [nums]
     * @return int
     */
    public int findUnsortedSubarray(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int l=nums.length,r=0;
        int length=nums.length;
        for(int i=0;i<length;i++){
            while (!stack.isEmpty()&&nums[stack.peekLast()]>nums[i]){
                l=Math.min(l,stack.pollLast());
            }
            stack.addLast(i);
        }
        stack.clear();
        for(int i=length-1;i>=0;i--){
            while (!stack.isEmpty()&&nums[stack.peekLast()]<nums[i]){
                r=Math.max(r,stack.pollLast());
            }
            stack.addLast(i);
        }
        return (r-l>0)?r-l+1:0;
    }


}
