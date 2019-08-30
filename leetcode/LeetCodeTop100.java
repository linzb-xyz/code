import java.util.*;

/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/8/11
 */

public class LeetCodeTop100 {
	public static void main(String[] args) {
//		fun2();
	}

	//1. 两数之和
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap();

		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(target- nums[i])){
				return new int[]{map.get(target-nums[i]),i};
			}
			map.put(nums[i],i);
		}
		return new int[]{};
	}


	//2. 两数相加
	public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(-1), cur = dummyHead;

		int addOne = 0;
		while(l1!=null || l2!=null){
			int val1 = l1 == null? 0 : l1.val;
			int val2 = l2 == null? 0 : l2.val;
			int value = val1 + val2 + addOne;
			addOne = value/10;
			value = value%10;
			cur.next = new ListNode(value);
			cur = cur.next;
			if(l1!=null) l1 = l1.next;
			if(l2!=null) l2 = l2.next;
		}

		if(addOne == 1){
			cur.next = new ListNode(1);
		}
		return dummyHead.next;
	}

	//3. 无重复字符的最长子串
	public int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet();
		int max = 0;
		int removeCur = 0;
		char[] chars =  s.toCharArray();
		for(char c : chars) {
			if(set.contains(c)){
				max = Math.max(max, set.size());
				while(set.contains(c) && !set.isEmpty()){
					set.remove(chars[removeCur++]);
				}
			}
			set.add(c);
		}
		max = Math.max(max, set.size());
		return max;
	}
	//4. 寻找两个有序数组的中位数
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length, len2 = nums2.length;
		int len = len1 + len2;
		if(nums1 == null){
			return (len2&1) == 1? nums2[len2/2] : (nums2[len2/2] + nums2[len2/2-1])/2;
		}
		if(nums2 == null){
			return (len1&1) == 1? nums1[len1/2] : (nums1[len1/2] + nums1[len1/2-1])/2;
		}
		if(nums2[0] >= nums1[len1-1]){
			if((len&1) == 1){
				int mid = len / 2;
				return len1-1 >= mid ? nums1[mid] : nums2[mid-len1+1];
			} else{
				int mid1 = len/2, mid2 = len/2+1;
				return len1-1 >= mid2 ? (nums1[mid1] + nums1[mid2])/2 : (len1-1 < mid1 ?  (nums2[mid1-len1+1] + nums2[mid2-len1+1])/2 : (nums1[len1-1]+nums2[0])/2);
			}
		} else if(nums1[0] >= nums2[len2-1]){
			if((len&1) == 1){
				int mid = len / 2;
				return len2-1 >= mid ? nums2[mid] : nums1[mid-len2+1];
			} else{
				int mid1 = len/2, mid2 = len/2+1;
				return len2-1 >= mid2 ? (nums2[mid1] + nums2[mid2])/2 : (len2-1 < mid1 ?  (nums1[mid1-len2+1] + nums1[mid2-len2+1])/2 : (nums2[len2-1]+nums1[0])/2);
			}
		}
		return 0;
	}

	//5. 最长回文子串
	public String longestPalindrome(String s) {
		int len = s.length();
		boolean[][] dp = new boolean[len][len];
		int resI = 0, resJ = 0, maxLen = 0;

		char[] str = s.toCharArray();

		for (int i = 0; i < len; i++) {
			dp[i][i] = true;
		}
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < len-1; j++) {
				dp[j][j+i] =  dp[j+1][j+i-1] && (str[j] == str[i]);
				if(dp[j][j+i] && i>maxLen){
					resI = j;
					resJ = i;
					maxLen = i;
				}
			}
		}
		return s.substring(resI, resJ+1);
	}


}
