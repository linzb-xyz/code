//package class_08;

/***
 * 汉诺塔问题 打印n层汉诺塔从最左边移动到最右边的全部过程  O(2^n)
 * T(n) = T(n-1) + 1 + T(n-1)
 */
public class Code_02_Hanoi {

	public static void hanoi(int n) {
		if (n > 0) {
			func(n, n, "left", "mid", "right");
		}
	}

    /**
     *
     * @param n  表示当前柱子有 n 个圆盘
     * @param down  表示当前圆盘号, 圆盘号从上到下 1~n
     * @param from  
     * @param help
     * @param to
     * 
     */
	public static void func(int n, int down, String from, String help, String to) {
		if (n == 1) {
			System.out.println("move " + down + " from " + from + " to " + to);
		} else {
		    //将当前from柱子上面的 n-1 个圆盘,借助 to 柱子,移动到 help 柱子
			func(n - 1, down - 1, from, to, help);
            //将from柱子上面的剩余的1个圆盘,移动到 to 柱子
			func(1, down, from, help, to);
            //将help柱子上面的 n-1 个圆盘,借助 from 柱子,移动到 to 柱子
			func(n - 1, down - 1, help, from, to);
		}
	}

	public static void moveLeftToRight(int N) {
		if (N == 1) {
			System.out.println("move 1 from left to right");
		}
		moveLeftToMid(N - 1);
		System.out.println("move " + N + "from left to right");
		moveMidToRight(N - 1);
	}

	public static void moveRightToLeft(int N) {

	}

	public static void moveLeftToMid(int N) {
		if (N == 1) {
			System.out.println("move 1 from left to mid");
		}
		moveLeftToRight(N - 1);
		System.out.println("move " + N + "from left to mid");
		moveRightToMid(N - 1);
	}

	public static void moveMidToLeft(int N) {

	}

	public static void moveRightToMid(int N) {

	}

	public static void moveMidToRight(int N) {
		if (N == 1) {
			System.out.println("move 1 from mid to right");
		}
		moveMidToLeft(N - 1);
		System.out.println("move " + N + "from mid to right");
		moveLeftToRight(N - 1);
	}

	public static void main(String[] args) {
		int n = 3;
		hanoi(n);
	}

}
