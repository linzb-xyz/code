import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/8/3
 */
/*
请实现一个函数按照之字形打印二叉树，
即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。

https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=13&tqId=11212&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */

public class printTreeByZigZga {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return res;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.offer(pRoot);
        while (!queue1.isEmpty() ||!queue2.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            while (!queue1.isEmpty()){
                TreeNode node = queue1.poll();
                list.add(node.val);
                if(node.left!=null){
                    queue2.offer(node.left);
                }
                if(node.right!=null){
                    queue2.offer(node.right);
                }
                if(queue1.isEmpty()){
                    res.add(list);
                }
            }
            ArrayList<Integer> list1 = new ArrayList<>();
            while (!queue2.isEmpty()){
                TreeNode node = ((LinkedList<TreeNode>) queue2).pollLast();
                list1.add(node.val);
                if(node.right!=null){
                    ((LinkedList<TreeNode>) queue1).addFirst(node.right);
                }
                if(node.left!=null){
                    ((LinkedList<TreeNode>) queue1).addFirst(node.left);
                }
                if (queue2.isEmpty()){
                    res.add(list1);
                }
            }

        }
        return res;
    }
}
