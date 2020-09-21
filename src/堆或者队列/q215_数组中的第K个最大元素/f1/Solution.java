package 堆或者队列.q215_数组中的第K个最大元素.f1;

import java.util.Random;

/**
 * @ClassName : Solution
 * @Description :215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * @Author : zph
 * @Date: 2020-07-25 23:24
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title findKthLargest
     * @Description 快速排序
     * @Author zph
     * @Date 2020/7/26 11:14
     * @Param [nums, k]
     * @return int
     */
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums,k);
    }

    private int quickSort(int[] nums,int k){
        int left=0;
        int length=nums.length;
        int right=length-1;
        int target=length-k;
        while (true){
            int index=partition(nums,left,right);
            if(index==target){
                return nums[index];
            } else if(index>target){
                right=index-1;
            }else {
                left=index+1;
            }

        }
    }


    private Random random=new Random();
    private int partition(int[] nums,int left,int right){
        int randomIndex=left+random.nextInt(right-left+1);
        swap(nums,left,randomIndex);
        int lt=left+1;
        int gt=right;
        int pivot=nums[left];
        while (true){
            while (lt<=right&&nums[lt]<pivot){
                lt++;
            }
            while(gt>left&&nums[gt]>pivot){
                gt--;
            }
            if(lt>=gt){
                break;
            }
            swap(nums,lt,gt);
            lt++;
            gt--;
        }
        swap(nums,left,gt);
        return gt;

    }


    private void swap(int[] nums,int left,int right){
        int target=nums[left];
        nums[left]=nums[right];
        nums[right]=target;
    }


    public static void main(String[] args) {

        Solution solution = new Solution();
       int[] nums= {3,2,1,5,6,4};
       int k = 2;

        int kthLargest = solution.findKthLargest(nums, k);
        System.out.println(kthLargest);
    }
}
