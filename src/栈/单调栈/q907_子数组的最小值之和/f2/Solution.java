package 栈.单调栈.q907_子数组的最小值之和.f2;

import java.util.Stack;

/**
 * @ClassName : Solution
 * @Description :907. 子数组的最小值之和
 * 给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。
 * <p>
 * 由于答案可能很大，因此返回答案模 10^9 + 7。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A <= 30000
 * 1 <= A[i] <= 30000
 * @Author : zph
 * @Date: 2020-09-13 16:03
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return int
     * @Title sumSubarrayMins
     * @Description 单调栈
     * @Author zph
     * @Date 2020/9/13 16:03
     * @Param [A]
     */
    int MOD = 1000000007;

    public int sumSubarrayMins(int[] A) {
        Stack<Pair> stack = new Stack<>();
        int res = 0, tmp = 0;
        for (int i = 0; i < A.length; i++) {
            int count = 1;
            while (!stack.empty() && stack.peek().val >= A[i]) {
                Pair pop = stack.pop();
                count += pop.count;
                tmp -= pop.val * pop.count;
            }
            stack.push(new Pair(A[i], count));
            tmp += A[i] * count;
            res += tmp;
            res %= MOD;
        }
        return res;
    }

    class Pair {
        public int val;
        public int count;

        public Pair(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

}
