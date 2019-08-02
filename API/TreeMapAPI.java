import apple.laf.JRSUIUtils;

import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
import java.util.TreeMap;

public class TreeMapAPI {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap();

        TreeMap<Integer, Integer> treeMap2 = new TreeMap(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        treeMap.put(0,10);
        treeMap.put(1,11);
        treeMap.put(2,12);
        treeMap.put(3,13);
        treeMap.put(4,14);
        treeMap.put(5,15);
        treeMap.put(6,16);
        treeMap.put(7,17);
        treeMap.put(8,18);
        treeMap.put(9,19);

        System.out.println("treeMap:"+treeMap);
        System.out.println("size:"+treeMap.size());
        System.out.println("containKey 1: "+treeMap.containsKey(1));
        System.out.println("containKey 1: "+treeMap.containsValue(1));

        //第一个数
        System.out.println("firstKey: "+treeMap.firstKey());
        System.out.println("firstEntry:"+treeMap.firstEntry());
        //最后一个数
        System.out.println("lastKey:"+treeMap.lastKey());
        System.out.println("lastEntry:"+ treeMap.lastEntry());

        System.out.println("ceilingKey 13:"+ treeMap.ceilingKey(13));
        System.out.println("ceilingKey -1:"+ treeMap.ceilingKey(-1));

    }

//    public static void iterarorByKey(TreeMap<Integer,Integer> ) {
//
//    }

    public static void fun2() {

    }
}
