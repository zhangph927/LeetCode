package 贪心.q763_划分字母区间;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :763. 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * <p>
 * <p>
 * 提示：
 * <p>
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 * @Author : zph
 * @Date: 2020-10-22 12:34
 * @Version : V1.0
 */
public class Solution {

    /**
     * @return java.util.List<java.lang.Integer>
     * @Title partitionLabels
     * @Description 贪心算法 + 双指针
     * @Author zph
     * @Date 2020/10/22 12:35
     * @Param [S]
     */
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        char[] chars = S.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            last[chars[i] - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[chars[i] - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }

        }
        return partition;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        String S = "ababcbacadefegdehijhklij";
        List<Integer> list = solution.partitionLabels(S);
        System.out.println(list.toString());
    }

}
