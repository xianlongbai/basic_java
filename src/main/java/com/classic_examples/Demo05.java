package com.classic_examples;

/**
 * Created by root on 2019/11/5.
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class Demo05 {


    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int x = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[x]!=nums[i]){
                x++;
                nums[x] = nums[i];
            }
        }
        return x;
    }


    public static void main(String[] args){
        int[] nums= {1,2,2,3,3,5};
        System.out.println(removeDuplicates(nums));
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
