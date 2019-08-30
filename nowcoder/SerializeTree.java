import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/8/3
 */
/*
请实现两个函数，分别用来序列化和反序列化二叉树
https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84?tpId=13&tqId=11214&tPage=4&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class SerializeTree {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    String str = null;

    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root==null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    TreeNode Deserialize(String str) {

        if(str.equals("#,")){
            return null;
        }

        String[] s = str.split(",");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i < s.length; i++) {
            queue.offer(s[i]);
        }
        return reconbystr(queue);

    }

    public static TreeNode reconbystr(Queue<String> queue){
        String s = queue.poll();
        if(s.equals("#")){
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(s));
        node.left = reconbystr(queue);
        node.right = reconbystr(queue);
        return node;
    }
}
