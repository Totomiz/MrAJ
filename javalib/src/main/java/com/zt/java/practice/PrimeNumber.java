package com.zt.java.practice;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 *
 */

public class PrimeNumber {

    public static void main(String[] args){
        //求100到200间的质数个数，或者具体数值(质数是指除了1和本身外再无其他因子）)
        primeNumber(100,200);
    }

    private static void primeNumber(int start,int end){
        int count=0;//质数个数
        for(int i=start;i<end;i++){
            boolean isPrimeNumber=true;
            for(int j=2;j<i;j++){
                if(i%j==0){//如果能有因子使余数为0，那么就不是质数
                    isPrimeNumber=false;
                    break;
                }
            }
            if(isPrimeNumber){
                System.out.println("prime number:"+i);
                count++;
            }
        }
        System.out.println("prime number count:"+count);
    }
}
