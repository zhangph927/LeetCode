package 二分法.搜索二维矩阵.q240_搜索二维矩阵II.f1;

/**
 * @ClassName : Solution
 * @Description :240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * @Author : zph
 * @Date: 2020-10-15 23:48
 * @Version : V1.0
 */
public class Solution {


    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0||matrix[0].length==0) {
            return false;
        }
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            if (matrix[i][0] > target) {
                break;
            }
            if (matrix[i][matrix[0].length - 1] < target) {
                continue;
            }
            int num = binarySearch(matrix[i], target);
            if (num != -1) {
                return true;
            }
        }
        return false;
    }

    private int binarySearch(int[] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (target == matrix[left]) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        Solution solution = new Solution();

        boolean b = solution.searchMatrix(matrix, 100);
        System.out.println(b);


    }


}
