/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/7/24
 */

public class RandomTwoArrayGenerator {
    /**
     * 行列长度固定  正负皆有 随机 二维数组生成器
     * @param rowSize  行
     * @param colSize  列
     * @param maxValue  -maxValue <= arr[i] <= +maxValue
     * @return
     */
    public static int[][] generateRandomMatrix(int rowSize, int colSize,int maxValue) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            }
        }
        return result;
    }

    /**
     * 行列长度固定 非负 随机 二维数组生成器
     * @param rowSize  行
     * @param colSize  列
     * @param maxValue  0 <= arr[i] <= +maxValue
     * @return
     */
    public static int[][] generatePositiveRandomMatrix(int rowSize, int colSize,int maxValue) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) ((maxValue + 1) * Math.random());
            }
        }
        return result;
    }

    /**
     * 行列长度固定  正 随机 二维数组生成器
     * @param rowSize  行
     * @param colSize  列
     * @param maxValue  0 < arr[i] <= +maxValue
     * @return
     */
    public static int[][] generateNotZeroPositivRandomMatrix(int rowSize, int colSize,int maxValue) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (maxValue * Math.random()) + 1;
            }
        }
        return result;
    }

    /**
     * 复制一个二维数组
     * @param arr
     * @return
     */
    public static int[][] copyArray(int[][] arr) {
        if (arr == null) {
            return null;
        }
        int[][] res = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                res[i][j] = arr[i][j];
            }
        }
        return res;
    }

    /**
     * 判断两个二维数组是否相等
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[][] arr1, int[][] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length || arr1[0].length != arr2[0].length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                if (arr1[i][j] != arr2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 打印二维数组
     * @param arr
     */
    public static void printArray(int[][] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


//    // for test -- print tree
//    public static void printTree(Code_04_SerializeAndReconstructTree.Node head) {
//        System.out.println("Binary Tree:");
//        printInOrder(head, 0, "H", 17);
//        System.out.println();
//    }

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
        int[][] arr1 = generateRandomMatrix(10, 10,10);
        printArray(arr1);
        int[][] arr2 = generatePositiveRandomMatrix(10, 10,10);
        printArray(arr2);
        int[][] arr3 = generateNotZeroPositivRandomMatrix(10, 10,10);
        printArray(arr3);

        //01数组
        int[][] arr4 = generatePositiveRandomMatrix(10, 10,1);
        printArray(arr4);

        for (int i = 0; i < testTime; i++) {

            int[][] arrA = generateRandomMatrix(10,10,10);
            int[][] arrB = copyArray(arrA);
            int[][] badCase = copyArray(arrA);

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
