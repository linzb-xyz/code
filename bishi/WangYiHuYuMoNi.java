import java.math.BigInteger;
import java.util.Scanner;

public class WangYiHuYuMoNi {
    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        String s2 = scanner.nextLine();
//
//        String s1 = scanner.next();
//
//        System.out.println(s1);
//        System.out.println(s2);
        fun3();
//        fun2();
//        fun3();
//        fun4();
//        fun5();
//        fun6();
    }

    /*
    新个税计算
输入
5
5000
15000
50000
8025
10001

输出:
0
790
9090
93
290
     */
    public static void fun1(){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t ; i++) {
            int n = scanner.nextInt();
            System.out.println(tax(n));
        }
    }

    public static long tax(int n){
        int need = n - 5000;
        if(need <= 0){
            return 0;
        }
        if(need <= 3000){
            return Math.round(need * 0.03);
        }else if(need <= 12000){
            return 90 + Math.round((need-3000)*0.1);
        }else if(need <=25000){
            return 990+ Math.round((need-12000)*0.2);
        }else if(need <=35000){
            return 3590 + Math.round((need-25000)*0.25);
        }else if(need <=55000){
            return 6090 + Math.round((need-35000)*0.3);
        }else if(need <=80000){
            return 12090 + Math.round((need-55000)*0.35);
        }else {
            return 20840+ Math.round((need-80000)*0.45);
        }

    }

    /*
字符串中有 4 个及以上连续的字母可以用"-"缩写

输入:
3
DCBA
ZABCDEFGX
XYZABCDMMMGHIJKLRST

输出:
DCBA
ZA-GX
XYZA-DMMMG-LRST
     */
    public static void fun2(){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            int cur = 0;
            while (cur < chars.length){
                if(chars[cur] >= 'X' || cur+4 > s.length() || chars[cur+1] != chars[cur] + 1 ){
                    sb.append(chars[cur++]);
                }else {
                    int len = 1;
                    while (cur+len+1 < s.length() && chars[cur+len+1] == chars[cur+len]+1){
                        len++;
                    }
                    if(len < 3){
                        sb.append(chars[cur++]);
                    }else{
                        sb.append(chars[cur]);
                        sb.append("-");
                        sb.append(chars[cur+len]);
                        cur = cur + len+1;
                    }
                }
            }
            System.out.println(sb.toString());
        }

    }

/*
同一个数的两种不同进制的字符连在一起了,输出这个数

进制1  进制2
输入:
3
5 2 113221101000101
13 7 1016
4 12 2222248A

输出:

 */
////中间过程中临时超出了 int/long 的取值范围, parseInt 抛出异常, 牛客网却提示数组越界等问题.
////数据范围比较大,中间结果可能超出 int/long 范围时用 BigInteger, 牛客网提示数组越界时,也检查一下那些 API 可能抛出异常.
    public static void fun3(){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
//            注意在next()、nextInt()与nextLine()一起使用时，next()、nextInt()往往会读取部分数据（会留下"\n"或者空格之后的数据）。
//            String z = scanner.nextLine();  输入: 5 2 113221101000101  其中nextInt()只读取数值, 前两个数被x,y接收, 然后后面的空格+数字+回车(" 113221101000101\n")被z接收,则 z = " 113221101000101",报错.
            String z = scanner.next();
            System.out.println(z);

            int cur = 1;
            if(x < y){
                while ( cur < z.length()){
                    if(new BigInteger(z.substring(0,cur), x).equals(new BigInteger(z.substring(cur), y))){
                        break ;
                    }
                    cur++;
                }
            }else{
                cur = z.length()-1;
                while ( cur > 0 ){
                    if(new BigInteger(z.substring(0,cur), x).equals(new BigInteger(z.substring(cur), y))){
                        break;
                    }
                    cur--;
                }
            }
            System.out.println(new BigInteger(z.substring(0,cur), x));
        }

    }

//    public static void fun3(){
//        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt();
//
//        for (int i = 0; i < t; i++) {
//            int x = scanner.nextInt();
//            int y = scanner.nextInt();
//            String z = scanner.next();
//
//            if(x < y){
//                int cur = 1;
//                char baseMax = x < 10 ? (char)('0'+ x):(char)('A'+x-10);
//                while ( cur < z.length() &&( z.charAt(i) < '0' + y||z.charAt(cur) < baseMax)){
//                    if(Integer.parseInt(z.substring(0,cur), x) == Integer.parseInt(z.substring(cur,z.length()), y)){
//                        System.out.println(Integer.parseInt(z.substring(0,cur), x));
//                        break ;
//                    }
//                    cur++;
//                }
//            }else{
//                int cur = z.length()-1;
//                char baseMax = y < 10 ? (char)('0'+ y):(char)('A'+y-10);
//                while ( cur >= 0 && ( z.charAt(i) < '0' + y||z.charAt(cur) < baseMax)){
//                    if(Integer.parseInt(z.substring(0,cur), x) == Integer.parseInt(z.substring(cur,z.length()), y)){
//                        System.out.println(Integer.parseInt(z.substring(0,cur), x));
//                        break;
//                    }
//                    cur--;
//                }
//            }
//
//        }
//
//    }






}