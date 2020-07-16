package 双指针.q986_区间列表的交集;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :986. 区间列表的交集
 * 给定两个由一些 闭区间 组成的列表，每个区间列表都是成对不相交的，并且已经排序。
 *
 * 返回这两个区间列表的交集。
 *
 * （形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b。两个闭区间的交集是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3]。）
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 *
 *
 * 提示：
 *
 * 0 <= A.length < 1000
 * 0 <= B.length < 1000
 * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 * @Author : zph
 * @Date: 2020-07-14 22:54
 * @Version : V1.0
 */
public class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        int len1=A.length;
        int len2=B.length;
        int i=0;
        int j=0;
        while (i<len1&&j<len2){
            int lo=Math.max(A[i][0],B[j][0]);
            int hi=Math.min(A[i][1],B[j][1]);
            if(lo<=hi){
                res.add(new int[]{lo,hi});
            }
            if(A[i][1]<B[j][1]){
                i++;
            }else {
                j++;
            }

        }
        return res.toArray(new int[res.size()][]);

    }
}
