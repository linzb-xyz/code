import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {

	public static void main(String[] args) {
		fun2();
	}

	/*
	6
3 + 2 + 1 + -4 * -5 + 1

	 */
	public static void fun1(){
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()){
			int n = scanner.nextInt();
//			int[] nums = new int[n];
			String[] op = new String[n+n-1];

			int x=0,y=0;
			for (int i = 0; i < n+n-1; i++) {
				op[i] = scanner.next();
			}

			System.out.println(Arrays.toString(op));
//			String[] s = Arrays.sort(op);
//			System.out.println(Arrays.toString(s));
		}
	}
/*

5 10000 1000
1 5 4 2 3
5 4 3 2 1

3
 */
	public static void fun2(){


		int  MAX_N = 100010;

		int[] a = new int[MAX_N],b = new int[MAX_N];
//		Vector<Integer> l = new Vector<>(MAX_N);
		ArrayList<Integer>[] list = new ArrayList[MAX_N];
		int n,m,s,e;
		int[][]  dp = new int[MAX_N][310];

		for (int i = 0; i < MAX_N; i++) {
			for (int j = 0; j < 310; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}

		Scanner scanner = new Scanner(System.in);

		n = scanner.nextInt();
		m = n;
		s = scanner.nextInt();
		e = scanner.nextInt();


		for (int i=1;i<=n;i++)
			a[i] = scanner.nextInt();

		for (int i=1;i<=m;i++) {
			b[i] = scanner.nextInt();
//			l[b[i]].push_back(i);
			if(list[b[i]] == null){
				list[b[i]] = new ArrayList<>();
			}
			list[b[i]].add(i);
		}
		int tot=s/e;
		int ans=0;
		dp[0][0]=0;
		for (int i=1;i<=n;i++) {
			dp[i][0]=0;
			for (int j=1;j<=tot;j++) {
				dp[i][j]=dp[i-1][j];
//				int aa= Math.round(l[a[i]].begin(),l[a[i]].end(),dp[i][j-1])-l[a[i]].begin();

				int temp1 = list[a[i]].size()-1;
				for (int k = 0; k < list[a[i]].size() ; k++) {
					if(list[a[i]].get(k) > dp[i][j-1]){
						temp1 = k;
						break;
					}
				}
				int aa= temp1 - 0;

				if (aa < list[a[i]].size()) {
					dp[i][j] = Math.min(dp[i][j],list[a[i]].get(aa));
				}
				if (j > ans && j*e+i+dp[i][j] <= s) {
					ans=j;
				}
			}
		}
		System.out.println(ans);
	}









}