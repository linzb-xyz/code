/**
 * 马拉车问题
 * 求字符串中的最长回文的长度
 * 时间复杂度: O(n)
 *
 * 回文直径
 * 辅助数组: 存储字符串中以每个字符为中心的回文半径
 * 辅助变量 R 回文右边界: 记录字符串中以每个字符为中心的最大回文半径
 * 辅助变量 C : 第一次到达该回文右边界的中心位置
 *
 * 情况分四种:
 * 	1.
 * 	2.
 * 	3.
 * 	4.
 */
public  class Code_04_Manacher {

    /**
     *
     * @param str 比如 abcde
     * @return 返回 #a#b#c#d#e#
     */
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];
        int index = -1;
        int pR = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != charArr.length; i++) {
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLcpsLength(str1));
    }

}