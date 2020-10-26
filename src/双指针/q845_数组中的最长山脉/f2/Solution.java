package 双指针.q845_数组中的最长山脉.f2;

/**
 * @ClassName : Solution
 * @Description :845. 数组中的最长山脉
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * <p>
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * <p>
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * <p>
 * 如果不含有 “山脉” 则返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 * <p>
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * @Author : zph
 * @Date: 2020-10-18 00:13
 * @Version : V1.0
 */
public class Solution {

    /**
     * @return int
     * @Title longestMountain
     * @Description 双指针
     * @Author zph
     * @Date 2020/10/18 0:17
     * @Param [A]
     */
    public int longestMountain(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int length = A.length;
        int left = 0;
        int right = 0;
        int ans = 0;
        while (left + 2 < length) {
            right = left + 1;
            if (A[left] < A[left + 1]) {
                while (right + 1 < length && A[right] < A[right + 1]) {
                    right++;
                }
                if (right + 1 < length && A[right] > A[right + 1]) {
                    while (right + 1 < length && A[right] > A[right + 1]) {
                        right++;
                    }
                    ans = Math.max(ans, right - left + 1);
                } else {
                    right++;
                }

            }
            left = right;
        }
        return ans;
    }

}
