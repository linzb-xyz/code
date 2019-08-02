import java.util.Arrays;

/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/7/30
 */

public class Sort {
    //O(n^2)的基本排序方法中: 冒泡,选择,插入. 在大多数情况下，假设数据量比较小或基本有序时，插入排序是三种算法中最好的。
    public static void main(String[] args) {
        int[] x;
        int[] nu = new int[0];
        System.out.println(nu.length);

        int[] arr = new int[]{3,3,9,1,4,7,2,8};
        swap(arr, 0,1);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
//        bubbleSort(arr);
//        System.out.println("arr = " + Arrays.toString(arr));

//        insertionSort(arr);
//        System.out.println("arr = " + Arrays.toString(arr));

//        SelectionSort(arr);
//        System.out.println("arr = " + Arrays.toString(arr));

//        mergeSort(arr);
//        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));

        quickSort(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }
    
    /**先排数组末尾
     * 时间复杂度: 经典冒泡{ 比较次数都是O(n^2), 交换次数最坏情况 O(n^2) 平均复杂度 O(n^2)} 优化冒泡{最优情况复杂度 O(n)}
     * 经典冒泡排序: 先判断基本条件, 两层循环,外层循环i从arr.length-1 到 0, 内层循环j从0到i;
     * 优化冒泡:    冒泡排序如果能在内部循环第一次运行时，使用一个旗标来表示有无需要交换的可能，也可以把最优情况下的复杂度降低到O(n)。
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length <= 1)
            return ;
        for (int i = arr.length-1; i >= 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    /**先排数组头
     * 经典插入排序: 先判断基本条件, 两层循环, 外层循环i从1 到 arr.length, 内层循环 j 从 i到0
     * 二分查找插入排序: 可以采用二分查找法来减少比较操作的数目
     * @param arr
     */
    public static void insertionSort(int[] arr){
        if(arr == null || arr.length <= 1){
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >0 && arr[j] < arr[j-1]; j--) {
                swap(arr, j, j-1);
            }
        }
    }
    /***
     * 优化插入排序: 最好情况时间复杂度 O(n), 平均 O(n^2)
     *
     * 优点
     *      虽然复制的次数和其他的排序的交换次数一样，但复制比不如交换那么费时间。
     *      所以总的来说，一般情况下，插入排序比选择排序快一倍。
     * @param array
     */
    public void insertionSort1(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];    //复制
                j--;
            }
            array[j + 1] = key;
        }
    }

    /**
     * 选择排序优点:
     *      选择排序把交换次数降低到最低，但是比较次数还是挺大的。
     *      当数据量小，并且交换数据相对于比较数据更加耗时的情况下，可以应用选择排序。
     * @param arr
     */
    public static void SelectionSort(int[] arr){
        if(arr == null || arr.length <= 1){
            return ;
        }

        int pos;
        for (int i = 0; i < arr.length-1; i++) {
            pos = i;
            for (int j = i+1; j < arr.length; j++) {
                pos = arr[j] > arr[pos] ? pos : j;
            }
            swap(arr, i, pos);
        }

    }

    public static void mergeSort(int[] arr){
        if(arr==null || arr.length <= 1){
            return ;
        }
        mergeSort(arr,0,arr.length-1);
    }

    public static void mergeSort(int[] arr, int left, int right){
        if(left == right){
            return ;
        }
        int middle = left + (right-left)/2;
        mergeSort(arr, left, middle);
        mergeSort(arr, middle+1, right);
        merge(arr, left, middle, right);
    }

    public static void merge(int[] arr, int left, int middle, int right){
       int[] help = new int[right-left+1];
       int i = 0;
       int p1 = left;
       int p2 = middle+1;

       while (p1 <= middle && p2 <= right){
           help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
       }
       while (p1 <= middle){
           help[i++] = arr[p1++];
       }
       while (p2 <= right){
           help[i++] = arr[p2++];
       }
       for (int j = 0; j < help.length; j++) {
           arr[left+j] = help[j];
       }
    }

    public static void quickSort1(int[] arr, int left, int right){
        if(arr == null || arr.length <= 1 || left >= right){
            return ;
        }
        int l = left, r = right;
        int pivot = arr[l + (r-l)/2];
        while(l <= r){
            while(arr[l] < pivot){
                l++;
            }
            while(arr[r] > pivot){
                r--;
            }

            if(l < r){
                swap(arr, l,r);
                l++;
                r--;
            }else if(l==r){
                l++;
            }
        }
        quickSort1(arr, left, r);
        quickSort1(arr, l, right);

    }

    public static void quickSort(int[] arr){
        if(arr == null || arr.length <=1){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    public static void quickSort(int[] arr, int l, int r){
        if (l < r) {
            swap(arr, l + (int)(Math.random()*(r - l + 1)), r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l,p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }
    public static int[] partition(int[] arr, int l, int r){
        int less = l - 1;
        int cur = l;
        int more = r;
        while(cur < more){
            if(arr[cur] < arr[r]){
                swap(arr, ++less, cur++);
            }else if(arr[cur] > arr[r]){
                swap(arr, --more, cur);
            }else{
                cur++;
            }
        }
        swap(arr, more, r);
        return new int[]{ less + 1, more};
    }


    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }
    //有bug: 自己跟自己交换时, 都为 0
//    public static void swap(int[] arr, int i, int j){
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
//    }
}
