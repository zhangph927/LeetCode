package 栈.单调栈.q85_最大矩形.f2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName : Solution
 * @Description :85. 最大矩形
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * @Author : zph
 * @Date: 2020-09-10 00:24
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title maximalRectangle
     * @Description 使用柱状图 - 栈
     * @Author zph
     * @Date 2020/9/10 0:24
     * @Param [matrix]
     * @return int
     */
    // Get the maximum area in a histogram given its heights
    private int helper(int[] heights){
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
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        int res=0;
        for(int i=1;i<length;i++){
            while (heights[i]<heights[stack.peekLast()]){
                int curHigh=heights[stack.pollLast()];
                while (!stack.isEmpty()&&curHigh==heights[stack.peekLast()]){
                    stack.pollLast();
                }
                int curWidth=i-stack.peekLast()-1;
                res=Math.max(res,curHigh*curWidth);
            }
            stack.addLast(i);

        }

        return res;
    }

    public int maximalRectangle(String[][] matrix) {

        if (matrix.length == 0) return 0;
        int maxarea = 0;
        int[] dp = new int[matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {

                // update the state of this row's histogram using the last row's histogram
                // by keeping track of the number of consecutive ones

                dp[j] = matrix[i][j] == "1" ? dp[j] + 1 : 0;
            }
            // update maxarea with the maximum area from this row's histogram
            maxarea = Math.max(maxarea, helper(dp));
        }
        return maxarea;
    }


    public static void main(String[] args) {

        Solution solution = new Solution();

      String[][] nums= {
              {"1", "0", "1", "0", "0"},
              {"1", "0", "1", "1", "1"},
              {"1", "1", "1", "1", "1"},
              {"1", "0", "0", "1", "0"}
      };
        int i = solution.maximalRectangle(nums);
        System.out.println(i);


    }


}
