package 数组.两个数组的交集.q350两个数组的交集II.f2;

import java.util.Arrays;

/**
 * @ClassName : Solution
 * @Description :350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * @Author : zph
 * @Date: 2020-07-13 23:32
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return int[]
     * @Title intersect
     * @Description 排序
     * @Author zph
     * @Date 2020/7/14 0:12
     * @Param [nums1, nums2]
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1=nums1.length;
        int length2=nums2.length;
        int[] res=new int[Math.min(length1,length2)];
        int index=0;
        int index1=0;
        int index2=0;
        while (index1<length1&&index2<length2){
            if(nums1[index1]<nums2[index2]){
                index1++;
            }else if(nums1[index1]>nums2[index2]){
                index2++;

            }else {
                res[index]=nums1[index1];
                index++;
                index1++;
                index2++;
            }
        }



        return Arrays.copyOfRange(res,0,index);

    }

    public static void main(String[] args) {
        int[] nums1 ={4,9,5};
        int[] nums2 = {9,4,9,8,4};
        Solution solution = new Solution();
        int[] intersect = solution.intersect(nums1, nums2);
        System.out.println(intersect);


    }


}
