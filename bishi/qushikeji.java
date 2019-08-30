import java.math.BigDecimal;
import java.util.Scanner;

public class qushikeji {
        public static void main(String[] args) {

        }


        public static void fun1(){
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNext()){
                BigDecimal a = scanner.nextBigDecimal();
                BigDecimal b = scanner.nextBigDecimal();

                System.out.println(a.add(b));

            }
        }

    public static void fun2(){
        Scanner sc = new Scanner(System.in);

        String strValueSequences = sc.nextLine();
        String strChargeNum = sc.nextLine();

        String sum = process(strValueSequences, strChargeNum);
        System.out.println(sum);
    }

    /**
     * @param x 商品金额
     */
    public static void test2(int n){
        //纸币面额
        int money[]={1,5,10,20,50,100};
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i = 0;i < 6;++i){
            for(int j = money[i];j <= n;++j){
                dp[j] =(dp[j]+dp[j-money[i]]);
            }
        }
        System.out.println(dp[n]);
    }

    private static String process(String num1, String num2)
    {
        String[] strings = num1.split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        int x = Integer.parseInt(num2);

        int sum = 0;
        //符合条件的组合次数
        int count = 0;

        //硬币面额
        int[] a = {1, 5, 10, 20, 50, 100};

        for (int i = 0; i <= x / a[5] && i <= nums[5]; i++) {
            //100元可能出现的张数
            for (int j = 0; j <= x / a[4] && j <= nums[4]; j++) {
                //50元可能出现的张数
                for (int k = 0; k <= x / a[3] && k <= nums[3]; k++) {
                    //20元可能出现的张数
                    for (int l = 0; l <= x / a[2] && l <= nums[2]; l++) {
                        //10元可能出现的张数
                        for (int m = 0; m <= x / a[1] && m <= nums[1]; m++) {
                            //5元可能出现的张数
                            for(int n=0;n<x/1 && n <= nums[0]; n++){
                                //1元可能出现的张数
                                sum = i * a[5] + j * a[4] + k * a[3] + l * a[2] + m * a[1] + n * a[0];

                                if (sum == x) {
                                    count = count + i + j + k + l + m + n;
                                }else if(sum > x){
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        if(count == 0){
            return "-1";
        }
        return Integer.toString(count);
    }

    public static class Node{
        char c;
        int count;

        public Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
    private static int calEncodeLen(String mystr)
    {
        int len = 74;
        //Please write your code here
        return len;
    }





}




