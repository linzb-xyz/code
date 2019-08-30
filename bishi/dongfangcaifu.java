import java.util.Scanner;

public class dongfangcaifu {

    public static void main(String[] args) {
        fun2();
    }
    /*
    aabcc dbbca aadbbcbcac
     */
    public static void fun1(){
        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()){
        String[] str = scanner.nextLine().split(" ");
        if(isInterleave(str[0], str[1], str[2])){
            System.out.println("TRUE");
        }else {
            System.out.println("FALSE");
        }
//        }
    }
//    public static boolean isInterleave(String s1, String s2, String s3){
//        if(s3.length() != s1.length() + s2.length()){
//            return false;
//        }
//        boolean dp[] = new boolean[s2.length()+1];
//        for (int i = 0; i <= s1.length(); i++) {
//            for (int j = 0; j <= s2.length(); j++) {
//                if(i==0 && j==0){
//                    dp[j] = true;
//                }else if(i == 0){
//                    dp[j] = dp[j-1]&&s2.charAt(j-1) == s3.charAt(i+j-1);
//                }else if(j==0){
//                    dp[j] = dp[j] && s1.charAt(i-1) == s3.charAt(i+j-1);
//                }else {
//                    dp[j] = (dp[j]&&s1.charAt(i-1) == s3.charAt(i+j-1) ||(dp[j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1)));
//                }
//            }
//        }
//        return dp[s2.length()];
//    }


    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[] = new boolean[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s2.length()];
    }

    public static void fun2(){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int[] arr = new int[x];
        for (int i = 0; i < x; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(maxProfit_k_2(arr));
    }
    static int maxProfit_k_2(int[] prices) {
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }
}

