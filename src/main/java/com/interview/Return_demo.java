package com.interview;

/**
 * Created by root on 2019/6/19.
 */
public class Return_demo {


    public static String testReturn(){
        String str = "";
        try{
            str = "aaa";
            System.out.println(str);
            //int a = 1/0;
            return str;
        }catch (Exception e){
            str = "bbb";
            System.out.println(str);
            return str;
        }finally {
            str = "yyy";
            System.out.println(str);

        }

    }





    public static void main(String[] args){

        String s = testReturn();
        System.out.println("===:"+s);

    }


}
