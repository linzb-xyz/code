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
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288?tpId=13&tqId=11213&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class LevelPrintTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return res;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.offer(pRoot);

//        int flag = 1;  不需要 flag ,直接使用队列的 size 做标志

        while(!queue1.isEmpty() || !queue2.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            while(!queue1.isEmpty()){
                TreeNode node = queue1.poll();
                if(node.left!=null)
                    queue2.offer(node.left);
                if(node.right!=null)
                    queue2.offer(node.right);
                list.add(node.val);

                if(queue1.isEmpty()){
                    res.add(list);
                    continue;
                }
            }
            ArrayList<Integer> list1 = new ArrayList<>();
            while(!queue2.isEmpty()){
                TreeNode node = queue2.poll();
                if(node.left!=null)
                    queue1.offer(node.left);
                if(node.right!=null)
                    queue1.offer(node.right);
                list1.add(node.val);

                if(queue2.isEmpty()){
                    res.add(list1);
                }
            }
        }
        return res;
    }
}
