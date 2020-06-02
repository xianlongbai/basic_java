package com.classic_examples;

/**
 * Created by root on 2019/11/4.
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Demo03 {


    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int rec = 0;
        int z = x;
        while (z != 0){
            int y = z % 10;
            z /= 10;
            rec = rec * 10 + y;
        }
        return rec==x;
    }


    public static void main(String[] args){
        System.out.println(isPalindrome(10031));
    }

}
