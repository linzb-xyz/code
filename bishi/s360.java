import java.util.*;

public class s360 {
	public static void main(String[] args) {
		fun2();
	}

	/*
2 2
2 1
1 1
	 */
	public static void fun1(){
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()){
			int n = scanner.nextInt();
			int m = scanner.nextInt();

			int[][] arr = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = scanner.nextInt();
				}
			}
			System.out.println(surfaceArea(arr));
		}
	}

	public static long surfaceArea(int[][] grid) {
		int[] dr = new int[]{0, 1, 0, -1};
		int[] dc = new int[]{1, 0, -1, 0};

		int N = grid.length;
		int M = grid[0].length;
		long ans = 0;

		for (int r = 0; r < N; ++r)
			for (int c = 0; c < M; ++c)
				if (grid[r][c] > 0) {
					ans += 2;
					for (int k = 0; k < 4; ++k) {
						int nr = r + dr[k];
						int nc = c + dc[k];
						int nv = 0;
						if (0 <= nr && nr < N && 0 <= nc && nc < M)
							nv = grid[nr][nc];

						ans += Math.max(grid[r][c] - nv, 0);
					}
				}

		return ans;
	}

	static class Node implements Comparable<Node>{
		int i, j;
		Node(int i,int j) {
			this.i = i;
			this.j = j;
		}
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Node node = (Node) o;
			return i == node.i && j == node.j;
		}
		@Override
		public int hashCode() {
			return Objects.hash(i,j);
		}

		@Override
		public String toString() {
			return "Node{" +
					"i=" + i +
					", j=" + j +
					'}';
		}

		@Override
		public int compareTo(Node o) {
			return i == o.i || j == o.j ? 0 : -1;
		}
	}
/*
5 5
4 4 1 1 1
4 3 0 1 2
 */
	public static void fun2(){
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()){
			int n = scanner.nextInt();
			int m = scanner.nextInt();

			int[] num1 = new int[n];
			int[] num2 = new int[n];
			for (int i = 0; i < n; i++) {
				num1[i] = scanner.nextInt();
			}
			for (int i = 0; i < n; i++) {
				num2[i] = scanner.nextInt();
			}

			HashMap<Node, Integer> hashMap = new HashMap<Node, Integer>();
			TreeSet<Node> treeSet = new TreeSet<Node>();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					hashMap.put(new Node(i,j), (num1[i]+num2[j])%m);
				}
			}
			List<Map.Entry<Node, Integer>> list = new ArrayList<Map.Entry<Node, Integer>>(hashMap.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<Node, Integer>>() {
				@Override
				public int compare(Map.Entry<Node, Integer> o1, Map.Entry<Node, Integer> o2) {
					return (o2.getValue() - o1.getValue());
				}
			});

			for(Map.Entry<Node, Integer> t:list) {
				System.out.println(t.getKey()+":"+t.getValue());
			}

			for(Map.Entry<Node, Integer> t:list) {
				if(treeSet.size() >= n){
					break;
				}
				if(!treeSet.contains(t.getKey())) {
					System.out.print(t.getValue() + " ");
					treeSet.add(t.getKey());
				}
			}
			System.out.println();

			System.out.println(treeSet);

			System.out.println(new Node(2,3).compareTo(new Node(2,1)));
			treeSet.remove(new Node(2,1));
			System.out.println(treeSet.contains(new Node(2,1)));
		}
	}
}




