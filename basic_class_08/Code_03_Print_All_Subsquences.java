package class_08;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印一个字符串的全部子序列，包括空字符串
 * 思路: 暴力递归
 *      比如 字符串 abc
 *      0       1       2
 *                      要c      => abc
 *              要b
 *                      不要c    => ab
 *      要a
 *                      要c      => ac
 *              不要 b
 *                      不要c    => a
 *
 *                      要c      => bc
 *              要b
 *                      不要c    => b
 *      不要a
 *                      要c      => c
 *              不要 b
 *                      不要c    => ""
 */
public class Code_03_Print_All_Subsquences {

	public static void printAllSubsquence(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0);
	}

	public static void process(char[] chs, int i) {
	    //终止位置
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
			return;
		}

		//要
		process(chs, i + 1);

		//不要
		char tmp = chs[i];
		chs[i] = 0;
		process(chs, i + 1);
		chs[i] = tmp;
	}
	
	public static void function(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0, new ArrayList<Character>());
	}
	
	public static void process(char[] chs, int i, List<Character> res) {
		if(i == chs.length) {
			printList(res);
		}
		List<Character> resKeep = copyList(res);
		resKeep.add(chs[i]);
		process(chs, i+1, resKeep);
		List<Character> resNoInclude = copyList(res);
		process(chs, i+1, resNoInclude);
	}
	
	public static void printList(List<Character> res) {
		// ...;
	}
	
	public static List<Character> copyList(List<Character> list){
		return null;
	}
	

	public static void main(String[] args) {
		String test = "abc";
		printAllSubsquence(test);
	}

}
