//import apple.laf.JRSUIUtils;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
///**
// * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
// *
// * @author: linzebin <linzebin@xiaomi.com>
// * Created on 2019/8/3
// */
//
///*
//请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
//https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=13&tqId=11211&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
// */
//public class isSymmetricalTree {
//    public class TreeNode {
//        int val = 0;
//        TreeNode left = null;
//        TreeNode right = null;
//
//        public TreeNode(int val) {
//            this.val = val;
//
//        }
//
//    }
//
//    boolean isSymmetrical(TreeNode pRoot) {
//        if(pRoot == null ){
//            return true;
//        }
//        Queue<TreeNode> queue1 = new LinkedList<>();
//        if(pRoot.left == null && pRoot.right == null){
//            return true;
//        }else if(pRoot.left != null && pRoot.right != null && pRoot.left.val == pRoot.right.val){
//            queue1.offer(pRoot.left);
//            queue1.offer(pRoot.right);
//        }else{
//            return false;
//        }
//
//        Queue<TreeNode> queue2 = new LinkedList<>();
//
//        while (!queue1.isEmpty() || !queue2.isEmpty()) {
//            while (!queue1.isEmpty()) {
//                TreeNode head = ((LinkedList<TreeNode>) queue1).pollFirst();
//                TreeNode tail = ((LinkedList<TreeNode>) queue1).pollLast();
//                if (((head.left == null && tail.right == null) || (head.left != null && tail.right != null && head.left.val == tail.right.val))
//                        && ((head.right == null && tail.left == null) || (head.right != null && tail.left != null && head.right.val == tail.left.val))) {
//                    if (head.left != null) {
//                        ((LinkedList<TreeNode>) queue2).offerFirst(head.left);
//                        ((LinkedList<TreeNode>) queue2).offerLast(tail.right);
//                    }
//                    if (head.right != null) {
//                        ((LinkedList<TreeNode>) queue2).offerFirst(head.right);
//                        ((LinkedList<TreeNode>) queue2).offerLast(tail.left);
//                    }
//                } else {
//                    return false;
//                }
//
//            }
//            while (!queue2.isEmpty()) {
//                TreeNode head = ((LinkedList<TreeNode>) queue2).pollFirst();
//                TreeNode tail = ((LinkedList<TreeNode>) queue2).pollLast();
//                if (((head.left == null && tail.right == null) || (head.left != null && tail.right != null && head.left.val == tail.right.val))
//                        && ((head.right == null && tail.left == null) || (head.right != null && tail.left != null && head.right.val == tail.left.val))) {
//                    if (head.left != null) {
//                        ((LinkedList<TreeNode>) queue1).offerFirst(head.left);
//                        ((LinkedList<TreeNode>) queue1).offerLast(tail.right);
//                    }
//                    if (head.right != null) {
//                        ((LinkedList<TreeNode>) queue1).offerFirst(head.right);
//                        ((LinkedList<TreeNode>) queue1).offerLast(tail.left);
//                    }
//                } else {
//                    return false;
//                }
//
//            }
//        }
//        return true;
//    }
//
//    }
//}
