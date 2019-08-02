//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Question_04 {
//    public int Soulustion(int []nums){
//        int []sum=new int[nums.length];
//        int s=0;
//        int flag=0;
//        int count0=0;
//        for(int i=0;i<nums.length;i++){
//            s+=nums[i];
//            sum[i]=s;
//            if(nums[i]<0){
//                flag=1;
//                count0++;
//            }
//        }
//        if(flag==0)return sum[nums.length-1];
//        if(count0==nums.length){
//            Arrays.sort(nums);
//            return nums[nums.length-1];
//        }
//        int max=Integer.MIN_VALUE;
//        for(int i=1;i<nums.length;i++){
//            for(int j=i-1;j>=0;j--){
//                int temp=sum[i]-sum[j];
//                int count=0;
//                for(int k=j+1;k<=i;k++){
//                    if(nums[k]<0)count+=nums[k];
//                }
//                if(temp-count>max)max=temp-count;
//            }
//        }
//        for(int i=1;i<nums.length;i++){
//            int temp=sum[i];
//            for(int k=0;k<i;k++){
//                if(nums[k]<0)temp-=nums[k];
//            }
//            if(max<temp)max=temp;
//        }
//        return max;
//    }
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            int n=sc.nextInt();
//            if(n<=0)System.out.println(0);
//            else{
//                int []nums=new int[n];
//                for(int i=0;i<n;i++){
//                    nums[i]=sc.nextInt();
//                }
//                Question_04 q=new Question_04();
//                System.out.println(q.Soulustion(nums));
//            }
//        }
//    }
//}