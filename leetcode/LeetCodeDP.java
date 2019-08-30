import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/8/11
 */

public class LeetCodeDP {
	//1025. 除数博弈
	public boolean divisorGame(int N) {
		return (N&1)==0?true:false;
	}

	public boolean divisorGame1(int N) {
		boolean flag = false;
		boolean[] dp = new boolean[N+1];
		if(N == 2){
			return true;
		}
		if(N == 1){
			return false;
		}
		dp[1] = false;
		dp[2] = true;

		for (int i = 3; i <= N; i++) {
			boolean canWin = false;
			for (int j = 1; j < i/2+1; j++) {
				if(i%j == 0 && dp[i-j] == false ){
					canWin = true;
					break;
				}
			}
			dp[i] = canWin;
		}
		return dp[N];
	}
	//303. 区域和检索 - 数组不可变
	static class NumArray {
		int[] partSum;
		int[] nums;
		public NumArray(int[] nums) {
			partSum = new int[nums.length];
			this.nums = nums;
			for(int i=0; i<nums.length; i++){
				partSum[i] = partSum[i-1==0?0:i-1] + nums[i];
			}
		}
		public int sumRange(int i, int j) {
			return partSum[j]-partSum[i] + nums[i];
		}
	}

	//121.买卖股票的最佳时机
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length <= 0)
			return 0;
		int min = prices[0];
		int res = 0;
		for(int i =1; i < prices.length; i++){
			res = Math.max(res, prices[i]-min);
			min = Math.min(min, prices[i]);
		}
		return res;
	}
	//53. 最大子序和    最大和的连续子数组
	public int maxSubArray(int[] nums) {
		if(nums == null | nums.length <= 0){
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i=0; i<nums.length; i++){
			sum = Math.max(sum+nums[i], nums[i]);
			max = Math.max(max, sum);
		}
		return max;
	}
	//70. 爬楼梯
	public int climbStairs(int n) {
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		return climbStairs(n-1) + climbStairs(n-2);
	}

	int[] memo;
	public int climbStairs1(int n) {
		memo = new int[n+1];
		return digui(n);
	}
	public int digui(int n){
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		if(memo[n]!=0){
			return memo[n];
		}
		memo[1] = 1;
		memo[2] = 2;
		memo[n] = digui(n-1) + digui(n-2);
		return memo[n];
	}

	public int climbStairs2(int n) {
		if(n==1)
			return 1;
		if(n==2)
			return 2;

		int[] memo = new int[n+1];
		memo[1] = 1;
		memo[2] = 2;
		for(int i=3; i<n+1; i++){
			memo[i] = memo[i-1] + memo[i-2];
		}
		return memo[n];
	}

	//746. 使用最小花费爬楼梯
	public int minCostClimbingStairs(int[] cost) {
		int len = cost.length;
		int[] dp = new int[len+1];  //dp[i] 表示爬到第 i 个阶梯花费的最小体力
		if(cost == null || len <= 0){
			return 0;
		}
		if(len == 1)
			return cost[0];
		if(len == 2)
			return cost[1];
		dp[0] = cost[0];
		dp[1] = cost[1];

		for(int i = 2; i < len; i++){
			dp[i] = Math.min(dp[i-1]+cost[i], dp[i-2]+cost[i]);
		}
		dp[len] = Math.min(dp[len-1], dp[len-2]);

		return dp[len];
	}
	//198. 打家劫舍
	public int rob(int[] nums) {
		if(nums==null||nums.length==0){
			return 0;
		}
		int len = nums.length;
		int[] dp = new int[len+1];  //dp[i] 表示在第 i个位置可以获取的最大值
		if(len==1)
			return nums[0];
		if(len==2)
			return Math.max(nums[0],nums[1]);

		dp[0]=nums[0];
		dp[1]=Math.max(nums[0],nums[1]);
		for(int i=2; i< len; i++){
			dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
		}
		dp[len] = Math.max(dp[len-1],dp[len-2]);
		return dp[len];
	}
//338. 比特位计数
	/*
观察 x 和x′ =x/2 的关系：

x = (1001011101)_2 = (605)_{10}
x' = (100101110)_2 = (302)_{10}

可以发现 x'与 x 只有一位不同，这是因为x'可以看做 x 移除最低有效位的结果。
这样，我们就有了下面的状态转移函数：
P(x) = P(x / 2) + (x mod 2)
*/
	public int[] countBits(int num) {
		int[] res = new int[num+1];

		res[0] = 0;
		for(int i=1; i<num+1; i++){
			res[i] = res[i/2] + i%2;
		}
		return res;
	}
}