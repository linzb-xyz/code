
/***

 "前缀": 指除了最后一个字符以外，一个字符串的全部头部组合；
 "后缀": 指除了第一个字符以外，一个字符串的全部尾部组合。

 next 数组各值的含义：代表当前字符之前的字符串中，有多大长度的相同前缀后缀。
 例如如果next [j] = k，代表j 之前的字符串中有最大长度为k 的相同前缀后缀。

 *
 */


public class Code_01_KMP {

	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int si = 0;
		int mi = 0;
		int[] next = getNextArray(ms);
		while (si < ss.length && mi < ms.length) {
			if (ss[si] == ms[mi]) {
				si++;
				mi++;
			} else if (next[mi] == -1) {
				si++;
			} else {
				mi = next[mi];
			}
		}
		return mi == ms.length ? si - mi : -1;
	}

	public static int[] getNextArray(char[] ms) {
		//ms长度为1,则直接返回{-1}数组
		if (ms.length == 1) {
			return new int[] { -1 };
		}

		//next 数组长度等于 ms 的长度
		int[] next = new int[ms.length];

		next[0] = -1;
		next[1] = 0;

		//pos是当前来到的位置
		int pos = 2;

		//cn是next数组的值,是跳到的位置
		int cn = 0;
		while (pos < next.length) {
			if (ms[pos - 1] == ms[cn]) {  //当前位置前一个字符,等于 cn 位置字符, 则当前位置可以跳到 cn+1 位置.
				next[pos++] = ++cn;
			} else if (cn > 0) {    //cn还能往前跳
				cn = next[cn];
			} else {                //cn==0 了,没法往前跳了
				next[pos++] = 0;
			}
		}
		return next;
	}

	public static void main(String[] args) {
		String str = "abcabcababaccc";
		String match = "ababa";
		System.out.println(getIndexOf(str, match));

	}

}
