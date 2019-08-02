import java.util.PriorityQueue;

/*
编写一段程序来查找第 n 个超级丑数。

超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。

示例:

输入: n = 12, primes = [2,7,13,19]
输出: 32
解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
说明:

1 是任何给定 primes 的超级丑数。
 给定 primes 中的数字以升序排列。
0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
第 n 个超级丑数确保在 32 位有符整数范围内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/super-ugly-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class nthSuperUglyNumber313 {

    public static void main(String[] args) {
        int k = 850;
        int[] nums =new int[]{7,13,29,31,37,41,43,53,59,61,71,73,79,83,89,101,107,109,127,131,137,149,151,157,173,227,229,233,239,257};
        System.out.println(new nthSuperUglyNumber313().nthSuperUglyNumber(k, nums));
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        long[] res = new long[n];
        res[0] = 1;

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < primes.length; j++) {
                // 用int存数据的时候，有些溢出的数据被堆排在了前面，用long可以避免溢出
                if (!priorityQueue.contains( (long)(res[i] * primes[j]) )) {
                    priorityQueue.add((long)(res[i] *primes[j]));
                }
            }
            if (i+1<res.length){
                res[i+1] = priorityQueue.poll();
            }
        }
//        System.out.println(Arrays.toString(res));
        return (int)res[n-1];
    }
}
