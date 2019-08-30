import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class beike {
        public static void main(String[] args) {
            fun4();
        }
//        public static void fun5(){
//            Scanner scanner = new Scanner(System.in);
//            while (scanner.hasNext()) {
//                int n = scanner.nextInt();
//                int[] nums = new int[n];
//
//                for (int i = 0; i < n; i++) {
//                    nums[i] = scanner.nextInt();
//                }
//                int[] b = Arrays.copyOf(nums,n);
//                int[] dp1= new int[n];
//                int[] dp2 = new int[n];
//
//                for (int i = 0; i < n; i++) {
//                    dp1[i] = dp1[i-1] + Math.max(0, nums[i-1] - nums[i] +1);
//                    nums[i] = Math.max(nums[i], nums[i-1]+1);
//                }
//                int res = dp1.
//            }
//        }
//
        public static void fun4() {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                int n = scanner.nextInt();
                int[] nums = new int[n];

                for (int i = 0; i < n; i++) {
                    nums[i] = scanner.nextInt();
                }

                int isZero = count(nums);
                int res = isZero;
                while(isZero!= 0){
                    isZero = count(nums);
                    res += isZero;
                }
                System.out.println(res);


            }
        }

        public static int count(int[] nums){
            boolean flag = false;
            int zhengMax = 0;
            int jianMin = 0;
            for (int i = 0; i < nums.length-1; i++) {
                if(flag == false && nums[i] >= nums[i+1]){
                    zhengMax = i;
                    flag = true;
                }else if(flag == true && nums[i] <= nums[i+1]){
                    jianMin = i+1;
                    break;
                }
            }

            if(flag == false) {
                return 0;
            }
//                System.out.println(zhengMax + " aaaa "+ jianMin);
            int count = 0;
            if(nums[zhengMax] < nums[jianMin]) {
                for (int i = zhengMax + 1, j = 1; i < jianMin; i++, j++) {
                    if(nums[jianMin] - nums[zhengMax] > jianMin - zhengMax) {
                        if (i + 1 == jianMin && nums[zhengMax] + j <= nums[jianMin]) {
                            count += nums[jianMin] + 1 - nums[i];
                            nums[i] = nums[jianMin] + 1;
                        } else {
                            count += nums[zhengMax] + j - nums[i];
                            nums[i] = nums[zhengMax] + j;
                        }
                    }else{

                    }
                }
            }else{
                for (int i = jianMin - 1, j = 1; i > zhengMax; i--, j++) {
                    if(i-1 == zhengMax && nums[jianMin]+j <= nums[zhengMax] ){
                        count += nums[zhengMax] + 1 - nums[i];
                        nums[i] = nums[zhengMax] + 1;
                    }else{
                        count += nums[jianMin]+j-nums[i];
                        nums[i] = nums[jianMin]+j;
                    }
                }
            }
            return count;
        }

        public static void fun1(){
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNext()){
                int n = scanner.nextInt();
                long[] nums = new long[n];

                for (int i = 0; i < n; i++) {
                    nums[i] = scanner.nextLong();
                }

                long first = nums[0];
                long second = nums[1];
                long min = Math.abs(nums[0] - nums[1]);

                for (int i = 1; i < nums.length-1; i++) {
                    if(Math.abs(nums[i]-nums[i+1]) < min){
                        min = Math.abs(nums[i]-nums[i+1]);
                        first = nums[i];
                        second = nums[i+1];
                    }
                }

                System.out.println(first+" "+second);

            }
        }

    public static void fun2(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int res = lengthOfLIS(nums);
            System.out.println(res);
        }
    }
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (dp.contains(nums[i])) continue;
            else if (nums[i] > dp.get(dp.size()-1)) dp.add(nums[i]);
            else if (nums[i] < dp.get(dp.size()-1)) {
                int l = 0, r = dp.size()-1;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (dp.get(mid) < nums[i]) l = mid + 1;
                    else r = mid;
                }
                dp.set(r, nums[i]);
            }
        }
        return dp.size();
    }


    public static void fun3(){
        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            Arrays.sort(nums);
            int res = helper(nums);
//            for (int i = 0; i < n -1; i++) {
//                for (int j = i; j < n-1; j++) {
//                    BigDecimal min = nums[j].compareTo(nums[j+1]) > 0 ?nums[j+1]:nums[j];
//                    BigDecimal max = nums[j].compareTo(nums[j+1]) > 0 ?nums[j]:nums[j+1];
//
//                    BigDecimal x = new BigDecimal("0.9");
//                    if( min.compareTo(max.multiply(x)) >= 0 ){
//                            res++;
//                    }
//
//                }
//
//            }
            System.out.println(res);
//        }
    }

    public static int helper(int[] weight){
        int res = 0;
        for (int i = 1; i < weight.length; i++) {
            for (int j = i-1; j >= 0 ; j--) {
                if(weight[j] >= weight[i] * 0.9){
                    res++;
               }else{
                    break;
                }
            }
        }
        return res;
    }


}




