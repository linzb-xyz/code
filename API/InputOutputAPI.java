import java.util.ArrayList;
import java.util.Scanner;

/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/7/28
 */

public class InputOutputAPI {

    public static void main(String[] args){

    }

    //常规输入:先输入两个数,在输入两行数 分别存在两个数组中
    public static void normalInput(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] arr1 = new int[n];
        for(int i = 0 ;i < n;i++) {
            arr1[i] = in.nextInt();
        }

        int[] arr2 = new int[m];
        for(int i = 0 ;i < m;i++) {
            arr2[i] = in.nextInt();
        }
    }

    //输入两行数,代表两个数组
    public static void input(){
        ArrayList<Integer> arr1 = new ArrayList() ;
        ArrayList<Integer> arr2 = new ArrayList() ;

        Scanner in = new Scanner(System.in);

        String line1 = in.nextLine();
        Scanner in1 = new Scanner(line1);
        while(in1.hasNextInt()){
            arr1.add(in1.nextInt());
        }

        String line2 = in.nextLine();
        Scanner in2 = new Scanner(line2);
        while(in2.hasNextInt()){
            arr2.add(in2.nextInt());
        }
    }

}

