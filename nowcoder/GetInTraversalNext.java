/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/8/3
 */

/*

给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class GetInTraversalNext {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null){
            return null;
        }

        if(pNode.right!=null){
            TreeLinkNode node = pNode.right;
            while (node.left!=null){
                node = node.left;
            }
            return node;
        }
        if(pNode.next == null){
            return null;
        }

        if(pNode.next.left == pNode){
            return pNode.next;
        }
        if(pNode.next.right == pNode){
            TreeLinkNode node = pNode;
            while (node.next!=null){
                TreeLinkNode temp = node;
                node = node.next;
                if(node.left == temp){
                    return pNode.next.next;
                }
            }
        }
        return null;
    }
}
