package 贪心.q5455_最多K次交换相邻数位后得到的最小整数;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :5455. 最多 K 次交换相邻数位后得到的最小整数
 * 给你一个字符串 num 和一个整数 k 。其中，num 表示一个很大的整数，字符串中的每个字符依次对应整数上的各个 数位 。
 *
 * 你可以交换这个整数相邻数位的数字 最多 k 次。
 *
 * 请你返回你能得到的最小整数，并以字符串形式返回。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：num = "4321", k = 4
 * 输出："1342"
 * 解释：4321 通过 4 次交换相邻数位得到最小整数的步骤如上图所示。
 * 示例 2：
 *
 * 输入：num = "100", k = 1
 * 输出："010"
 * 解释：输出可以包含前导 0 ，但输入保证不会有前导 0 。
 * 示例 3：
 *
 * 输入：num = "36789", k = 1000
 * 输出："36789"
 * 解释：不需要做任何交换。
 * 示例 4：
 *
 * 输入：num = "22", k = 22
 * 输出："22"
 * 示例 5：
 *
 * 输入：num = "9438957234785635408", k = 23
 * 输出："0345989723478563548"
 *
 *
 * 提示：
 *
 * 1 <= num.length <= 30000
 * num 只包含 数字 且不含有 前导 0 。
 * 1 <= k <= 10^9
 * @Author : zph
 * @Date: 2020-07-05 21:45
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title minInteger
     * @Description 使用贪心和线段数组
     * @Author zph
     * @Date 2020/7/5 22:18
     * @Param [num, k]
     * @return java.lang.String
     */
    public String minInteger(String num, int k) {
        // 统计0-9的所有位置
        List<Integer>[] idLists = new List[10];
        for (int i = 0; i < 10; i++) {
            idLists[i] = new ArrayList<>();
        }
        int n = num.length();
        for (int i = 0; i < n; i++) {
            idLists[num.charAt(i) - '0'].add(i);
        }
        // 指向idLists的0-9的当前位置
        int[] ids = new int[10];
        boolean[] seen = new boolean[n];
        StringBuilder res = new StringBuilder();
        // 统计范围内已被使用的下标，计算需要转换的次数时需要去掉已被转换到前面的那些下标
        FenwichTree fwt = new FenwichTree(new int[n]);
        outer:
        for (int i = 0; i < n; i++) {
            if (seen[i]) { // 如果已经被置换过了，跳过
                continue;
            }
            int cur = num.charAt(i) - '0';
            // 查找比当前元素小且满足条件的最小值的下标
            for (int j = 0; j < cur; j++) {
                while (ids[j] < idLists[j].size() && idLists[j].get(ids[j]) < i) {
                    ids[j]++;
                }
                if (ids[j] == idLists[j].size()) {
                    continue;
                }
                int index = idLists[j].get(ids[j]);
                int seenNum = fwt.sumRange(0, index - 1);
                if (index - seenNum <= k) {
                    // 找到了满足条件的值，更新状态
                    k -= index - seenNum;
                    ids[j]++;
                    seen[index] = true;
                    fwt.update(index, 1);
                    i--;
                    res.append(j);
                    continue outer;
                }
            }
            // 找不到满足条件且小于当前值的值，更新状态
            seen[i] = true;
            fwt.update(i, 1);
            res.append(cur);
        }
        return res.toString();
    }
}

class FenwichTree {

    private int[] sums;
    private int[] nums;

    public FenwichTree(int[] nums) {
        this.sums = new int[nums.length + 1];
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            updateBit(i + 1, nums[i]);
        }
    }

    public void update(int i, int val) {
        updateBit(i + 1, val - nums[i]);
        nums[i] = val;
    }

    private void updateBit(int i, int diff) {
        while (i < sums.length) {
            sums[i] += diff;
            i += lowBit(i);
        }
    }

    public int sumRange(int i, int j) {
        return preSum(j + 1) - preSum(i);
    }

    private int preSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += sums[i];
            i -= lowBit(i);
        }
        return sum;
    }

    private int lowBit(int i) {
        return i & (-i);
    }
}
