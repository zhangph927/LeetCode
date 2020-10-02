package 贪心.四类区间问题.AcWing905_区间选点;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @ClassName : Solution
 * @Description :给定N个闭区间[ai,biai,bi]，请你在数轴上选择尽量少的点，使得每个区间内至少包含一个选出的点。
 *
 * 输出选择的点的最小数量。
 *
 * 位于区间端点上的点也算作区间内。
 *
 * 输入格式
 *
 * 第一行包含整数N，表示区间数。
 *
 * 接下来N行，每行包含两个整数ai,biai,bi，表示一个区间的两个端点。
 *
 * 输出格式
 *
 * 输出一个整数，表示所需的点的最小数量。
 *
 * 数据范围
 *
 * 1≤N≤1051≤N≤105,
 * −109≤ai≤bi≤109−109≤ai≤bi≤109
 *
 * 输入样例：
 *
 * 3
 * -1 1
 * 2 4
 * 3 5
 * 输出样例：
 *
 * 2
 *  思路： 按区间右端点从小到大排序
 *
 *              然后枚举每个区间，如果当前区间包含点，直接pass
 *
 *              否则，选择当前区间的右端点
 * @Author : zph
 * @Date: 2020-09-28 00:29
 * @Version : V1.0
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Range range[] = new Range[n];
        for (int i = 0; i < n; i++) {
            range[i] = new Range(scan.nextInt(), scan.nextInt());
        }
        Arrays.sort(range, 0, n, new cmp());
        int e = (int) -2e9, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (range[i].l > e) {
                e = range[i].r;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

class Range {
    int l, r;

    public Range(int l, int r) {
        this.l = l;
        this.r = r;
    }
}

class cmp implements Comparator<Range> {
    @Override
    public int compare(Range o1, Range o2) {
        if (o1.r > o2.r) return 1;
        else return -1;
    }

}
