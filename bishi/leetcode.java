/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/7/21
 */

// 本题为考试多行输入输出规范示例，无需提交，不计分。

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class leetcode {
    public static void main(String[] args) {
        fun1();
//        fun2();
//        fun3();
//        fun4();
//        fun5();
//        fun6();
//        String num = "10200";
//        int k = 1;
//        char[] str = num.toCharArray();
//        for(int i=1,f=0; i<str.length && f<k; i++){
////            if(Integer.parseInt(num.substring(i,i+1)) <= Integer.parseInt(num.substring(i-1,i))){
//            if(Character.digit(str[i],10) <= Character.digit(str[i-1],10)){
//                str[i-1] = '-';
//                f++;
//            }
//        }
//
//        StringBuilder res = new StringBuilder();
//        int temp = 0;
//        boolean flag = false;
//        for(int i=0; i< str.length;i++){
//            if(flag && str[i] != '0' && str[i]!='-'){
//                System.out.println(i);
//                res.replace(i,i+1,"");
//            }
//        }
//
//        System.out.println(res);

//        int[] A = new int[]{5,7,3,9,4,9,8,3,1};
//        System.out.println(largestUniqueNumber(A));
//        System.out.println(isArmstrong(153));

    }

    public static void fun1() {

    }

    public static void fun2() {

    }

    public static class IdAscendingComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }

    }

    public static int largestUniqueNumber(int[] A) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<Integer, Integer>();

        for(int i=0; i<A.length;i++){
            if(treeMap.containsKey(A[i])){
                treeMap.put(A[i], treeMap.get(A[i]+1));
            }else{
                treeMap.put(A[i], 1);
            }
        }

        int value = 0;
        int key = 0;
//        Iterator iter = treeMap.entrySet().iterator();
        for (Map.Entry<Integer,Integer> entry: treeMap.entrySet()) {
            // 获取key
            key = (int)entry.getKey();
            // 获取value
            value = (int)entry.getValue();
            if(value == 1) {
                return key;
            }
        }
        return -1;
    }

//    public static int largestUniqueNumber(int[] A) {
//        HashMap<Integer,Integer> treeMap = new HashMap<>();
//
//        for(int i=0; i<A.length;i++){
//            if(treeMap.containsKey(A[i])){
//                treeMap.put(A[i], treeMap.get(A[i])+1);
//            }else{
//                treeMap.put(A[i], 1);
//            }
//        }
//
//        int value = 0;
//        int key = 0;
//        int max = -1;
//        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
//            key = entry.getKey();
//            value = entry.getValue();
//            if(value == 1 && max < key) {
//                max = key;
//            }
//        }
//        return max;
//    }

    public static boolean isArmstrong(int N) {
        int k=0;
        int n =N;
        while(n > 0){
            k++;
            n = n/10;
        }

        n=N;
        int sum=0;
        while(n>0){
            int temp = n%10;
            n = n/10;
            temp = (int)Math.pow(temp, k);
            sum += temp;
        }

        if(sum == N) {
            return true;
        }
        return false;

    }



}
