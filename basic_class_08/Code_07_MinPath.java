package class_08;

/***
 * 介绍递归和动态规划
 * 暴力递归:
 * 1，把问题转化为规模缩小了的同类问题的子问题
 * 2，有明确的不需要继续进行递归的条件(base case)
 * 3，有当得到了子问题的结果之后的决策过程
 * 4，不记录每一个 子问题的解
 *
 * 暴力递归有重复状态, 并且这个状态与到达这个状态的路劲无关,即参数固定,返回值固定 => 可以改成动态规划
 *
 * 动态规划
 * 1，从暴力递归中来
 * 2，将每一个子问题的解记录下来，避免重复计算
 * 3，把暴力递归的过程，抽象成了状态表达
 * 4，并且存在化简状态表达，使其更加简洁的可能
 */

/**
 * 给你一个二维数组，二维数组中的每个数都是正数，要求从左上
 * 角走到右下角，每一步只能向右或者向下。沿途经过的数字要累
 * 加起来。返回最小的路径和。
 */
public class Code_07_MinPath {

    //暴力递归
	public static int minPath1(int[][] matrix) {
		return process1(matrix, matrix.length - 1, matrix[0].length - 1);
	}

	public static int process1(int[][] matrix, int i, int j) {
		int res = matrix[i][j];
		//i==0,j==0,走到右下角
		if (i == 0 && j == 0) {
			return res;
		}
        //i==0,j!=0,走到底边
		if (i == 0 && j != 0) {
			return res + process1(matrix, i, j - 1);
		}
        //i!=0,j==0,走到底边
		if (i != 0 && j == 0) {
			return res + process1(matrix, i - 1, j);
		}

        //递归尝试 i-1 或 j-1
		return res + Math.min(process1(matrix, i, j - 1), process1(matrix, i - 1, j));
	}

	//动态规划
	public static int minPath2(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		int row = m.length;
		int col = m[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = m[0][0];
		for (int i = 1; i < row; i++) {
			dp[i][0] = dp[i - 1][0] + m[i][0];
		}
		for (int j = 1; j < col; j++) {
			dp[0][j] = dp[0][j - 1] + m[0][j];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
			}
		}
		return dp[row - 1][col - 1];
	}

	// for test
	public static int[][] generateRandomMatrix(int rowSize, int colSize) {
		if (rowSize < 0 || colSize < 0) {
			return null;
		}
		int[][] result = new int[rowSize][colSize];
		for (int i = 0; i != result.length; i++) {
			for (int j = 0; j != result[0].length; j++) {
				result[i][j] = (int) (Math.random() * 10);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
		System.out.println(minPath1(m));
		System.out.println(minPath2(m));

		m = generateRandomMatrix(6, 7);
		System.out.println(minPath1(m));
		System.out.println(minPath2(m));
	}
}
