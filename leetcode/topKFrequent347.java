import java.util.*;

/*
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
说明：

你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/top-k-frequent-elements
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class topKFrequent347 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        System.out.println(new topKFrequent347().topKFrequent(nums,k));
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return treeMap.get(integer) - treeMap.get(t1);
            }
        });

        for (int num: nums) {
            if(treeMap.containsKey(num)){
                treeMap.put(num,treeMap.get(num)+1);
            }else{
                treeMap.put(num, 1);
            }
        }

        Iterator<Integer> iterator = treeMap.keySet().iterator();
        while (iterator.hasNext()){
            int key = iterator.next();
            if(priorityQueue.size() < k){
                priorityQueue.add(key);
            }else{
                if (treeMap.get(priorityQueue.peek()) < treeMap.get(key)){
                    priorityQueue.poll();
                    priorityQueue.add(key);
                }
            }
        }
        List<Integer> list = new ArrayList<Integer>(priorityQueue);
        return list;
    }

}
