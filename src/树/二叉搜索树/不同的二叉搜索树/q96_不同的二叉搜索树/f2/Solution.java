package 树.二叉搜索树.不同的二叉搜索树.q96_不同的二叉搜索树.f2;

/**
 * @ClassName : Solution
 * @Description :96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * @Author : zph
 * @Date: 2020-07-15 22:43
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title numTrees
     * @Description 数学法
     *事实上我们在方法一中推导出的 G(n)G(n)函数的值在数学上被称为卡塔兰数 C_nC
     * n
     * ​
     *  。卡塔兰数更便于计算的定义如下:
     *
     * C_0 = 1, \qquad C_{n+1} = \frac{2(2n+1)}{n+2}C_n
     * C
     * 0
     * ​
     *  =1,C
     * n+1
     * ​
     *  =
     * n+2
     * 2(2n+1)
     * ​
     *  C
     * n
     * @Author zph
     * @Date 2020/7/15 22:59
     * @Param [n]
     * @return int
     */
    public int numTrees(int n) {
       long c=1;
       for(int i=0;i<n;i++){
           c=c*2*(2*i+1)/(i+2);

       }
       return (int)c;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.numTrees(3);
        System.out.println(i);
    }
}
