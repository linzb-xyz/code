import java.util.*;

/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/7/29
 */

public class CollectionsAPI {
    /*
    addAll
    binarySearch
    copy
    disjoint
    fill
    frequency
    indexOfSubList
    max
    min
    nCopies
    replaceAll
    reverse
    reverseOrder
    rotate: 轮换列表
    shuffle: 随机排列
    sort
    swap

     */
    public static void main(String[] args) {
        addAllAPI();
        binarySearchAPI();
        copyAPI();
        disjointAPI();
        enumerationAPI();
        frequencyAPI();
        indexOfSubListAPI();
        reverseAPI();
        reverseOrderAPI();
    }

    public static void addAllAPI(){
        int[] num = new int[]{1,3,5,3,7,2,9,4,6};

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < num.length ; i++) {
            list.add(num[i]);
        }
        System.out.println(list);

        List<Integer> list1 = new LinkedList<>();
        list1.addAll(list);
        System.out.println(list1);

        List<Integer> list2 = new LinkedList<>();
        Collections.addAll(list2, 1,2,33,4,5);
        System.out.println(list2);
    }

    public static void binarySearchAPI(){
        int[] num = new int[]{1,3,5,3,7,2,9,4,6};

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < num.length ; i++) {
            list.add(num[i]);
        }
        System.out.println(list);

        Collections.sort(list);
        System.out.println("list = " + list);
        int pos = Collections.binarySearch(list, 13);
        System.out.println("13 pos = " + pos);
        pos = Collections.binarySearch(list, 3);
        System.out.println("3 pos = " + pos);
    }

    public static void copyAPI(){
        int[] num = new int[]{1,3,5,3,7,2,9,4,6};

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < num.length ; i++) {
            list.add(num[i]);
        }
        System.out.println("list = " + list);
        
        List<Integer> list1 = new ArrayList<>(list);
        Collections.fill(list1,1);
        System.out.println("list1 = " + list1);
        Collections.copy(list1,list);
        System.out.println("list1 = " + list1);
    }

    //判断交集: 没有相同元素返回 true
    public static void disjointAPI(){
        int[] num = new int[]{1,3,5,3,7,2,9,4,6};

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < num.length ; i++) {
            list.add(num[i]);
        }
        System.out.println("list = " + list);

        List<Integer> list1 = new ArrayList<>(list);
        Collections.fill(list1,11);
        System.out.println("list1 = " + list1);

        System.out.println(Collections.disjoint(list1,list));
    }

    public static void enumerationAPI(){
        int[] num = new int[]{1,3,5,3,7,2,9,4,6};

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < num.length ; i++) {
            list.add(num[i]);
        }
        System.out.println("list = " + list);

        Enumeration enumeration = Collections.enumeration(list);
        while(enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }


    }

    public static void frequencyAPI(){
        int[] num = new int[]{1,3,5,3,7,2,9,4,6};

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < num.length ; i++) {
            list.add(num[i]);
        }
        System.out.println("list = " + list);

        System.out.println(Collections.frequency(list,3));
        System.out.println(Collections.frequency(list,2));
    }

    public static void indexOfSubListAPI(){
        int[] num = new int[]{1,3,5,3,7,2,9,4,6};

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < num.length ; i++) {
            list.add(num[i]);
        }
        System.out.println("list = " + list);


        List<Integer> list1 = new ArrayList<Integer>();
        for (int i = 4; i < num.length ; i++) {
            list1.add(num[i]);
        }
        System.out.println("list1 = " + list1);

        System.out.println(Collections.indexOfSubList(list,list1));
    }

    public static void reverseAPI(){
        int[] num = new int[]{1,3,5,3,7,2,9,4,6};

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < num.length ; i++) {
            list.add(num[i]);
        }
        System.out.println("list = " + list);

        Collections.reverse(list);
        System.out.println("list = " + list);

    }

    public static void reverseOrderAPI(){
        int[] num = new int[]{1,3,5,3,7,2,9,4,6};

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < num.length ; i++) {
            list.add(num[i]);
        }
        System.out.println("list = " + list);
        Collections.sort(list);
        System.out.println("list = " + list);

        Collections.sort(list, Collections.reverseOrder());
        System.out.println("list = " + list);

    }
}
