package com.classic_examples;

/**
 * Created by root on 2019/11/15.
 *
     1
     11
     21
     1211
     111221
 后一个数给前一个数报数
 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。注意：整数顺序将表示为一个字符串
 */
public class Demo13 {


    public static String countAndSay(int n) {
        StringBuilder ans = new StringBuilder();
        ans.append("1");
        for (int i = 2; i <= n ; i++) {
            //遍历前一个字符串
            String currentStr = new String(ans);
            ans.delete(0,ans.length());
            int num = 0;
            char currentChar = currentStr.charAt(0);
            for (char c : currentStr.toCharArray()) {
                if(c == currentChar){
                    num++;
                }
                else{
                    ans.append((char)('0'+num));
                    ans.append(currentChar);
                    currentChar = c;
                    num = 1;
                }
            }
            ans.append((char)('0'+num));
            ans.append(currentChar);
        }
        return ans.toString();
    }

    public static void main(String[] args){
        System.out.println(countAndSay(10));
    }

}
