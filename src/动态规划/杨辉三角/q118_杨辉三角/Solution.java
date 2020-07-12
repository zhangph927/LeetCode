package 动态规划.杨辉三角.q118_杨辉三角;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * @Author : zph
 * @Date: 2020-07-12 23:36
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title generate
     * @Description 动态规划，没有用dp数组
     * @Author zph
     * @Date 2020/7/12 23:46
     * @Param [numRows]
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows==0){
            return res;
        }
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        for(int i=1;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> pre = res.get(i - 1);
            for(int j=1;j<i;j++){
                row.add(pre.get(j-1)+pre.get(j));
            }
            row.add(1);
            res.add(row);
        }
        return res;


    }
}
