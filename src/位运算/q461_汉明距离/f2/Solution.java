package 位运算.q461_汉明距离.f2;

/**
 * @ClassName : Solution
 * @Description :461. 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 * @Author : zph
 * @Date: 2020-10-19 23:17
 * @Version : V1.0
 */
public class Solution {

    public int hammingDistance(int x, int y) {
        int xor=x^y;
        int distant=0;
        while (xor!=0){
            if(xor%2==1){
                distant++;
            }
            xor=xor>>1;
        }
        return distant;
    }

}
