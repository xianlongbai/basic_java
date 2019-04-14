package com.my_io;

import java.io.*;

/**
 * Created by root on 2019/4/14.
 *  C:\Users\16050\Desktop\bbb\test.txt
 */
public class RandomAccessFileDemo {

    public static void main(String[] args) {
        args = new String[3];
        args[0] = "C:\\Users\\16050\\Desktop\\bbb\\test.txt";
        args[1] = "5";
        args[2] = "无敌";
        if (args == null || args.length != 3) {
            throw new RuntimeException("请分别输入操作文件、插入位置和插入内容");
        }
        FileInputStream fis = null;
        FileOutputStream fos = null;
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(args[0], "rw");
            File tmp = File.createTempFile("tmp", null);
            tmp.deleteOnExit();
            fis = new FileInputStream(tmp);
            fos = new FileOutputStream(tmp);
            raf.seek(Long.parseLong(args[1]));
            byte[] bbuf = new byte[64];
            int hasRead = 0;
            while ((hasRead = raf.read(bbuf)) > 0) {
                fos.write(bbuf, 0, hasRead);
            }
            raf.seek(Long.parseLong(args[1]));
            raf.write("\n插入内容:\n".getBytes());
            raf.write((args[2] + "\n").getBytes());
            while ((hasRead = fis.read(bbuf)) > 0) {
                raf.write(bbuf, 0, hasRead);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
                if (raf != null) {
                    raf.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
