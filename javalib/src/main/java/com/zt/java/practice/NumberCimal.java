package com.zt.java.practice;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class NumberCimal {
    public static void main(String[] args){
        cimalTransfer(316,17);//316转17进制
    }

    /**
     * 进制转换，大于等于10的用A，B,C,D,表示如A表示10，G表示16.
     *
     * @param number 转换的10进制数
     * @param size   转换的进制
     */
    public static void cimalTransfer(int number, int size) {
        if (number < size) {
            if (number >= 10) {
                System.out.println((char) (number + 55));
            } else {
                System.out.println(number);
            }
        } else {
            int a = number % size;
            int b = number / size;
            if (a >= 10) {
                System.out.println((char) (a + 55));//大于10的用字母表示
            } else {
                System.out.println(a);
            }
            cimalTransfer(b, size);
        }
    }
}
