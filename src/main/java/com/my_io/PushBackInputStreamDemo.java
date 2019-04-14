package com.my_io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * Created by root on 2019/4/14.
 * 回退流操作
 */
public class PushBackInputStreamDemo {

    public static void main(String[] args) throws IOException {
        String str = "hello,bxl,love";
        PushbackInputStream push = null; // 声明回退流对象
        ByteArrayInputStream bat = null; // 声明字节数组流对象
        bat = new ByteArrayInputStream(str.getBytes());
        push = new PushbackInputStream(bat); // 创建回退流对象，将拆解的字节数组流传入
        StringBuffer res = new StringBuffer();
        int temp = 0;
        //将,替换@
        while ((temp = push.read()) != -1) { // push.read()逐字节读取存放在temp中，如果读取完成返回-1
            if (temp == ',') { // 判断读取的是否是逗号
                push.unread(temp); //回到temp的位置
                res.append("@");
                push.read();
            } else {
                res.append((char)temp);
            }
        }
        System.out.println(res.toString());
        push.close();
        bat.close();
    }
}
