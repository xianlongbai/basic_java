package com.classic_examples;

/**
 * Created by root on 2019/11/14.
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *  输入: nums = [-1,0,3,5,9,12], target = 9
    输出: 4
    解释: 9 出现在 nums 中并且下标为 4

     输入: nums = [-1,0,3,5,9,12], target = 2
     输出: -1
     解释: 2 不存在 nums 中因此返回 -1
 */
public class Demo11 {

    public static int searchOne(int[] nums, int target) {
        int len = nums.length;
        if (len==0 || nums[len-1]<target || nums[0]>target) return -1;
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = left + (right-left)/2;
            if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static int searchTwo(int[] nums, int target) {
        if (nums.length==0) return -1;
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = left + (right-left)/2;
            if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (left<=nums.length-1 && nums[left]==target) ? left : -1;
    }

    //官方:递归
    public static int searchThree(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private static int search(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return search(nums, l, mid - 1, target);
        } else {
            return search(nums, mid + 1, r, target);
        }
    }



    public static void main(String[] args){
        int[] nums = {2,5};
        System.out.println(searchTwo(nums,-1));
    }
}
