package 数组操作.q74_搜索二维矩阵;

/**
 * @ClassName : Solution
 * @Description :74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * @Author : zph
 * @Date: 2020-07-20 23:45
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return boolean
     * @Title searchMatrix
     * @Description 二分查找
     * @Author zph
     * @Date 2020/7/20 23:45
     * @Param [matrix, target]
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0||matrix[0].length==0) {
            return false;

        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;


        while (left < right) {
            int mid = left + (right - left) / 2;
            int element = matrix[mid / n][mid % n];
            if (element < target) {
                left = mid+1 ;
            } else {
                right = mid;
            }
        }
        if (matrix[left / n][left % n] == target) {
            return true;

        }
        return false;
    }
}
