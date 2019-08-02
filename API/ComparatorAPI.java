import java.util.*;

/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/7/29
 */

public class ComparatorAPI {


    public static void main(String[] args) {
        compareAPI();
        comparingDoubleAPI();
    }


    public static class Node{
        double d;

        public Node(double d) {
            this.d = d;
        }

        public double getD() {
            return d;
        }

        public void setD(double d) {
            this.d = d;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "d=" + d +
                    '}';
        }
    }
    //类似的有 comparingInt comparingLong
    public static void comparingDoubleAPI(){
        //        list.add(1.5);   //Arrays.asList 返回的 list 可以排序,不可以添加
        List<Node> list = new ArrayList<>();
        list.add(new Node(1.2));
        list.add(new Node(0.8));
        list.add(new Node(4.9));
        list.add(new Node(2.4));

        list.forEach(num -> System.out.println(num));

        /**
         * 可以抽取出类中的 double 方法返回值 ,进行排序比较器
         */
        list.sort(Comparator.comparing(Node::getD).reversed());
        System.out.println(list);

        /**
         * 可以抽取出类中的 double 方法返回值 ,进行排序比较器
         */
        Collections.sort(list, Comparator.comparingDouble(Node::getD));

        System.out.println(list);
    }

    public static void compareAPI(){
        //        list.add(1.5);   //Arrays.asList 返回的 list 可以排序,不可以添加
        List<Double> list = Arrays.asList(new Double[]{3.4,2.3,4.5,5.6,1.2});

        list.forEach(num -> System.out.println(num));

        Collections.sort(list);

        System.out.println(list);
    }
}
