package com.interview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by root on 2019/6/19.
 */
public class Exception_test {


    public static void main(String[] args){

        try {
            FileInputStream fis = new FileInputStream("G:\\技术文档编写（myself）\\配置Nginx服务.txt");
            int a = 1/0;
        } catch (FileNotFoundException e ) {
            System.out.println(1111);
        } catch (RuntimeException e){
            System.out.println(2222);
        } catch (Exception e){
            System.out.println(3333);
        }


    }



}
