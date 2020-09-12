package 栈相关.单调栈.接雨水.q42_接雨水.f4;

import java.util.ArrayDeque;
import java.util.Deque;

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
     * @Description 栈（单调栈）
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

        // 单调栈里面存的是索引
        // 根据官方对 Stack 的使用建议，这里将 Deque 对象当做 stack 使用，注意只使用关于栈的接口
        // 由于实现类是数组 `ArrayDeque`，因此只能在末尾添加和删除元素
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();

                // 特殊情况，当栈为空的时候，跳出循环，直接增加当前下标 i 到栈里
                if (stack.isEmpty()) {
                    break;
                }

                int currentWidth = i - stack.peek() - 1;
                int currentHeight = Math.min(height[i], height[stack.peek()]) - height[top];

                res += currentWidth * currentHeight;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{3, 0, 0, 1, 0, 2, 0, 4};
        Solution solution = new Solution();
        int res = solution.trap(height);
        System.out.println(res);
    }



    private int max(int[] height, int left, int right) {
        int res = height[left];
        for (int i = left + 1; i <= right; i++) {
            res = Math.max(res, height[i]);
        }
        return res;
    }

}
