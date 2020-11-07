package 数组.两个数组的交集.q349_两个数组的交集.f2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName : Solution
 * @Description :349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * @Author : zph
 * @Date: 2020-07-13 23:17
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title intersection
     * @Description 排序 + 双指针
     * @Author zph
     * @Date 2020/11/4 9:43
     * @Param [nums1, nums2]
     * @return int[]
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1=nums1.length;
        int length2=nums2.length;

        int[] intersection=new int[length1+length2];
        int index=0;
        int index1=0;
        int index2=0;

        while (index1<length1&&index2<length2){
            int num1=nums1[index1];
            int num2=nums2[index2];
            if(num1==num2){
                if(index==0||num1!=intersection[index-1]){
                    intersection[index++]=num1;
                }
                index1++;
                index2++;
            }else if(num1>num2){
                index2++;
            }else {
                index1++;
            }
        }
        return Arrays.copyOfRange(intersection,0,index);

    }

}
