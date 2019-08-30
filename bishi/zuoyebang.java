import java.util.*;

public class zuoyebang {
	public static void main(String[] args) {
		fun3();
	}
	/*
	时间复杂度: O(n)
	[1,3,5,7,9,11]
	10
	 */
	
	public static void fun1(){
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()){
			String s = scanner.next();
			int target = scanner.nextInt();

			String[] strings = s.replace("[","").replace("]","").split(",");
			int[] arr = new int[strings.length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.valueOf(strings[i]);
			}

			int i = 0, j = arr.length-1;
			while (i < j){
				int temp = arr[i] + arr[j];
				if(temp == target){
					System.out.println(arr[i]+","+arr[j]);
					i++;
					j--;
				}else if(temp < target){
					i++;
				}else {
					j--;
				}
			}
		}
	}

/*
I am a student.
 */
	public static void fun2() {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String in = sc.nextLine();
			char[] arr = in.toCharArray();
			if (arr == null || arr.length == 0) {
				System.out.println();
			}
			int start = 0;
			int end = arr.length - 1;
			while (start < end) {
				swap(arr, start++, end--);
			}
			System.out.println(new String(arr));
		}
	}

	public static void swap(char[] s, int a, int b) {
		char temp = s[a];
		s[a] = s[b];
		s[b] = temp;
	}

	/*
	[100, 4, 200, 1, 2, 3]
	 */
	public static void fun3(){
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()){
			String s = scanner.nextLine();
			String[] strings = s.replace("[","").replace("]","").replace(" ", "").split(",");
			int[] arr = new int[strings.length];
			TreeSet<Integer> treeSet = new TreeSet<>();
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.valueOf(strings[i]);
				treeSet.add(arr[i]);
			}

			Iterator<Integer> iterator = treeSet.iterator();
			int max = 1;
			int temp = 1;
			int pre = 0;
			if(!iterator.hasNext()) {
				System.out.println(0);

			}else {
				pre = iterator.next();
				while (iterator.hasNext()){
					//System.out.println(pre);
					int cur = iterator.next();
					if(cur == pre+1){
						temp++;
					}else {
						max = Math.max(temp,max);
						temp = 1;
					}
					pre = cur;
				}
				System.out.println(max);
			}
		}
	}
	
	public static void fun4(){
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		String[] strings = s.replace("[", "").replace("]", "").replace(" ","").split(",");
		int[] arr = new int[strings.length];
		Set<Integer> num_set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.valueOf(strings[i]);
			num_set.add(arr[i]);
		}

		int longestStreak = 0;

		for (int num : num_set) {
			if (!num_set.contains(num - 1)) {
				int currentNum = num;
				int currentStreak = 1;

				while (num_set.contains(currentNum + 1)) {
					currentNum += 1;
					currentStreak += 1;
				}

				longestStreak = Math.max(longestStreak, currentStreak);
			}
		}
		System.out.println(longestStreak);
	}


}




