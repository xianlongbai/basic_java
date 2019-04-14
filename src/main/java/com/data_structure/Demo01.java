package com.data_structure;

import java.util.*;

/**
 * Created by root on 2019/3/24.
 * 两数之和（易）：
     给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     示例:
         给定 nums = [2, 7, 11, 15], target = 9
         因为 nums[0] + nums[1] = 2 + 7 = 9
         所以返回 [0, 1]
 */
public class Demo01 {

    //暴力法  时间O(n^2)  空间O(1)
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int u=i+1;u<nums.length;u++){
                if((nums[i]+nums[u])==target){
                    res[0] = i;
                    res[1] = u;
                }
            }
        }
        return res;
    }

    //两遍哈希表  时间O(n)  空间O(n)
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //一遍哈希表  时间O(n)  空间O(n)
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] ages){
        Demo01 s = new Demo01();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
//        int[] res = s.twoSum(nums,target);
//        int[] res = s.twoSum2(nums,target);
//        int[] res = s.twoSum3(nums,target);
//        System.out.println("结果：["+res[0]+","+res[1]+"]");

    }
}
