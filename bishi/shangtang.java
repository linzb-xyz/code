import java.math.BigInteger;
import java.util.*;

//矩阵快速幂
public class shangtang {
	public static void main(String[] args) {
		fun32();
	}

	/*
	逆波兰式
	 */
	public static void  fun1(){
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()){
			String str = scanner.nextLine();
			String[] t = str.split(" ");
			Stack<Integer> stack = new Stack<>();

			for(String s: t){
				if(s.equals("+")){
					stack.push(stack.pop()+stack.pop());
				} else if(s.equals("-")){
					stack.push(-stack.pop()+stack.pop());
				} else if(s.equals("*")){
					stack.push(stack.pop()*stack.pop());
				} else if(s.equals("/")){
					int num1 = stack.pop();
					stack.push(stack.pop()/num1);
				} else {
					stack.push(Integer.parseInt(s));
				}
			}

			System.out.println(stack.pop());
		}
	}

	public static void fun2(){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			int[] a = new int[n];

			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}
			int res = 0;
			int[] up = new int[n], down = new int[n];

			for (int i = n-2; i >= 0 ; i--) {
				if(a[i] > a[i+1]){
					down[i] = down[i+1] +1;
				}
			}
			for (int i = 0; i < n; i++) {
				if(i > 0 && a[i] > a[i-1]){
					up[i] = up[i-1]+1;
				}
				if(up[i] > 0 && down[i] > 0){
					res = Math.max(res, up[i] + down[i] + 1);
				}
			}
			System.out.println(res);
		}
	}

/*
10^10次方 或 2^18 次方 以上的用 O(n) 的算法 都超时,应考虑优化算法
 */
	public static void fun31(){
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			long n = sc.nextLong();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int f0 = sc.nextInt();
			final int mod = 1000000007;
			BigInteger f1, f2, f3;
			BigInteger[] fb = new BigInteger[3];
			long[] f = new long[3];

			Integer fi1 = a * f0 + 2-1+ 32767;
			f1 = new BigInteger(fi1.toString());
			Integer fi2 = a * fi1 + b * f0 + 2*4-2+ 32767;
			f2 = new BigInteger(fi2.toString());
			Integer fi3 = a * fi2 + b* fi1 + c * f0 + 2*9 -3+ 32767;
			f3 = new BigInteger(fi3.toString());

			f[0] = f0;
			f[1] = fi1;
			f[2] = fi2;
			fb[0] = f3;
			fb[1] = f1;
			fb[2] = f2;

			for (int i = 3; i <= n; i++) {
//				long temp = (a * f[(i - 1) % 3] + b * f[(i - 2) % 3] + c * f[(i - 3) % 3] + 2 * i * i - i + 32767) % mod;

				f[i % 3] = ( (a * f[(i - 1) % 3]) % mod + (b * f[(i - 2) % 3])%mod + (c * f[(i - 3) % 3])%mod + 2 * i * i - i + 32767) % mod;
			}
			System.out.println(f[(int) (n % 3)]);
		}
	}
/*
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
	public static void fun32(){
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

	static int N;
	static Map<Integer, List<Integer>> graph;
	static Long[][] memo;

	public static void fun4(){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] a = new int[n];

			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}
			System.out.println(numSquarefulPerms(a));
		}


	}
	public static long numSquarefulPerms(int[] A) {
		N = A.length;
		graph = new HashMap();
		memo = new Long[N][1 << N];

		for (int i = 0; i < N; ++i)
			graph.put(i, new ArrayList());

		for (int i = 0; i < N; ++i)
			for (int j = i+1; j < N; ++j) {
				int r = (int) (Math.sqrt(A[i] + A[j]) + 0.5);
				if (r * r == A[i] + A[j]) {
					graph.get(i).add(j);
					graph.get(j).add(i);
				}
			}


		int[] factorial = new int[20];
		factorial[0] = 1;
		for (int i = 1; i < 20; ++i)
			factorial[i] = i * factorial[i-1];

		long ans = 0;
		for (int i = 0; i < N; ++i)
			ans += dfs(i, 1 << i);

		Map<Integer, Integer> count = new HashMap();
		for (int x: A)
			count.put(x, count.getOrDefault(x, 0) + 1);
		for (int v: count.values())
			ans /= factorial[v];

		return ans;
	}

	public static long dfs(int node, int visited) {
		if (visited == (1 << N) - 1)
			return 1;
		if (memo[node][visited] != null)
			return memo[node][visited];

		long ans = 0;
		for (int nei: graph.get(node))
			if (((visited >> nei) & 1) == 0)
				ans += dfs(nei, visited | (1 << nei));
		memo[node][visited] = ans;
		return ans;
	}
}




