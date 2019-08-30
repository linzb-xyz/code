import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/8/11
 */

public class LeetCodeArray {
	public static void main(String[] args) {

	}
	//88. 合并两个有序数组
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m-1, j = n-1, cur = m+n-1;
		while( i >= 0 && j >= 0){
			if(nums1[i] > nums2[j]){
				nums1[cur] = nums1[i];
				i--;
			}else {
				nums1[cur] = nums2[j];
				j--;
			}
			cur--;
		}

		while (j >= 0){
			nums1[cur--] = nums2[j--];
		}

	}


	//75. 颜色分类 荷兰国旗问题
	public void sortColors(int[] nums) {
		int l = -1, mid = 0, r = nums.length;

		while(mid < r){
			if(nums[mid] == 1){
				mid++;
			}else if(nums[mid] == 0 ){
				int temp = nums[++l];
				nums[l] = nums[mid];
				nums[mid] = temp;
				mid++;
			}else if(nums[mid] == 2){
				int temp = nums[--r];
				nums[r] = nums[mid];
				nums[mid] = temp;
			}
		}
	}

	//80. 删除排序数组中的重复项 II
	public int removeDuplicates2(int[] nums) {
		int l = 0;
		int count = 0;
		for (int i = 1; i < nums.length; i++) {
			if(nums[l] == nums[i] && count < 1){
				nums[++l] = nums[i];
				count++;
			}else if(nums[l]!=nums[i]){
				count = 0;
				nums[++l] = nums[i];
			}
		}
		return l+1;
	}

	//26. 删除排序数组中的重复项
	public int removeDuplicates(int[] nums) {
		int l = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[l] != nums[i]){
				nums[++l] = nums[i];
			}
		}
		return l+1;
	}

	//27. 移除元素
	public int removeElement(int[] nums, int val) {
		int r = nums.length-1, l = 0;
		while (l <= r){   //从[0,l)区间是新数组, nums[l]==val
			if(nums[l] != val){
				l++;
			}else if(nums[r]==val) {
				r--;
			} else {
				nums[l] = nums[r];
				nums[r] = val;
			}

		}
		return l;
	}

	//119. 杨辉三角 II
	/**
	 * 获取杨辉三角的指定行
	 * 直接使用组合公式C(n,i) = n!/(i!*(n-i)!)
	 * 则第(i+1)项是第i项的倍数=(n-i)/(i+1);
	 */
	public List<Integer> getRow1(int rowIndex) {
		List<Integer> res = new ArrayList<>(rowIndex + 1);
		long cur = 1;
		for (int i = 0; i <= rowIndex; i++) {
			res.add((int) cur);
			cur = cur * (rowIndex-i)/(i+1);
		}
		return res;
	}

	//119. 杨辉三角 II
	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		if(rowIndex == 0){
			return list;
		}
		list.add(1);
		if(rowIndex == 1){
			return list;
		}
		for (int i = 2 ; i <= rowIndex; i++) {
			int pre = list.get(0);
			int cur = list.get(1);
			for (int j = 1; j < i; j++) {
				cur = list.get(j);
				list.set(j, pre+cur);
				pre = cur;
			}
			list.add(1);
		}
		return list;
	}

	//283. 移动零
	public void moveZeroes(int[] nums) {
		int i = 0, j =0;
		while(i < nums.length){
			if(nums[i]==0){
				i++;
			} else {
				nums[j++] = nums[i++];
			}
		}
		while (j < nums.length){
			nums[j++] = 0;
		}
	}
	//1122. 数组的相对排序
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		int[] buckets = new int[1001];
		for (int i = 0; i < arr1.length; i++) {
			buckets[arr1[i]]++;
		}
		int j = 0;
		for (int i = 0; i < arr2.length; i++) {
			while (buckets[arr2[i]] > 0) {
				arr1[j] = arr2[i];
				buckets[arr2[i]]--;
				j++;
			}
		}
		for (int i = 0; i < buckets.length; i++) {
			while (buckets[i]>0){
				arr1[j] = i;
				buckets[i]--;
				j++;
			}
		}
		return arr1;
	}

	//766. 托普利茨矩阵
	public boolean isToeplitzMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length-1; i++) {
			for (int j = 0; j < matrix[0].length-1; j++) {
				if(matrix[i][j] != matrix[i+1][j+1]){
					return false;
				}
			}
		}
		return true;
	}

	//566 。重塑矩阵
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		if(nums.length * nums[0].length < r*c){
			return nums;
		}
		int[][] res = new int[r][c];
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				res[count/c][count%c] = nums[i][j];
				count++;
			}
		}
		return res;
	}

	//1002. 查找常用字符
	public List<String> commonChars(String[] A) {
		int[] count = new int[26];
		for (int i = 0; i < A[0].length(); i++) {
			count[A[0].charAt(i)-'a']++;
		}
		for (int i = 1; i < A.length; i++) {
			int[] temp = new int[26];
			for (int j = 0; j < A[i].length(); j++) {
				temp[A[i].charAt(j)-'a']++;
			}
			for (int j = 0; j < 26; j++) {
				count[j] = Math.min(count[j], temp[j]);
			}
		}
		List<String> res = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			while (count[i] > 0) {
				res.add(String.valueOf((char)(i +'a')));
				count[i]--;
			}
		}
		return res;
	}

	//922. 按奇偶排序数组 II
	public int[] sortArrayByParityII(int[] A) {
		int i = 0, j = 1;

		while(i<A.length && j<A.length){
			if( (A[i]&1)==(i&1) ){
				i+=2;
			}else if((A[j]&1)==(j&1)){
				j+=2;
			}else if(i<A.length && j< A.length){
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		return A;
	}
	//867. 转置矩阵
	public int[][] transpose(int[][] A) {
		int[][] B = new int[A[0].length][A.length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				B[j][i] = A[i][j];
			}
		}
		return B;
	}

	//999
	/*
		char[][] board = new char[][]{
				{'.','.','.','.','.','.','.','.'},
				{'.','.','.','p','.','.','.','.'},
				{'.','.','.','R','.','.','.','p'},
				{'.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.'},
				{'.','.','.','p','.','.','.','.'},
				{'.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.'}
		};
		char[][] board2 = new char[][]{
				{'.','.','.','.','.','.','.','.'},
				{'.','.','.','p','.','.','.','.'},
				{'.','.','.','p','.','.','.','.'},
				{'p','p','.','R','.','p','B','.'},
				{'.','.','.','.','.','.','.','.'},
				{'.','.','.','B','.','.','.','.'},
				{'.','.','.','p','.','.','.','.'},
				{'.','.','.','.','.','.','.','.'}};
	 */
	public static int numRookCaptures(char[][] board) {
		int x = 0,y = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j] == 'R'){
					x = i;
					y = j;
				}
			}
		}
		int count = 0;
		int row = x-1;
		while (row >= 0){
			if(board[row][y] == 'p'){
				count++;
				break;
			}
			if(board[row][y] == 'B'){
				break;
			}
			row--;
		}
		row = x+1;
		while (row < board.length){
			if(board[row][y] == 'p'){
				count++;
				break;
			}
			if(board[row][y] == 'B'){
				break;
			}
			row++;
		}
		int col = y-1;
		while (col >= 0){
			if(board[x][col] == 'p'){
				count++;
				break;
			}
			if(board[x][col] == 'B'){
				break;
			}
			col--;
		}
		col = y+1;
		while (col < board[0].length){
			if(board[x][col] == 'p'){
				count++;
				break;
			}
			if(board[x][col] == 'B'){
				break;
			}
			col++;
		}
		return count;
	}

	//509 斐波那契数列 1.暴力递归
	public int fib(int N) {
		if(N==0)
			return 0;
		if(N==1)
			return 1;
		return fib(N-1)+fib(N-2);
	}
	//509 斐波那契数列 2.记忆化搜索
	public int fib2(int N) {
		int[] memo = new int[N+1];
		return fib2Help(N,memo);
	}
	public int fib2Help(int N, int[] memo) {
		if(N==0)
			return 0;
		if(N==1)
			return 1;
		if(memo[N]!=0)
			return memo[N];
		memo[N] = fib(N-1)+fib(N-2);
		return memo[N];
	}
	//509 斐波那契数列 3.动态规划
	public int fib3(int N) {
		if(N==0)
			return 0;
		if(N==1)
			return 1;
		int[] dp = new int[N+1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i < N+1; i++) {
			dp[i]= dp[i-1]+dp[i-2];
		}
		return dp[N];
	}


		//561
	public static int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i+=2) {
			sum += nums[i];
		}
		return sum;
	}

	//905 1.partition
	public static int[] sortArrayByParity(int[] A) {
		int i = 0, j = A.length-1;
		while(i < j){
			while (i < A.length && A[i] % 2 == 0){
				i++;
			}
			while (j >= 0 && A[j] % 2 == 1){
				j--;
			}
			if(i < j){
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		return A;
	}
	//905 1.partition2
	public static int[] sortArrayByParity2(int[] A) {
		int i = 0, j = A.length-1;
		while(i < j){
			if((A[i]&1) == 1 && (A[j]&1) == 0){
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}else if((A[i]&1) == 0){
				i++;
			}else if((A[j]&1) == 0){
				j--;
			}
		}
		return A;
	}

	//1051 1.暴力,排序后比较元素,不同则 count++
	public static int heightChecker(int[] heights) {
		int[] sort = Arrays.stream(heights).sorted().toArray();
		int count = 0;
		for (int i = 0; i < sort.length; i++) {
			count += sort[i] == heights[i] ? 0 : 1;
		}
		return count;
	}
	//1051 2.桶排序
	public static int heightChecker2(int[] heights) {
		int[] bucket = new int[101];
		for (int i = 0; i < heights.length; i++) {
			bucket[heights[i]]++;
		}

		int count = 0;
		int j = 0;
		for (int i = 0; i < bucket.length; i++) {
			while ((bucket[i]!=0)){
				if(heights[j]!=i){
					count++;
				}
				j++;
				bucket[i]--;
			}
		}
		return count;
	}


	//977 1.stream
	public static int[] sortedSquares(int[] A) {
		return Arrays.stream(A).map(x -> x*x).sorted().toArray();
	}
	//977 2.双指针
	public static int[] sortedSquares2(int[] A) {
		int[] res = new int[A.length];
		int i = 0, j = A.length-1;

		int cur = A.length-1;
		while(i <= j){
			if(A[i]*A[i] > A[j]*A[j]){
				res[cur--] = A[i]*A[i];
				i++;
			}else {
				res[cur--] = A[j]*A[j];
				j--;
			}
		}
		return res;
	}
}
