import com.sun.org.apache.regexp.internal.RE;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Node mRoot;

    private static class Node{
        private Node mLeft;
        private Node mRight;
        private int mData;

        Node(int data){
            mLeft = null;
            mRight = null;
            mData = data;
        }
    }

    public void BinaryTree(){
        mRoot = null;
    }

    public boolean lookup(int data){
        return lookup(mRoot, data);
    }

    private boolean lookup(Node node, int data){
        if (node == null){
            return false;
        }
        if (node.mData == data){
            return true;
        }else if (data <= node.mData){
            return lookup(node.mLeft, data);
        }else {
            return lookup(node.mRight, data);
        }
    }

    public void insert(int data){
        mRoot = insert(mRoot, data);
    }

    private Node insert(Node node, int data){
        if (node == null){
            System.out.println("insert" + data);
            return new Node(data);
        }else if (data <= node.mData){
             node.mLeft = insert(node.mLeft, data);
        }else {
             node.mRight = insert(node.mRight, data);
        }
        return node;
    }

    public int size(){
        return size(mRoot);
    }

    private int size(Node node){
        if (node == null){
            return 0;
        }else{
            return size(node.mLeft) + 1 + size(node.mRight);
        }
    }

    /**
     * 求二叉树最大深度
     * @return
     */
    public int maxDepth(){
        int depthQ = maxDepthByQueue(mRoot);
        int depthR = maxDepthByRecursive(mRoot);
        if(depthQ == depthR){
            return depthQ;
        }else {
            System.out.println("maxDepthByQueue = " + depthQ);
            System.out.println("maxDepthByRecursive() = " + depthR);
            return 0;
        }
    }

    // 递归方法实现
    private int maxDepthByRecursive(Node node){
        if (node == null){
            return 0;
        }
        return Math.max(maxDepthByRecursive(node.mLeft), maxDepthByRecursive(node.mRight)) + 1;
    }

    // 队列实现
    private int maxDepthByQueue(Node root){
        if (root == null){
            return 0;
        }

        int depth = 0;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        while (!queue.isEmpty()){
            depth++;
            int qLen = queue.size();
            for (int i = 0; i < qLen; i++){
                Node node = queue.poll();
                if (node.mLeft != null){
                    queue.offer(node.mLeft);
                }
                if (node.mRight != null){
                    queue.offer(node.mRight);
                }
            }
        }
        return depth;
    }


    public int minValue(){
        return minValue(mRoot);
    }

    private int minValue(Node node){
        Node curt = node;
        while (curt.mLeft !=  null){
            curt = curt.mLeft;
        }

        return curt.mData;
    }


    public String printfAll(){
        return printfAll(mRoot);
    }

    private String printfAll(Node node){
        if (node == null){
            return "";
        }else {
            String str = "node = " + node + ", mData = " + node.mData + "\n";
            return printfAll(node.mLeft) + str + printfAll(node.mRight);
        }
    }
}
