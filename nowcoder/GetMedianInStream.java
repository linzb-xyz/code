import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/8/3
 */
/*

如何得到一个数据流中的中位数？
如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。

https://www.nowcoder.com/practice/9be0172896bd43948f8a32fb954e1be1?tpId=13&tqId=11216&tPage=4&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class GetMedianInStream {

    public static void main(String[] args) {
        int[] num = new int[]{5,2,3,4,1,6,7,0,8};

        GetMedianInStream getMedian = new GetMedianInStream();
        for (int i = 0; i < num.length ; i++) {
            getMedian.Insert(num[i]);
            System.out.println(getMedian.small.size() + " " +getMedian.large.size() + " "+getMedian.GetMedian());
        }
    }

    PriorityQueue<Integer> large = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> small = new PriorityQueue<>();

    public void Insert(Integer num) {
        if(!small.isEmpty() && num > small.peek()){
            small.add(num);
        }else if(!large.isEmpty() && num <large.peek()){
            large.add(num);
        }else {
            small.add(num);
        }
        if(small.size() - large.size() > 1){
            large.add(small.poll());
        }else if(large.size() - small.size() > 1){
            small.add(large.poll());
        }
        return;
    }

    public Double GetMedian() {
        if((small.size() + large.size()) %2 == 0){
            return ((double)(small.peek()+(double)large.peek())/2.0);
        }else {
            return (double)(small.size() > large.size() ? small.peek(): large.peek());
        }
    }
}
