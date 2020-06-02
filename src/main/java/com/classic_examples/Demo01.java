package com.classic_examples;

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

    /**
     * Created by root on 2019/9/25.
     *
     * 不好意思，昨晚电脑没电了，今早做了一下，抱歉~
     *
     *
     *
     *
     1、将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

     2、给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。
     需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。

     3、如何100万个数找出最大的100个数（伪代码或者思路），并列出对应的时间、空间复杂度。
     *
     *  先取出100数作为一个数组进行排序，然后用数组中最小值和其它的数做比较，如果大于数组最小值，就替换掉，
     *  然后重新排序数组，然后再开始新的一轮比较
     *
     *
     */
    public static class Test {

        public static void main(String[] args){

    //        List<Integer> a = new ArrayList();
    //        List<Integer> b = new ArrayList();
    //        a.add(1);a.add(6);a.add(9);
    //        b.add(3);b.add(5);a.add(8);
    //        List<Integer> c  = new ArrayList();
    //        int i=0; int j=0;
    //        while(i<a.size() && j<b.size()){
    //            if(a.get(i)<=b.get(j)){
    //                c.add(a.get(i));
    //                i++;
    //            }else{
    //                c.add(b.get(j));
    //                j++;
    //            }
    //        }
    //        while(i<a.size()){
    //            c.add(a.get(i));
    //            i++;
    //        }
    //        while(j<b.size()){
    //            c.add(b.get(j));
    //            j++;
    //        }
    //        System.out.println(c);

            String str="jaaaaaiogmeadga";

            char [] array =str.toCharArray();
            List<Character> res = new ArrayList();
            res.add(array[0]);

            for (int i = 1; i < array.length; i++) {
                if (!res.contains(array[i])){
                    res.add(array[i]);
                }
            }

            System.out.println(Arrays.toString(res.toArray()));

        }

    }
}
