package 栈相关.单调栈.接雨水.q42_接雨水.f2;

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
     * @Description 针对暴力解法的优化，以空间换时间
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

        // leftHighest[i] 定义：区间 [0, i - 1] 中的最大值
        int[] leftHighest = new int[len];
        // 下标为 0 和 下标为 len - 1 的位置不用计算，下面同理
        for (int i = 1; i < len - 1; i++) {
            leftHighest[i] = Math.max(height[i - 1], leftHighest[i - 1]);
        }

        // rightHighest[i] 定义：区间 [i + 1, len - 1] 中的最大值
        int[] rightHighest = new int[len];
        for (int i = len - 2; i > 0; i--) {
            rightHighest[i] = Math.max(height[i + 1], rightHighest[i + 1]);
        }

        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            int minHeight = Math.min(leftHighest[i], rightHighest[i]);
            if (height[i] < minHeight) {
                res += minHeight - height[i];
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
