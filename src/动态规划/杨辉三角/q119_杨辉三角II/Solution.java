package 动态规划.杨辉三角.q119_杨辉三角II;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * @Author : zph
 * @Date: 2020-07-12 23:47
 * @Version : V1.0
 */
public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();

        res.add(1);
        int pre=1;

        for(int i=1;i<=rowIndex;i++){
            for(int j=1;j<i;j++){
                int temp=res.get(j);
                res.set(j,pre+res.get(j));
                pre=temp;
            }
            res.add(1);
        }
        return res;


    }
}
