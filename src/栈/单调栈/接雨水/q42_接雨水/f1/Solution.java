package 栈.单调栈.接雨水.q42_接雨水.f1;

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
     * @Description 暴力解法
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

        int res = 0;
        // 对区间 [1, len - 2] 的每个位置，分别计算可以存水的单位体积
        for (int i = 1; i < len - 1; i++) {
            int leftHighest = max(height, 0, i - 1);
            int rightHighest = max(height, i + 1, len - 1);

            // 木桶原理，存水的高度取决于二者之中的较矮者
            int curHeight = Math.min(leftHighest, rightHighest);
            if (curHeight > height[i]) {
                res += (curHeight - height[i]);
            }
        }
        return res;
    }

    private int max(int[] height, int left, int right) {
        int res = height[left];
        for (int i = left + 1; i <= right; i++) {
            res = Math.max(res, height[i]);
        }
        return res;
    }

}
