import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


public class jingdong {

	public static void main(String[] args) {
		Integer i = Integer.valueOf(1234);
		Integer j = Integer.valueOf(1234);
		System.out.println(i==j);
	}
	public static void fun1(){
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()){
			int n = scanner.nextInt();
			int[] h = new int[n];

			for (int i = 0; i < n; i++) {
				h[i] = scanner.nextInt();
			}

			System.out.println(maxChunksToSorted(h));
		}
	}

	public static int maxChunksToSorted(int[] arr) {
		int[] a = Arrays.copyOf(arr,arr.length);
		int[] a_cnt=new int[arr.length];
		Arrays.fill(a_cnt,1);
		Arrays.sort(a);
		for (int i=1;i<a.length;i++)
		{
			if(a[i]==a[i-1])
			{
				a_cnt[i]=a_cnt[i-1]+1;
			}
		}

		int res=0,max=0,cnt=0;
		for (int i=0;i<arr.length;i++)
		{
			if(max==arr[i])cnt++;
			else if(max<arr[i])
			{
				cnt=1;
				max=arr[i];
			}
			if(max==a[i]&&cnt==a_cnt[i])
			{
				res++;
			}
		}
		return res;
	}


}