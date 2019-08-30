import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/8/4
 */

public class nTreeMaxDepth559 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

//    public int maxDepth(Node root) {
//        if(root == null){
//            return 0;
//        }
//        int depth = 1;
//        Queue<Node> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()){
//
//        }
//
//    }
}
