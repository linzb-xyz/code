import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/8/3
 */

/*
题目描述
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
他们的最大值分别为{4,4,6,6,6,5}；
 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
  {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
   {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。

https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=13&tqId=11217&tPage=4&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class maxInWindows {
    public static void main(String[] args) {
        int[] num = new int[]{2,3,4,2,6,2,5,1};
        System.out.println(new maxInWindows().maxInWindows(num,3));
    }

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        if(num == null || num.length < size || size < 1){
            return new ArrayList<Integer>();
        }

        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < num.length; i++) {
            while (!queue.isEmpty() && num[queue.peekLast()] <= num[i]){
                queue.pollLast();
            }
            queue.addLast(i);

            if(queue.peekFirst() == i - size){
                queue.pollFirst();
            }
            if(i >= size-1){
//                System.out.println(i);
                res.add(num[queue.peekFirst()]);
            }
        }
        return res;


    }
}
