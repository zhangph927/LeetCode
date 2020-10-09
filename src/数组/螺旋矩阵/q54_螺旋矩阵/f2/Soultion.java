package 数组.螺旋矩阵.q54_螺旋矩阵.f2;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Soultion
 * @Description :54. 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * @Author : zph
 * @Date: 2020-10-06 18:08
 * @Version : V1.0
 */
public class Soultion {

    /**
     * @return java.util.List<java.lang.Integer>
     * @Title spiralOrder
     * @Description 按层模拟
     * @Author zph
     * @Date 2020/10/6 18:15
     * @Param [matrix]
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length==0||matrix[0].length==0){
            return result;
        }
        int left=0;
        int right=matrix[0].length-1;
        int top=0;
        int bottom=matrix.length-1;
        int numEle=matrix.length*matrix[0].length;
        while (numEle>=1){
            for(int i=left;i<=right&&numEle>=1;i++){
                result.add(matrix[top][i]);
                numEle--;
            }
            top++;
            for(int i=top;i<=bottom&&numEle>=1;i++){
                result.add(matrix[i][right]);
                numEle--;
            }
            right--;
            for(int i=right;i>=left&& numEle>=1;i--){
                result.add(matrix[bottom][i]);
                numEle--;
            }
            bottom--;
            for(int i=bottom;i>=top&&numEle>=1;i--){
                result.add(matrix[i][left]);
                numEle--;
            }
            left++;
        }
        return result;


    }


}
