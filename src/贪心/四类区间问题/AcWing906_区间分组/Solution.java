package 贪心.四类区间问题.AcWing906_区间分组;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @ClassName : Solution
 * @Description :给定N个闭区间，将这些区间分成若干组，使得每组内部的区间两两之间（包括端点）没有交集，并使得组数尽可能小。
 *
 * 输出最小组数。
 *
 * 实际问题：公司今天有20场会议，问最少用几个会议室可以安排下
 *
 * 算法思路：
 *
 * 将所有区间按照左端点从小到大排序
 *
 * 从前往后处理每个区间
 *
 * 判断能否将其放到某个现有的组中（小顶堆维护右端点（最早结束的区间））
 * @Author : zph
 * @Date: 2020-09-28 00:31
 * @Version : V1.0
 */
public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);
    static int N = 100010;
    static ArrayList<Pair> al = new ArrayList<>();
    static PriorityQueue<Integer> q = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            al.add(new Pair(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
        }
        Collections.sort(al);

        for (Pair p : al) {
            if (q.isEmpty() || q.peek() >= p.getFront()) q.offer(p.getSecond());
            else {
                q.poll();
                q.offer(p.getSecond());
            }
        }
        pw.println(q.size());
        pw.flush();
        pw.close();
        br.close();
    }
}

class Pair implements Comparable<Pair> {
    int front;
    int second;

    public Pair(int front, int second) {
        this.front = front;
        this.second = second;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public int compareTo(Pair o) {
        return front - o.getFront();
    }
}
