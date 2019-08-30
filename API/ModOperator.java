import java.math.BigInteger;

/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/8/5
 */
/*
对大数取余操作!
 */
public class ModOperator {
    public static void main(String[] args) {

        fun1();
        fun2();
        fun3();
        fun4();

    }

    /*
    幂乘操作取余
    a^b mod c = (a mod c)^b mod c
     */
    public static void fun0(){
	    int x = 100003, y =23456;
	    System.out.println(Math.pow(x,3)%y);
	    System.out.println();
    }

    /*
     (x+y)mod k = ((x mod k) + (y mod k)) mod k
     */
    public static void fun1(){
        int x = 100003, y =23456;
        System.out.println((x%7+y%7)%7);
        System.out.println((x+y)%7);
    }


    /*
    //乘法容易溢出
     (x*y)mod k = ((x mod k) * (y mod k)) mod k
     */
    public static void fun2(){
        long x = 100003, y =23456;
        System.out.println(((x%7) * (y%7))%7);
        System.out.println((x*y)%7);
    }

    /*
   //BigInteger
     (x+y)mod k = ((x mod k) + (y mod k)) mod k
    */
    public static void fun3(){
        BigInteger x = new BigInteger("100003"), y = new BigInteger("23456"), k = new BigInteger("7");
        BigInteger z = x.mod(k);
        System.out.println(x.mod(k).add(y.mod(k)).mod(k));
        System.out.println(x.add(y).mod(k));
    }

    /*
   //BigInteger
     (x+y)mod k = ((x mod k) + (y mod k)) mod k
    */
    public static void fun4(){
        BigInteger x = new BigInteger("100003"), y = new BigInteger("23456"), k = new BigInteger("7");
        BigInteger z = x.mod(k);
        System.out.println(x.mod(k).multiply(y.mod(k)).mod(k));
        System.out.println(x.multiply(y).mod(k));
    }
}
