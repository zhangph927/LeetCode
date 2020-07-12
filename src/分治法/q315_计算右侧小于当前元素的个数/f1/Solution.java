package 分治法.q315_计算右侧小于当前元素的个数.f1;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :315. 计算右侧小于当前元素的个数
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 * 示例:
 *
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 * @Author : zph
 * @Date: 2020-07-11 23:09
 * @Version : V1.0
 */
public class Solution {
    int[] temp;
    int[] counter;
    /**
     * 数组索引
     */
    int[] index;
    /**
     * @Title countSmaller
     * @Description 归并排序+索引数组
     * @Author zph
     * @Date 2020/7/11 23:10
     * @Param [nums]
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums==null||nums.length==0){
            return res;
        }
        int length=nums.length;
        temp=new int[length];
        counter=new int[length];
        index=new int[length];

        for(int i=0;i<length;i++){
            index[i]=i;
        }
        mergeAndCountSmaller(nums,0,length-1);
        for (int i=0;i<length;i++){
            res.add(counter[i]);
        }
        return res;

        
    }
    /**
     * @Title mergeAndCountSmaller
     * @Description 归并排序
     * @Author zph
     * @Date 2020/7/11 23:21
     * @Param [nums, left, right]
     * @return void
     */
    private void mergeAndCountSmaller(int[] nums,int left,int right){
        if(left==right){
            return;
        }
        int mid=left+(right-left)/2;
        mergeAndCountSmaller(nums,left,mid);
        mergeAndCountSmaller(nums,mid+1,right);
        if(nums[index[mid]]>nums[index[mid+1]]){
            mergeOfTwoSortArrayCountSmaller(nums,left,mid,right);
        }


    }

    /**
     * @Title mergeOfTwoSortArrayCountSmaller
     * @Description 合并两个数组
     * @Author zph
     * @Date 2020/7/11 23:26
     * @Param []
     * @return void
     */
    private void mergeOfTwoSortArrayCountSmaller(int[] nums,int left,int mid,int right){

        //System.arraycopy(index,left,temp,left,right-left+1);
        for (int i = left; i <= right; i++) {
            temp[i] = index[i];
        }
        int i=left;
        int j=mid+1;
        for(int k=left;k<=right;k++){
            if(i>mid){
                index[k]=temp[j];
                j++;
            }else if(j==right+1){
                index[k]=temp[i];
                i++;
                counter[index[k]]+=(right-mid);
            }else if(nums[temp[i]]<=nums[temp[j]]){
                index[k]=temp[i];
                i++;
                counter[index[k]]+=(j-mid-1);
            }else {
                index[k]=temp[j];
                j++;
            }


        }


    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 6, 1};
        Solution solution = new Solution();
        List<Integer> countSmaller = solution.countSmaller(nums);
        System.out.println(countSmaller);
    }


}
