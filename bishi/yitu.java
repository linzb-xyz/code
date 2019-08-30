import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class yitu {
	public static void main(String[] args) {
		fun1();
	}


	public static void fun1() {
		//IVXLC 对应的个数序列=最小的罗马数字
		HashMap<String, String> map = new HashMap<>();
		for (int i = 1; i < 100; i++) {
			String roman = intToRoman(i);
			String key = getArr(roman);
			if (map.containsKey(key)) {
				continue;
			} else {
				map.put(key, roman);
			}
		}
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String arr = getArr(str);
		System.out.println(map.get(arr));

	}

	private static String getArr(String num) {
		int[] romanMap = new int[5];
		for (char ch : num.toCharArray()) {
			if (ch == 'I') {
				romanMap[0]++;
			} else if (ch == 'V') {
				romanMap[1]++;
			} else if (ch == 'X') {
				romanMap[2]++;
			} else if (ch == 'L') {
				romanMap[3]++;
			} else if (ch == 'C') {
				romanMap[4]++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int j : romanMap) {
			sb.append(j);
		}
		return sb.toString();
	}

	public static String intToRoman(int num) {
		int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		StringBuilder stringBuilder = new StringBuilder();
		int index = 0;
		while (index < 13) {
			while (num >= nums[index]) {
				stringBuilder.append(romans[index]);
				num -= nums[index];
			}
			index++;
		}
		return stringBuilder.toString();
	}

	public static int romanToInt(String s) {
		String[] roman = {"IV", "IX", "XL", "XC", "CD", "CM", "I", "V", "X", "L", "C", "D", "M"};
		int[] nums = {4, 9, 40, 90, 400, 900, 1, 5, 10, 50, 100, 500, 1000};
		int num = 0;
		while (s.length() > 0) {
			for (int i = 0; i < roman.length; i++) {
				if (s.startsWith(roman[i])) {
					num += nums[i];
					s = s.substring(roman[i].length());
					break;
				}
			}
		}
		return num;
	}



/*
2 7
1 2 3 4 5 6
1 2 3 4 5 6
 */
	public static int[][] memo;
	public static void fun2() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();

			int[][] arr = new int[n][6];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 6; j++) {
					arr[i][j] = scanner.nextInt();
				}
				Arrays.sort(arr[i]);
			}
			memo = new int[n][k+1];
			System.out.println(core(arr,n-1,k));
		}
	}

	public static int core(int[][] array,int n,int k){
		if(n<0){
			if(k==0)
				return 1;
			return 0;
		}
		if(memo[n][k] > 0){
			return memo[n][k];
		}
		int h=0;
		for(int i=0;i<array[n].length;i++){
			if(k-array[n][i]>=0) {
				h += core(array, n - 1, k - array[n][i]);
			}
		}
		memo[n][k] = h;
		return h;
	}


	public static int numRollsToTarget(int n, int[][] arr, int target) {
		int[][] dp = new int[n + 1][target + 1];
		dp[0][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 6; j++) {
				int curTarget = arr[i-1][0];


				for (int k = 0; k < 6; k++) {
					if (target - arr[i - 1][k] >= 0) {
						dp[i][j] += dp[i - 1][j - k];
					}
				}
			}
		}
		return dp[n][target];
	}










/*
题解:
	对于有n个位置的情况
	第一次选有n种选择，选择第一个位置，剩下的就是f[n-2],
	选择第二个，剩下的是f[n-3]+f[0],选择第三个，
	剩下的是f[n-4]+f[1]...以此类推，
	结果就是n种情况，一共为n+2(f[n-2]+f[n-1]..),保存一下前n-2的前缀和即可

求坐下人数的期望
即: 当 n=3 时,  选择第一个位置是(1,0,1)
			   选择第二个位置是(0,1,0)
			   选择第三个位置是(1,0,1);
	所以期望是 (2+1+2) * 1/3 = 5/3



分数取模（快速取模法+小费马定理）

	对于分数a/b,模m, 求a/b(mod m)  (b,m互素)
	设k=a/b(mod m)       0<k<m
	则 kb = a(mod m)

	例如: k = 5/3 mod 1e9+7 ==>   3*k = 5 mod 1e9+7

https://blog.csdn.net/qq_43916464/article/details/95180573
 */
	public static int mod = 1000000007;
	public static long[] f = new long[1000100];
	public static void fun3() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			f[1] = 1;
			f[2] = 1;
			long cnt = 1;
			for(int i = 3; i <= 1000000;i++) {
				f[i] = (i+2*cnt) * ksm(i,mod-2)%mod;
				cnt += f[i-1];
				cnt %= mod;
			}
			System.out.println(f[n]);
		}
	}
	/*
求 x 的 y 次方, 取 mod 模.
	 */
	public static long ksm(long x, long y) {
		long res = 1;
		while (y > 0) {
			if ((y & 1) == 1) res = res * x % mod;
			y >>>= 1;
			x = x * x % mod;
		}
		return res;
	}
}