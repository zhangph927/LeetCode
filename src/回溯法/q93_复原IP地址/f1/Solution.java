package 回溯法.q93_复原IP地址.f1;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * @Author : zph
 * @Date: 2020-08-09 23:56
 * @Version : V1.0
 */
public class Solution {
    private final int SEG_COUNT = 4;
    private List<String> ans = new ArrayList<>();
    private int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
       dfs(s,0,0);
       return ans;
    }

    private void dfs(String s, int segId, int segStart) {

        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer buffer = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; i++) {
                    buffer.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        buffer.append(".");

                    }

                }
                ans.add(buffer.toString());
            }
            return;
        }
        if (segStart == s.length()) {
            return;
        }
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }
        //一般情况
        int length = s.length();
        int addr = 0;
        for (int segEnd = segStart; segEnd < length; segEnd++) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xff) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);

            } else {
                break;
            }


        }

    }
}
