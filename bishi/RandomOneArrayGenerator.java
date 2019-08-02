/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/7/24
 */

public class RandomOneArrayGenerator {

    /**
     * 数组长度随机  正负皆有 随机 一维数组生成器
     * @param maxSize   数组长度随机且小于等于 maxSize
     * @param maxValue  数组元素范围 -maxValue <= arr[i] <= +maxValue
     * @return
     */
    public static int[] generateLengthRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 数组长度固定 正负皆有 随机 一维数组生成器
     * @param maxSize   数组长度等于 maxSize
     * @param maxValue  数组元素范围  -maxValue <= arr[i] <= +maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (maxSize + 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 数组长度随机 非负 随机一维数组生成器
     * @param maxSize   数组长度随机且小于等于 maxSize
     * @param maxValue  数组元素范围  0 <= arr[i] <= +maxValue
     * @return
     */
    public static int[] generateLengthPositiveRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    /**
     * 数组长度固定 正 随机一维数组生成器
     * @param maxSize   数组长度等于 maxSize
     * @param maxValue  数组元素范围  0 <= arr[i] <= +maxValue
     * @return
     */
    public static int[] generatePositiveRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (maxSize + 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }


    /**
     * 长度固定的非零随机一维数组生成器
     * @param maxSize   数组长度等于 maxSize
     * @param maxValue  数组元素范围  0 < arr[i] <= +maxValue
     * @return
     */
    public static int[] generateNotZeroPositiveRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (maxSize + 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (maxValue * Math.random()) + 1;
        }
        return arr;
    }

    /**
     * 复制一个一维数组
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 判断两个一维数组是否相等
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印一维数组
     * @param arr
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    // 一维数组对数器
    public static void main(String[] args) {
        //重复次数50 万次
//        int testTime = 500000;
        int testTime = 0;
        //数组长度最大 100
        int maxSize = 100;
        //数组元素最大值 100
        int maxValue = 100;

        //对数器是否成功标志 succeed
        boolean succeed = true;

        //test
        int[] arr1 = generateRandomArray(10, 10);
        printArray(arr1);
        int[] arr2 = generateLengthRandomArray(10, 10);
        printArray(arr2);
        int[] arr3 = generateLengthPositiveRandomArray(10, 10);
        printArray(arr3);
        int[] arr4 = generatePositiveRandomArray(10, 10);
        printArray(arr4);
        int[] arr5 = generateNotZeroPositiveRandomArray(10, 10);
        printArray(arr5);

        for (int i = 0; i < testTime; i++) {

            int[] arrA = generateRandomArray(maxSize, maxValue);
            int[] arrB = copyArray(arrA);
            int[] badCase = copyArray(arrA);

            //1, 绝对正确的解法
            //bubbleSort(arrA);
            //2, 尝试的解法
            //comparator(arrB);

            if (!isEqual(arrA, arrB)) {
                succeed = false;

                System.out.println("bad case:");
                printArray(badCase);

                System.out.println("right result:");
                printArray(arrA);

                System.out.println("wrong result:");
                printArray(arrB);
                break;
            }
        }
    }

}
