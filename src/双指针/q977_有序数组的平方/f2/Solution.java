package 双指针.q977_有序数组的平方.f2;

import java.util.Arrays;

/**
 * @ClassName : Solution
 * @Description :977. 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 * @Author : zph
 * @Date: 2020-10-17 15:14
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title sortedSquares
     * @Description 双指针
     * @Author zph
     * @Date 2020/10/17 15:30
     * @Param [A]
     * @return int[]
     */
    public int[] sortedSquares(int[] A) {
        if(A==null||A.length==0){
            return A;
        }
        int length=A.length;
        int negative=-1;
        for(int i=0;i<length;i++){
            if(A[i]<0){
                negative=i;
            }else {
                break;
            }
        }
        int[] res=new int[length];
        int i=negative;
        int j=negative+1;
        int index=0;
        while (i>=0||j<length){
            if(i<0){
                res[index]=A[j]*A[j];
                j++;
            }else if(j==length){
                res[index]=A[i]*A[i];
                i--;
            }else if(A[i]*A[i]<A[j]*A[j]){
                res[index]=A[i]*A[i];
                i--;
            }else {
                res[index]=A[j]*A[j];
                j++;
            }
            index++;

        }
        return res;






    }


}
