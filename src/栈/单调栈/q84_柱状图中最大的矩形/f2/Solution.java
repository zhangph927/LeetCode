package 栈.单调栈.q84_柱状图中最大的矩形.f2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName : Solution
 * @Description :84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *
 *
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *
 *
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 *
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * @Author : zph
 * @Date: 2020-07-08 21:44
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title largestRectangleArea
     * @Description 单调栈和哨兵
     * @Author zph
     * @Date 2020/7/8 22:46
     * @Param [heights]
     * @return int
     */
    public int largestRectangleArea(int[] heights) {

        if(heights==null||heights.length==0){
            return 0;
        }
        int length=heights.length;
        if(length==1){
            return heights[0];
        }
        int[] newHeights=new int[length+2];
        System.arraycopy(heights,0,newHeights,1,length);
        newHeights[0]=0;
        newHeights[length+1]=0;
        length+=2;
        heights=newHeights;

        //存储角标
        Deque<Integer> stack = new ArrayDeque<>();
        //不在判断是否为空
        stack.addLast(0);
        int res=0;
        for(int i=1;i<length;i++){
            //单调递增栈
            while (heights[i]<heights[stack.peekLast()]){
                int curHeight=heights[stack.pollLast()];
                //可能存在多个相等高度
                while (!stack.isEmpty()&&curHeight==heights[stack.peekLast()]){
                    stack.pollLast();
                }
                int curWidth=0;
                //可以计算到最左边
                curWidth=i-stack.peekLast()-1;
                res=Math.max(res,curHeight*curWidth);
            }
            stack.addLast(i);
        }

        return res;

    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int [] nums={2,1,5,6,2,3};
        int i = solution.largestRectangleArea(nums);
        System.out.println(i);
    }



}
