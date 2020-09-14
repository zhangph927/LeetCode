package 栈.单调栈.接雨水.q42_接雨水.f3;

/**
 * @ClassName : Solution
 * @Description :42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * @Author : zph
 * @Date: 2020-09-09 00:26
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title trap
     * @Description 指针对撞（双指针）
     * @Author zph
     * @Date 2020/9/9 23:23
     * @Param [height]
     * @return int
     */
    public int trap(int[] height) {
        int len = height.length;
        // 特判
        if (len < 3) {
            return 0;
        }

        // 注意初值的选取，前面做了特判，下标 0 和 len - 1 位置都不存雨水，因此这里有效
        // 在区间 [1, len - 2] 里计算存水量
        int left = 1;
        int right = len - 2;

        // 记录区间 [0, left - 1] 的最大高度
        int curLeftHighest = height[0];
        // 记录区间 [right + 1, len - 1] 的最大高度
        int curRightHighest = height[len - 1];

        int res = 0;
        // 这里是等于，因为当 left == right 的时候，left(right) 这个位置的存水量还需要计算一下
        while (left <= right) {
            // 调试代码
            // System.out.println("left = " + left + " right = " + right + " curLeftHighest = " + curLeftHighest + " curRightHighest = " + curRightHighest+ " res = " + res );
            int minHeight = Math.min(curLeftHighest, curRightHighest);

            // 存水单位体积取决于较短的那个柱形的高度
            if (minHeight == curLeftHighest) {
                if (minHeight > height[left]) {
                    // 大于当前，才可以存水
                    res += minHeight - height[left];
                }
                // 更新左边的柱形的最高高度
                curLeftHighest = Math.max(curLeftHighest, height[left]);
                // 指针右移
                left++;
            } else {
                if (minHeight > height[right]) {
                    res += minHeight - height[right];
                }
                curRightHighest = Math.max(curRightHighest, height[right]);
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{3, 0, 0, 1, 0, 2, 0, 4};
        Solution solution = new Solution();
        int res = solution.trap(height);
        System.out.println(res);
    }


}
