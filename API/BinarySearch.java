import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/8/12
 */

public class BinarySearch {
	public static void main(String[] args) {
		Integer[] a = new Integer[]{1,2,3,4,5,6,7,8};
		System.out.println(BinarySearch.binarySearch(a,5));
		System.out.println(Arrays.binarySearch(a, 5));
	}


	public static <T extends Comparable<T>> int binarySearch(T[] arr, T target){
		int i = 0, j = arr.length-1;
		while (i<=j){		// 在[i,j]闭区间里找,当[i,i]时依然有效
			int mid = i + (j-i)/2;
//			int mid = (i+j) >>> 1;

			int cmp = arr[mid].compareTo(target);

			if(cmp == 0){
				return mid;
			}else if(cmp > 0){
				j = mid-1;
			}else {
				i = mid+1;
			}
		}
		return -1;
	}
}
