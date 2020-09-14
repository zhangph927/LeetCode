package 栈.全局单调栈.q962_最大宽度坡.f1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName : Solution
 * @Description :962. 最大宽度坡
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 * <p>
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[6,0,8,2,1,5]
 * 输出：4
 * 解释：
 * 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
 * 示例 2：
 * <p>
 * 输入：[9,8,1,0,1,9,4,0,4,1]
 * 输出：7
 * 解释：
 * 最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 50000
 * 0 <= A[i] <= 50000
 * @Author : zph
 * @Date: 2020-09-14 00:39
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return int
     * @Title maxWidthRamp
     * @Description 单调栈
     * @Author zph
     * @Date 2020/9/14 0:43
     * @Param [A]
     */
    public int maxWidthRamp(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int length = A.length;
        //初始化栈,栈中存放单调递减的索引,不需要连续,比如 [6,0,8,2,1,5],初始化之后栈中存放的是0,1
        for (int i = 0; i < length; i++) {
            if (stack.isEmpty()) {
                stack.offerLast(i);
            } else {
                if (A[stack.peekLast()] >= A[i]) {
                    stack.offerLast(i);
                }
            }
        }
        int res=0;
        for (int i=length-1;i>=0;i--){
            while (!stack.isEmpty()&&A[stack.peekLast()]<=A[i]){
                res=Math.max(res,i-stack.pollLast());
            }

        }
        return res;


    }
}
