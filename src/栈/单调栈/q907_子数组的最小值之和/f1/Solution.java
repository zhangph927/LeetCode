package 栈.单调栈.q907_子数组的最小值之和.f1;

import java.util.Stack;

/**
 * @ClassName : Solution
 * @Description :907. 子数组的最小值之和
 * 给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。
 *
 * 由于答案可能很大，因此返回答案模 10^9 + 7。
 *
 *
 *
 * 示例：
 *
 * 输入：[3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 *
 *
 * 提示：
 *
 * 1 <= A <= 30000
 * 1 <= A[i] <= 30000
 * @Author : zph
 * @Date: 2020-09-13 16:03
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title sumSubarrayMins
     * @Description 前驱 / 后继数组
     * @Author zph // todo 未解决问题
     * @Date 2020/9/13 16:03
     * @Param [A]
     * @return int
     */
    public int sumSubarrayMins(int[] A) {
        int MOD = 1_000_000_007;
        int N = A.length;

        // prev has i* - 1 in increasing order of A[i* - 1]
        // where i* is the answer to query j
        Stack<Integer> stack = new Stack();
        int[] prev = new int[N];
        for (int i = 0; i < N; ++i) {
            while (!stack.isEmpty() && A[i] <= A[stack.peek()])
                stack.pop();
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // next has k* + 1 in increasing order of A[k* + 1]
        // where k* is the answer to query j
        stack = new Stack();
        int[] next = new int[N];
        for (int k = N-1; k >= 0; --k) {
            while (!stack.isEmpty() && A[k] < A[stack.peek()])
                stack.pop();
            next[k] = stack.isEmpty() ? N : stack.peek();
            stack.push(k);
        }

        // Use prev/next array to count answer
        long ans = 0;
        for (int i = 0; i < N; ++i) {
            ans += (i - prev[i]) * (next[i] - i) % MOD * A[i] % MOD;
            ans %= MOD;
        }
        return (int) ans;

    }

}
