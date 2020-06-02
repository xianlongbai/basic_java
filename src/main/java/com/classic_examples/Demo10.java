package com.classic_examples;

/**
 * Created by root on 2019/11/13.
 *
 * 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
   你可以假设数组中无重复元素。
 */
public class Demo10 {


    public static int searchInsert(int[] nums, int target) {
        int index = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (target>nums[n-1]){
                index = n;
            } else if (nums[i]!=target && nums[i]>target){
                index = i;
                break;
            } else {
                if (nums[i]==target){
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    //优雅版
    public static int searchInsertTwo(int[] nums, int target) {
        for(int i = 0; i < nums.length;i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }

    //官方  二分查找(普通版)
    public static int searchInsertThree(int[] nums, int target) {
        int len = nums.length;
        if (nums[len - 1] < target) {
            return len;
        }
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            // 等于的情况最简单，我们应该放在第 1 个分支进行判断
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // 题目要我们返回大于或者等于目标值的第 1 个数的索引
                // 此时 mid 一定不是所求的左边界，
                // 此时左边界更新为 mid + 1
                left = mid + 1;
            } else {
                // 既然不会等于，此时 nums[mid] > target
                // mid 也一定不是所求的右边界
                // 此时右边界更新为 mid - 1
                right = mid - 1;
            }
        }
        // 注意：一定得返回左边界 left，返回右边界 right 提交代码不会通过
        // 理由是对于 [1,3,5,6]，target = 2，返回大于等于 target 的第 1 个数的索引，此时应该返回 1
        // 在上面的 while (left <= right) 退出循环以后，right < left，right = 0 ，left = 1
        // 根据题意应该返回 left，如果题目要求你返回小于等于 target 的所有数里最大的那个索引值，应该返回 right
        return left;
    }


    //官方  二分法（模板一）
    public static int searchInsertFore(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int left = 0;
        int right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    //官方  二分法（模板二）
    public int searchInsertFive(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return -1;
        if (nums[len - 1] < target) return len;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // nums[mid] 的值可以舍弃
                left = mid + 1;
            } else {
                // nums[mid] 不能舍弃
                right = mid;
            }
        }
        return right;
    }


    //myself01
    //1、如果分支的逻辑，在选择左边界的时候，不能排除中位数，那么中位数就选“右中位数”，只有这样区间才会收缩，否则进入死循环；
    //2、同理，如果分支的逻辑，在选择右边界的时候，不能排除中位数，那么中位数就选“左中位数”，只有这样区间才会收缩，否则进入死循环。
    public static int searchInsertSex(int[] nums, int target) {
        int len = nums.length;
        if (len==0) return 0;
        int left = 0;
        int right = len;
        while (left<right){
            int mid = left + (right-left)/2;
            if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


    //myself02
    public static int searchInsertServen(int[] nums, int target) {
        int len = nums.length;
        if (len==0) return 0;
        if (nums[len-1] < target) return len;
        int left = 0;
        int right = len-1;
        while (left<right){
            int mid = left + (right-left)/2;
            if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }




    public static void main(String[] args){
        int[] nums = {0,2,3,4,5,7};
        System.out.println(searchInsertServen(nums,1));
    }

}
