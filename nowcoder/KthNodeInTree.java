import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/8/3
 */
/*
给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。

思路: 中序遍历二叉搜索树即为升序的数组,  k 个节点
https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a?tpId=13&tqId=11215&tPage=4&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class KthNodeInTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null || k <= 0){
            return null;
        }

        List<TreeNode> list = new ArrayList<>();
        midOrder(pRoot,list,k);
        return list.size() >= k? list.get(k-1): null;

    }

    public static void midOrder(TreeNode root, List<TreeNode> list, int k){
        if(root == null || list.size() > k){
            return ;
        }
        midOrder(root.left,list, k);
        list.add(root);
        midOrder(root.right, list, k);
    }
}
