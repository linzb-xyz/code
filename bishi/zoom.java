import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class zoom {
	public static void main(String[] args) {
		fun2();
	}
	/*
accddeffss
a_1_c_2_d_2_e_1_f_2_s_2
	 */
	public static void fun1(){
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()){
			String s = scanner.nextLine();
			int i = 0;
			StringBuffer sb = new StringBuffer();
			while (i < s.length()){
				char temp = s.charAt(i);
				sb.append(temp);
				int j = i+1;
				while (j < s.length() && temp == s.charAt(j)){
					j++;
				}
				sb.append("_");
				sb.append(j-i);
				if(j < s.length()){
					sb.append("_");
				}
				i = j;
			}
			System.out.println(sb.toString());
		}
	}

/*
10
1,2,3,4,5,6,7,8,9,10

{0=[10], 1=[2, 8], 2=[3, 6, 9], 3=[1, 4, 7], 4=[5]}
 */
	public static void fun2(){
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()){
			int n = scanner.nextInt();
			String s = scanner.next();
			String[] strings = s.split(",");
			int[] arr = new int[strings.length];
			int[] or = new int[strings.length];
			for (int i = 0; i < strings.length; i++) {
//				System.out.println(strings[i]);
				arr[i] = Integer.valueOf(strings[i]);
				or[i] = arr[i] ^ n;
			}
			List[] lists = new List[32];

			for (int i = 0; i < strings.length; i++) {
				int c = count(or[i]);
				if(lists[c] == null){
					lists[c] = new ArrayList();
				}
				lists[c].add(arr[i]);
			}

			StringBuffer sb = new StringBuffer();
			sb.append("{");
			for (int i = 0; i < lists.length; i++) {
				if(lists[i]!=null){
					sb.append(i+"=[");
					Iterator iterator = lists[i].iterator();
					while (iterator.hasNext()){
						sb.append(iterator.next());
						if(iterator.hasNext()){
							sb.append(", ");
						}
					}
					sb.append("]");
					sb.append(", ");

				}
			}
			sb.delete(sb.length()-2,sb.length());
			sb.append("}");
			System.out.println(sb.toString());
		}
	}

	public static int count(int x){
	    int count = 0;
	    while(x!=0){
	    	if((x&1) == 1){
	    		count++;
		    }
		    x = x >>> 1;
	    }
	    return count;
	}
}




