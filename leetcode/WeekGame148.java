/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/8/4
 */

public class WeekGame148 {
    public static void main(String[] args) {
        System.out.println(movesToMakeZigzag(new int[]{1,2,3}));
        System.out.println(movesToMakeZigzag(new int[]{9,6,1,6,2}));
    }

    /*
5147. 递减元素使数组呈锯齿状
题目难度 Easy
给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。

如果符合下列情况之一，则数组 A 就是 锯齿数组：

每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
或者，每个奇数索引对应的元素都小于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
返回将数组 nums 转换为锯齿数组所需的最小操作次数。



示例 1：

输入：nums = [1,2,3]
输出：2
解释：我们可以把 2 递减到 0，或把 3 递减到 1。
示例 2：

输入：nums = [9,6,1,6,2]
输出：4


提示：

1 <= nums.length <= 1000
1 <= nums[i] <= 1000

     */
    public static int movesToMakeZigzag(int[] nums) {
        if(nums == null || nums.length <= 2){
            return 0;
        }
        int[] dp = new int[nums.length];
        int odd = 0;
        int even = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i == 0 ){
                dp[i] = nums[i] >= nums[i+1] ? nums[i] - nums[i+1]+1 : 0;
            }else if(i == nums.length -1 ){
                dp[i] = nums[i] >= nums[i-1] ? nums[i] - nums[i-1] +1 : 0;
            }else {
                int min = Math.min(nums[i-1], nums[i+1]);
                dp[i] = nums[i] >= min ? nums[i] - min + 1 : 0;
            }
            if (i%2 == 0){
                even += dp[i];
            }else {
                odd += dp[i];
            }
        }

        return Math.min(odd, even);
    }



/*
5148. 二叉树着色游戏  显示英文描述
用户通过次数 88
用户尝试次数 171
通过次数 88
提交次数 351
题目难度 Medium
有两位极客玩家参与了一场「二叉树着色」的游戏。游戏中，给出二叉树的根节点 root，树上总共有 n 个节点，且 n 为奇数，其中每个节点上的值从 1 到 n 各不相同。


游戏从「一号」玩家开始（「一号」玩家为红色，「二号」玩家为蓝色），最开始时，

「一号」玩家从 [1, n] 中取一个值 x（1 <= x <= n）；

「二号」玩家也从 [1, n] 中取一个值 y（1 <= y <= n）且 y != x。

「一号」玩家给值为 x 的节点染上红色，而「二号」玩家给值为 y 的节点染上蓝色。



之后两位玩家轮流进行操作，每一回合，玩家选择一个他之前涂好颜色的节点，将所选节点 未着色 的一个邻节点（即左右子节点、或父节点）进行染色。

如果当前玩家无法找到这样的节点来染色时，他的回合就会被跳过。

若两个玩家都没有可以染色的节点时，游戏结束。着色节点最多的那位玩家获得胜利 ✌️。



现在，假设你是「二号」玩家，根据所给出的输入，假如存在一个 y 值可以确保你赢得这场游戏，则返回 true；若无法获胜，就请返回 false。



示例：



输入：root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
输出：True
解释：第二个玩家可以选择值为 2 的节点。


提示：

二叉树的根节点为 root，树上由 n 个节点，节点上的值从 1 到 n 各不相同。
n 为奇数。
1 <= x <= n <= 100

 */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if(root == null || n < x){
            return false;
        }
        if(root.val == x){
            return travelTree(root.right) - travelTree(root.left) != 0;
        }
        TreeNode xNode = findx(root,x);


        int left = travelTree(xNode.left), right = travelTree(xNode.right);
        return left > n-left || right > n-right || left + right + 1 < n -left-right-1;

    }
    public static int travelTree(TreeNode root){
        if (root == null) {
            return 0;
        }
        int sum = 1 + travelTree(root.left) + travelTree(root.right);
        return sum;
    }

    public static TreeNode findx(TreeNode root, int x){
        if(root == null){
            return null;
        }
        if(root.val == x){
            return root;
        }
        TreeNode temp = findx(root.left,x);
        return  temp == null ? findx(root.right,x) : temp;
    }
}
