import java.util.*;

/*
给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
示例 1:
输入:
"tree"
输出:
"eert"
解释:
'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。

示例 2:
输入:
"cccaaa"
输出:
"cccaaa"
解释:
'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
注意"cacaca"是不正确的，因为相同的字母必须放在一起。

示例 3:
输入:
"Aabb"
输出:
"bbAa"
解释:
此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
注意'A'和'a'被认为是两种不同的字符。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class frequencySort451 {

    public static void main(String[] args) {
        System.out.println(new frequencySort451().frequencySort("tree"));
    }
    public static class Node implements Comparator<Node> {
        char s;
        int count;

        public Node() {
        }

        public Node(char s, int count) {
            this.s = s;
            this.count = count;
        }

        @Override
        public int compare(Node node, Node t1) {
            return t1.count - node.count;
        }
    }
    public String frequencySort(String s) {
        HashMap<Character, Node> map = new HashMap<Character, Node>();
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length ; i++) {
            if(map.containsKey(str[i])){
                map.get(str[i]).count++;
            }else{
                map.put(str[i], new Node(str[i], 1));
            }
        }

        List<Node> list = new ArrayList<>(map.values());
        list.sort(new Node());
        StringBuffer stringBuffer = new StringBuffer();
        for (Node node : list){
            System.out.println("node.count = " + node.count);
            for (int i = 0; i < node.count ; i++) {
                stringBuffer.append(node.s);
            }
        }
        return stringBuffer.toString();
    }

}
