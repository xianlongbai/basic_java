package com.classic_examples;

/**
 * Created by root on 2019/10/27.
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Demo02 {

    public static int reverse(int x) {
        String yStr = "";
        String xStr = String.valueOf(x);
        String pre = "";
        if (xStr.charAt(0)=='-'){
            xStr = xStr.substring(1);
            pre = "-";
        }
        for (int length = xStr.length(); length > 0; length--) {
            if (yStr!="" && yStr.charAt(0)=='0'){
                yStr = yStr.substring(1);
            }
            yStr += xStr.charAt(length-1);
        }
        try{
            return Integer.parseInt(pre + yStr,10);
        } catch (Exception e){
            return 0;
        }
    }

    public static int reverseTwo(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }


    public static void main(String[] args){
        //System.out.println(reverse(-153423600));
        System.out.println(reverseTwo(-153423600));
//        String pre = "";
//        int i = Integer.parseInt(pre+"1534236469");
//        System.out.println(i);
    }
}
