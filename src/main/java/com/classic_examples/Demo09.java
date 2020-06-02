package com.classic_examples;

/**
 * Created by root on 2019/11/10.
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
    不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
    元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

    给定 nums = [3,2,2,3], val = 3,
    函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 */
public class Demo09 {


    //myself 双指针
    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    //官方版  优化版双指针(头尾调换)
    public static int removeElementTwo(int[] nums, int val) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i]==val){
                nums[i] = nums[n-1];
                i--;
                n--;
            }
        }
        return n;
    }



    public static void main(String[] args){
        int[] i = {2,3,3,6,7,3};
        System.out.println("res:"+removeElementTwo(i,3));
        for (int i1 = 0; i1 < 5; i1++) {
            System.out.println(i[i1]);
        }
    }

}
