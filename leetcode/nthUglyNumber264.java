import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
/*
编写一个程序，找出第 n 个丑数。

丑数就是只包含质因数 2, 3, 5 的正整数。

示例:

输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
说明:  

1 是丑数。
n 不超过1690。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ugly-number-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class nthUglyNumber264 {
    public static void main(String[] args) {
        System.out.println(new nthUglyNumber264().nthUglyNumber(10));
        System.out.println(new nthUglyNumber264().nthUglyNumber(1690));
        System.out.println(new nthUglyNumber264().nthUglyNumber1(1690));
        System.out.println(new nthUglyNumber264().nthUglyNumber2(1690));

    }
    public int nthUglyNumber(int n) {
        int[] ele = new int[]{2,3,5};
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        long[] res = new long[n];
        res[0] = 1;

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < ele.length; j++) {
                // 用int存数据的时候，有些溢出的数据被堆排在了前面，用long可以避免溢出
                if (!priorityQueue.contains( (long)(res[i] * ele[j]) )) {
                    priorityQueue.add((long)(res[i] *ele[j]));
                }
            }
            if (i+1<res.length){
                res[i+1] = priorityQueue.poll();
            }
        }
//        System.out.println(Arrays.toString(res));
        return (int)res[n-1];
    }
    public int nthUglyNumber1(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            if (min == dp[i2] * 2) i2++;
            if (min == dp[i3] * 3) i3++;
            if (min == dp[i5] * 5) i5++;
            dp[i] = min;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }
    public int nthUglyNumber2(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        PriorityQueue<Long> queue = new PriorityQueue<>();
        HashSet<Long> hashSet = new HashSet<>();
        hashSet.add(dp[1]);
        for (int i = 2; i <= n; i++) {
            selectFactor(queue, hashSet, dp[i - 1], 2);
            selectFactor(queue, hashSet, dp[i - 1], 3);
            selectFactor(queue, hashSet, dp[i - 1], 5);
            dp[i] = queue.poll();
        }
        return (int) dp[n];
    }

    private void selectFactor(PriorityQueue<Long> queue, HashSet<Long> hashSet, long last, int factor) {
        long potential = last * factor;
        if (!hashSet.contains(potential)) {
            queue.offer(potential);
            hashSet.add(potential);
        }


    }

}
