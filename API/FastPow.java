import java.util.Scanner;

/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/8/19
 */

public class FastPow {

	public static void main(String[] args) {
		// -4 的 3 次幂 对 10000 取余
		System.out.println(fastPow(-4, 3, 10000));

		// arr^3  矩阵 arr 的 3 次幂
		int [][]arr={{1,1,1},{1,1,1},{1,1,1}};
		int[][]arr1=multiplyPower(arr,3);
		for(int i=0;i<arr1.length;i++){
			for(int j=0;j<arr1[0].length;j++){
				System.out.print(arr1[i][j]+"   ");
			}
			System.out.println();
		}


	}

	/*
a^b mod c = (a2)^(b/2) mod c , b为偶数
a^b mod c = (a^2)^(b/2)·a mod c , b为奇数

a^11 = a^(2^0 + 2^1 + 2^3) = a ^(1011);

求 base 的 n 次方, 取 mod 模.
	 */
	public static int fastPow(int base, int n, int mod){
	    int res = 1;
	    while (n > 0){
	    	if((n&1) == 1){     //如果当前的次幂数最后一位(二进制数)不为0的话，那么我们将当前权值加入到最后答案里面去
	    		res *= base % mod;
		    }
		    //权值增加
		    base *= base;
	    	n >>= 1;
	    }
	    return res % mod;
	}



	/*
	商汤笔试题8月 19 号第三题
	输入:
	10 0 0 0 100

	矩阵快速幂

	[f_i, f_i-1, f_i-2, (i+1)^2, i+1, 1] = [f_i-1, f_i-2, f_i-3, i^2, i, 1] *   [ a,    1,  0,  0,  0,  0]
																				[ b,    0,  1,  0,  0,  0]
																				[ c,    0,  0,  0,  0,  0]
																				[ 2,    0,  0,  1,  0,  0]
																				[ -1,   0,  0,  2,  1,  0]
																				[ 32767,0,  0,  1,  1,  1]
	 */
	static int mod = 1000000007;
	public static void matirxFastPow(){
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			long n = sc.nextLong();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int f0 = sc.nextInt();
			final int mod = 1000000007;
			int[][] arr = new int[][]{
					{a, 1, 0, 0, 0, 0},
					{b, 0, 1, 0, 0, 0},
					{c, 0, 0, 0, 0, 0},
					{2, 0, 0, 1, 0, 0},
					{-1, 0, 0, 2, 1, 0},
					{32767, 0, 0, 1, 1, 1}
			};
			int[][] arrN = multiplyPower(arr, n);
			int[] f_0 = new int[]{f0, 0, 0, 1, 1, 1};
			int f_N = f_0[0] * arrN[0][0] + f_0[1] * arrN[1][0] + f_0[2] * arrN[2][0] + f_0[3] * arrN[3][0] + f_0[4] * arrN[4][0] + f_0[5] * arrN[5][0];
			System.out.println(f_N);
		}
	}

	/*
	矩阵快速幂
	如何快速的算出一个矩阵的N次幂呢，举个例子，
	比如 A^19 => （A^16）*（A^2）*（A^1）     显然采取这样的方式计算时因子数将是log(n)级别的(原来的因子数是n)，不仅这样，因子间也是存在某种联系的

	主要的就是while循环里的代码，运用了分治的思想，快速的计算矩阵的n次幂。
	 */
	public static int[][] multiplyPower(int[][]a, long n){
		int[][] res=new int[a.length][a[0].length];
		//初始化为单位矩阵
		for(int i=0;i<res.length;i++){
			for(int j=0;j<res[0].length;j++){
				if(i==j)
					res[i][j]=1;
				else
					res[i][j]=0;
			}

		}
		while(n!=0){
			if((n&1)==1)
				res=multiply(res,a);
			n>>=1;
			a=multiply(a,a);
		}
		return res;
	}

	/*
	定义了矩阵的乘法运算，在矩阵中，单位矩阵就是相当于常数1，
	A: n行, m 列          A.length 为 行数
	B: m行, k 列
	res: n行, k列
	 */
	public static int[][] multiply(int [][]a,int[][]b){//两个矩阵相乘,具有普适性
		int[][]arr=new int[a.length][b[0].length];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<b[0].length;j++){
				for(int k=0;k<a[0].length;k++){
					arr[i][j]+=a[i][k]*b[k][j] % mod ;
				}
			}
		}
		return arr;
	}

}
