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

    public int maxDepth(){
        return maxDepth(mRoot);
    }

    private int maxDepth(Node node){
        if (node == null){
            return 0;
        }
        return Math.max(maxDepth(node.mLeft), maxDepth(node.mRight)) + 1;
    }
//    private int maxDepth(Node node){
//        if (node == null){
//            return 0;
//        }else {
//            int lDepth = maxDepth(node.mLeft);
//            int rDepth = maxDepth(node.mRight);
//
//            return Math.max(lDepth, rDepth) + 1;
//        }
//    }

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
