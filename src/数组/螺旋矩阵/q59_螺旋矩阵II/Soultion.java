package 数组.螺旋矩阵.q59_螺旋矩阵II;

/**
 * @ClassName : Soultion
 * @Description :59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * @Author : zph
 * @Date: 2020-10-06 18:48
 * @Version : V1.0
 */
public class Soultion {

    /**
     * @return int[][]
     * @Title generateMatrix
     * @Description 按层模拟
     * @Author zph
     * @Date 2020/10/6 18:51
     * @Param [n]
     */
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int numEle = 1;
        int total = n * n;
        while (numEle <= total) {
            for (int i = left; i <= right; i++) {
                nums[top][i] = numEle++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                nums[i][right] = numEle++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                nums[bottom][i] = numEle++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                nums[i][left] = numEle++;
            }
            left++;
        }
        return nums;
    }
}
