package 贪心.四类区间问题.AcWing908_最大不相交区间数量;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName : Solution
 * @Description :这个题的思路和上一题的思路一样，就是包括不同的区间
 * @Author : zph
 * @Date: 2020-09-28 00:29
 * @Version : V1.0
 */
public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);
    static PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
        }
    });
    static int res = 1;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            int[] temp = {Integer.parseInt(s[0]), Integer.parseInt(s[1])};
            q.offer(temp);
        }
        while (!q.isEmpty()) {
            int[] now = q.poll();
            while (!q.isEmpty()) {
                int[] p = q.peek();
                if (p[0] > now[1]) {
                    res++;
                    break;
                } else q.poll();
            }
        }
        pw.println(res);
        pw.flush();
        pw.close();
        br.close();
    }
}
