/*
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class findKthLargest215 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        System.out.println(new findKthLargest215().findKthLargest(nums,k));
    }
    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length-1;
        return quickSelect(nums,l,r,k);
    }

    public static int quickSelect(int[] nums, int l, int r, int k) {
        int i = l, j = r;
        while(i <= j){
            int pos = partition(nums, i, j);
            System.out.println(pos);
            if(pos + 1 == k){
                return nums[pos];
            }else if(pos+1 < k){
                i = pos+1;
            }else{
                j = pos-1;
            }
        }
        return -1;
    }

    public static int partition(int[] nums, int i, int j) {
        int l = i-1;
        int povit = nums[j];
        for (int k = i; k < j; k++) {
            if(nums[k] > povit){
                swap(nums,++l,k);
            }
        }
        swap(nums,++l,j);
        return l;
    }

    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
