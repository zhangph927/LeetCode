package 贪心.四类区间问题.AcWing907_区间覆盖;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @ClassName : Solution
 * @Description :给定N个闭区间[ai,biai,bi]以及一个线段区间[s,ts,t]，请你选择尽量少的区间，将指定线段区间完全覆盖。
 * <p>
 * 输出最少区间数，如果无法完全覆盖则输出-1。
 * <p>
 * 输入格式
 * <p>
 * 第一行包含两个整数s和t，表示给定线段区间的两个端点。
 * <p>
 * 第二行包含整数N，表示给定区间数。
 * <p>
 * 接下来N行，每行包含两个整数ai,biai,bi，表示一个区间的两个端点。
 * <p>
 * 输出格式
 * <p>
 * 输出一个整数，表示所需最少区间数。
 * <p>
 * 如果无解，则输出-1。
 * <p>
 * 数据范围
 * <p>
 * 1≤N≤1051≤N≤105,
 * −109≤ai≤bi≤109−109≤ai≤bi≤109,
 * −109≤s≤t≤109−109≤s≤t≤109
 * <p>
 * 输入样例：
 * <p>
 * 1 5
 * 3
 * -1 3
 * 2 4
 * 3 5
 * 输出样例：
 * <p>
 * 2
 * 算法思想：
 * <p>
 * 1、排序左端点
 * <p>
 * 2、找到包含左端点的最大右端点值s（滑动窗口来做）
 * <p>
 * 3、更新给定要求的左端点值为s
 * <p>
 * 3、更新下次开始扫描的下标为滑动窗口的最后访问下标
 * @Author : zph
 * @Date: 2020-09-28 00:31
 * @Version : V1.0
 */
public class Solution {

    static int N = 100010;
    static int s = 0, t = 0, n = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String[] res = buf.readLine().split(" ");
        s = Integer.valueOf(res[0]);
        t = Integer.valueOf(res[1]);
        n = Integer.valueOf(buf.readLine());
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; ++i) {
            String[] info = buf.readLine().split(" ");
            int a = Integer.valueOf(info[0]);
            int b = Integer.valueOf(info[1]);
            nums[i][0] = a;
            nums[i][1] = b;
        }
        Arrays.sort(nums, (a, b) -> a[0] - b[0]);
        boolean success = false;//防止区间都不包含左端点
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            int j = i, r = -0x3f3f3f3f;
            while (j < n && nums[j][0] <= s) {
                r = Math.max(r, nums[j][1]);
                j++;
            }
            if (r < s) {//枚举区间的左端点小于给定的左端点
                cnt = -1;
                break;
            }
            cnt++;//区间可用
            if (r >= t) {//达到区间右端点满足情况
                success = true;
                break;
            }
            s = r;//更新区间左端点
            i = j - 1;//跳转到最后满足左端点的位置，之后会i+1到达新的位置，实质上还是i从j位置开始
        }
        if (!success) cnt = -1;
        System.out.print(cnt);
    }


}


