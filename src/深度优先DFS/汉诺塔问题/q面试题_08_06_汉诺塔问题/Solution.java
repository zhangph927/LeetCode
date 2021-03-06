package 深度优先DFS.汉诺塔问题.q面试题_08_06_汉诺塔问题;

import java.util.List;

/**
 * @ClassName : Solution
 * @Description :面试题 08.06. 汉诺塔问题
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 *
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 *
 * 你需要原地修改栈。
 *
 * 示例1:
 *
 *  输入：A = [2, 1, 0], B = [], C = []
 *  输出：C = [2, 1, 0]
 * 示例2:
 *
 *  输入：A = [1, 0], B = [], C = []
 *  输出：C = [1, 0]
 * 提示:
 *
 * A中盘子的数目不大于14个。
 * @Author : zph
 * @Date: 2020-08-27 19:54
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title hanota
     * @Description 回溯
     * 假设有n个盘子需要移动
     * 首先将最上面的n-1个盘子从A移到B柱子
     * 然后将最下面的一个盘子从A移到C柱子
     * 最后将n-1个盘子从B移到C柱子
     * 以上是汉诺塔的整体操作，其中移动n-1个盘子的操作是递归操作
     * @Author zph
     * @Date 2020/8/27 20:18
     * @Param [A, B, C]
     * @return void
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {

        move(A.size(),A,B,C);

    }

    private void move(int num,List<Integer> A, List<Integer> B, List<Integer> C){
        if(num==1){
            C.add(A.remove(A.size()-1));
            return;
        }
        move(num-1,A,C,B);
        C.add(A.remove(A.size()-1));
        move(num-1,B,A,C);
    }

}
