package 二分法.q34_在排序数组中查找元素的第一个和最后一个位置;

public class Solution1 {

    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return new int[]{-1,-1};
        }

        int first = getFirstIndex(nums, target);
        if(first==-1){
            return new int[]{-1,-1};
        }
        int last = getLastIndex(nums, target);

        return new int[]{first,last};


    }

    private int getFirstIndex(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        if(target==nums[left]){
            return left;
        }
        return -1;

    }

    private int getLastIndex(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=left+(right-left+1)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else {
                left=mid;
            }
        }

        return left;

    }






}
