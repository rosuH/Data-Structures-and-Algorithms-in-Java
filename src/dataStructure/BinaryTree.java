package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树类，内含静态结点类，一个根结点变量和二叉树操作
 * @author rosuh
 */
public class BinaryTree {
    private Node mRoot;

    /**
     * 静态结点类
     */
    public static class Node{
        private Node mLeft;
        private Node mRight;
        private int mData;

        Node(int data){
            mLeft = null;
            mRight = null;
            mData = data;
        }

        public Node getmLeft() {
            return mLeft;
        }

        public Node getmRight() {
            return mRight;
        }

        public int getmData() {
            return mData;
        }
    }

    /**
     * 二叉树构造方法，初始化根结点为 null
     */
    public void binaryTree(){
        mRoot = null;
    }

    /**
     * 查找方法：根据传入值查看是否存在于二叉树中
     * @param data 要查找的值
     * @return 存在则返回 true，反之返回 false
     */
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

    /**
     * 插入值到二叉树中
     * 如果二叉树中已存在该值，那么抛出异常
     * @param data  要插入的值
     */
    public void insert(int data){
        mRoot = insert(mRoot, data);
    }

    private Node insert(Node node, int data){
        if (node == null){
            return new Node(data);
        }else if (data < node.mData){
             node.mLeft = insert(node.mLeft, data);
        }else if (data > node.mData){
             node.mRight = insert(node.mRight, data);
        }else {
            throw new IllegalArgumentException("This value has ben exit");
        }
        return node;
    }

    /**
     * 计算二叉树结点数量方法
     * @return 返回结点数量
     */
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
     * @return 返回深度
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

    /**
     * 递归方法实现
     * @param node
     * @return
     */
    private int maxDepthByRecursive(Node node){
        if (node == null){
            return 0;
        }
        return Math.max(maxDepthByRecursive(node.mLeft), maxDepthByRecursive(node.mRight)) + 1;
    }

    /**
     * 队列实现
     * @param root
     * @return
     */
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


    /**
     * 求二叉树最小值
     * @return 最小值
     */
    public int minValue(){
        return minValue(mRoot);
    }

    private int minValue(Node node){
        // what if node == null ?
        Node curt = node;
        while (curt.mLeft !=  null){
            curt = curt.mLeft;
        }

        return curt.mData;
    }

    /**
     * 求二叉树最大值
     * @return 最大值
     */
    public int maxValue(){
        return maxValue(mRoot);
    }

    private int maxValue(Node node){
        Node curt = node;
        while (curt.mRight != null){
            curt = curt.mRight;
        }
        return curt.mData;
    }

    /**
     * 输出二叉树路径
     */
    public void printfPaths(){
        int[] path = new int[1000];
        printfPaths(mRoot, path, 0);
    }

    private void printfPaths(Node node, int[] path, int pathLen){
        if (node == null){
            return;
        }

        path[pathLen] = node.mData;
        pathLen++;

        if (node.mLeft == null && node.mRight == null){
            printArray(path, pathLen);
        }else {
            printfPaths(node.mLeft, path, pathLen);
            printfPaths(node.mRight, path, pathLen);
        }
    }

    private void printArray(int[] ints, int len){
        for (int i = 0; i < len; i++){
            System.out.print(ints[i] + " ");
        }
        System.out.println();
    }

    /**
     * 镜像二叉树
     */
    public void mirrorTree(){
        mirrorTree(mRoot);
    }

    private void mirrorTree(Node node){
        if (node == null){
            return;
        }else {
            mirrorTree(node.mLeft);
            mirrorTree(node.mRight);
            Node tmp = node.mLeft;
            node.mLeft = node.mRight;
            node.mRight = tmp;
        }
    }

    /**
     * 判断是否是二叉查找树
     * @return
     */
    public boolean isBST(){
        return isBST(mRoot);
    }

    private boolean isBST(Node node){
        if (node == null){
            return true;
        }

        if (node.mLeft != null && maxValue(node.mLeft) > node.mData){
            return false;
        }
        if (node.mRight != null && minValue(node.mRight) < node.mData){
            return false;
        }

        return isBST(node.mLeft) && isBST(node.mRight);
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

    public Node getmRoot() {
        return mRoot;
    }
}
