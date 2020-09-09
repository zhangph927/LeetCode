package 堆相关.q215_数组中的第K个最大元素.f2;

import java.util.PriorityQueue;
import java.util.Queue;
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
     * @Description java API priorityQueue
     * @Author zph
     * @Date 2020/7/26 11:14
     * @Param [nums, k]
     * @return int
     */
    public int findKthLargest(int[] nums, int k) {
        int length=nums.length;
        if(k<length-k){
            //小顶堆
            Queue<Integer> queue= new PriorityQueue<Integer>(k,(a, b)->a-b);
            for(int i=0;i<k;i++){
                queue.offer(nums[i]);
            }
            for(int i=k;i<length;i++){
               int top= queue.peek();
               if(nums[i]>top){
                   queue.poll();
                   queue.offer(nums[i]);
               }
            }
            return queue.peek();
        }else {
            //大顶堆
            int size=length-k+1;
            Queue<Integer> queue= new PriorityQueue<Integer>(size,(a, b)->b-a);
            for(int i=0;i<size;i++){
                queue.offer(nums[i]);
            }
            for(int i=size;i<length;i++){
                int top= queue.peek();
                if(nums[i]<top){
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
            return queue.peek();
        }


    }


    public static void main(String[] args) {

        Solution solution = new Solution();
       int[] nums= {3,2,1,5,6,4};
       int k = 2;

        int kthLargest = solution.findKthLargest(nums, k);
        System.out.println(kthLargest);
    }
}
