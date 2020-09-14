package 数组.两数之和.q454_四数相加II;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : Solution
 * @Description :454. 四数相加 II
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 * <p>
 * 例如:
 * <p>
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * @Author : zph
 * @Date: 2020-09-13 18:57
 * @Version : V1.0
 */
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = A.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sum = A[i] + B[j];
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }

            }
        }
        int count = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sum = -(C[i] + D[j]);
                if (map.containsKey(sum)) {
                    count += map.get(sum);
                }
            }
        }
        return count;


    }
}
