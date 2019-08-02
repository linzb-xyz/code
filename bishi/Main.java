import java.util.*;

public class Main {
    public static void main(String[] args) {
        fun4();
//        fun2();
//        fun3();
//        fun4();
//        fun5();
//        fun6();
    }


    public static int maxsequence3(int[] arr, int len)
    {
        if(arr == null || arr.length < 1)
            return -1;

        int maxsum, maxhere;
        maxsum = maxhere = arr[0];   //初始化最大和为a【0】
        for (int i=1; i<len; i++) {
            if (maxhere <= 0)
                maxhere = arr[i];  //如果前面位置最大连续子序列和小于等于0，则以当前位置i结尾的最大连续子序列和为a[i]
            else
                maxhere += arr[i]; //如果前面位置最大连续子序列和大于0，则以当前位置i结尾的最大连续子序列和为它们两者之和
            if (maxhere > maxsum) {
                maxsum = maxhere;  //更新最大连续子序列和
            }
        }
        return maxsum;
    }

    public static void bucketSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int[] bucket = new int[1001];
        for (int i = 1; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }
    }

    /**
     * 给定一个无序的整型数组A[n],数组大小大于等于3,允许有值相同的元素;请设计算法找到该数组排序后第三大的元素值并输出.
     * 输入描述:
     * 一个非空的整数数组(至少有3个元素,可正可负)
     * 输出描述:
     * 第三大的元素值
     * 输入:
     * [1,2,3,4,5]
     * 输出:
     * 3
     */
    public static void fun1(){

        Scanner in = new Scanner(System.in);

        String inStr = in.nextLine();
        String[] strNum = inStr.substring(1,inStr.length()-1).split(",");

        int[] num = new int[strNum.length];
        for (int i = 0; i < num.length; i++) {
          num[i] = Integer.parseInt(strNum[i]);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : num ) {
            priorityQueue.add(i);
        }

        priorityQueue.poll();
        priorityQueue.poll();
        System.out.println(priorityQueue.poll());
    }

    public static void fun2(){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] arr = new int[k][n];
        for (int i = 0; i < k ; i++) {
            for (int j = 0; j < n ; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }


    }



    public static class Point {
        int x, k, index;
        Point(int x, int k, int index) {
            this.x = x;  this.k = k;  this.index = index;
        }
    }
    public static void fun3() {
        Scanner cin = new Scanner(System.in);
        int K = cin.nextInt();
        int N = cin.nextInt();
//        PriorityQueue<Point> q = new PriorityQueue<>(Comparator.comparing());
        PriorityQueue<Point> q = new PriorityQueue<>(Comparator.comparing(x -> x.x));
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                int x = cin.nextInt();
                q.add(new Point(x, i, j));
            }
        }
        int[] inqCount = new int[K];
        Queue<Point> qq = new LinkedList<>();//单调队列
        int nonzeroCount = 0;
        int ans = Integer.MAX_VALUE;
        int beg = 0, end = 0;
        boolean startCheck = false;//是否开始覆盖
        while (!q.isEmpty()) {
            Point now = q.poll();
            qq.add(now);
            inqCount[now.k]++;
            if (inqCount[now.k] == 1) {
                nonzeroCount++;
                if (nonzeroCount == K) {
                    startCheck = true;
                }
            } //弹出无用元素
            while (!qq.isEmpty() && inqCount[qq.peek().k] > 1) {
                inqCount[qq.peek().k]--;
                qq.poll();
            }
            if (startCheck) {
                int minValue = qq.peek().x;
                int nowAns = now.x - minValue;
                if (nowAns < ans) {
                    ans = nowAns;
                    beg = minValue;
                    end = now.x;
                }
            }
        }
        System.out.println(beg + " " + end);
    }

    /**
     * 给定无序整数序列，求其中第K大的数，例如{45，67，33，21}，第2大数为45
     * 输入描述:
     * 输入第一行为整数序列，数字用空格分隔，如：45 67 33 21
     * 输入第二行一个整数K，K在数组长度范围内，如：2
     * 输出描述:
     * 输出第K大的数，本例为第2大数：45
     *
     */
    public static void fun4(){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String[] str = line.trim().split(" ");
        int[] arr = new int[str.length];
        for (int i = 0; i <str.length ; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int k = scanner.nextInt();

        int res = quickSelect(arr, k);
        System.out.println(res);
    }

    public static int quickSelect(int[] arr, int k){
        if(arr == null || arr.length < 1){
            return -1;
        }
        int l = 0, r = arr.length-1, pos;
        while(l <= r){
            pos = partition(arr, l, r);
            System.out.println("pos = " + pos);
            if(pos + 1 == k){
                return arr[k];
            }else if(pos + 1 < k){
                l = pos + 1;
            }else{
                r = pos - 1;
            }
        }
        return -1;
    }

    public static int partition(int[] arr,int l, int r){
        int pivot = arr[r];
        int last = r-1;
        for (int i = l; i < r; i++) {
            if(arr[i] > pivot){
                swap(arr, i, last--);
            }
        }
        swap(arr, last+1 , r);
        return last+1;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}