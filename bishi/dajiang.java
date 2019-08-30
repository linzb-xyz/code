import java.util.HashMap;
import java.util.Scanner;

public class dajiang {

    public static void main(String[] args) {
        fun3();
    }
    public static void fun1(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int t = scanner.nextInt();
            for (int o = 0; o < t; o++) {
                int n = scanner.nextInt();
                int x = scanner.nextInt();
                int[] dp = new int[x+1];
                int[] val = new int[n];
                int[] tim = new int[n];
                for (int i = 0; i < n; i++) {
                    val[i] = scanner.nextInt();
                    tim[i] = scanner.nextInt();
                    for (int j = x; j>= 0 && j>= tim[i]; j--) {
                        dp[j] = Math.max(dp[j], dp[j-tim[i]] + val[i]);
                    }
                }
                System.out.println(dp[x]);
            }
        }
    }
    /*
    4 4
ZuoZhuan TurnLeft
YouZhuan TurnRight
QianJin Forward
HouTui Backward
ZuoZhuan
QianJin
QianJin
HouTui
1 1
SDFlkjdf LNCIls
SDFlkjdf
     */
    public static void fun2(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            HashMap<String, String> hashMap = new HashMap<>();
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                String str1, str2;
                str1 = scanner.next();
                str2 = scanner.next();
                hashMap.put(str1,str2);
            }
            for (int i = 0; i < m; i++) {
                String str = scanner.next();
                System.out.println(hashMap.get(str));
            }
        }
    }

    static class Eat {
        int price,love;

        public Eat(int price, int love) {
            this.price = price;
            this.love = love;
        }
    }

    static int v;
    static int n;
    static int[] c;
    static int m;
    static int[] love;
    public static void fun3(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            v = scanner.nextInt();
            n = scanner.nextInt();
            c = new int[n];

            for (int i = 0; i < n; i++) {
                c[i] = scanner.nextInt();
            }
            m = scanner.nextInt();
            love = new int[m];
            for (int i = 0; i < m; i++) {
                love[i] = scanner.nextInt();
            }

            Eat[] eat = new Eat[n];
            for (int i = 0; i < n; i++) {
                if(i < m){
                    eat[i] = new Eat(c[i], love[i]);
                }else{
                    eat[i] = new Eat(c[i],0);
                }
            }

            int[] num = new int[n];
            System.out.println(1);


        }
//        public static void count(Eat[] eats, int[] num){
//            int res = 0;
//            num[0] = v / c[0];
//            res++;
//
//            for (int i = 1; i < m; i++) {
//                if((v-c[1])/)
//            }
//        }
    }

	/*
解密
B = 1001010 K=4
加密过程:
1001010
1001010
1001010
1001010
------------ 异或
1110100110

输入加密后的字符,解密
输入
7 4
1110100110
输出:
1001010

输入:
6 2
1110001

输出
101111

*/
	public static void jiemi(){
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()){
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			int s = scanner.nextInt(2);

			int[] arr = new int[n];
			String s1 = Integer.toString(s,2);

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(s1.substring(i,i+1));
				if(i-k+1<=0) {
					for (int j = 0; j < i && j < k; j++) {
						arr[i] ^= arr[j];
					}
				}else{
					for (int j = i - k + 1; j < i; j++) {
						arr[i] ^= arr[j];
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			for (int i:arr) {
				sb.append(String.valueOf(i));
			}
			System.out.println(sb.toString());
		}
	}
}

