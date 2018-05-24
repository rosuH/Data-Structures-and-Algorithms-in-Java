package dataStructure;

/**
 * 链表类，包含一个 mHead 头结点变量、内部静态结点类和操作链表的方法
 * @author rosuh
 */
public class LinkList {

    private Node mHead;


    /**
     * 内部静态结点类
     */
    private static class Node{
        private Node mNext;
        private int mData;
        public Node(int data){
            mNext = null;
            mData = data;
        }
    }

    /**
     * 创建链表
     * @param dataAry  整数型数组数据集
     * @return  返回创建好的链表对象
     */
    public LinkList createLinkList(int[] dataAry){
        createLinkList(mHead, dataAry);
        return this;
    }

    /**
     * 创建链表
     * @param head 传入头结点
     * @param dataArray 传入数组对象
     */
    private void createLinkList(Node head, int[] dataArray){
        mHead = new Node(dataArray[0]);
        Node tmp = mHead;
        for (int data:dataArray){
            if (data != dataArray[0]){
                tmp.mNext = new Node(data);
                tmp = tmp.mNext;
            }
        }
    }

    /**
     * 搜索是否包含特定值
     * @param key 要搜索的值
     * @return  true 表示存在，反之表示不存在
     */
    public boolean lookup(int key){
        return lookup(mHead, key);
    }

    private boolean lookup(Node mHead, int key){
        Node tmp = mHead;
        while (tmp != null){
            if (tmp.mData == key){
                return true;
            }
            tmp = tmp.mNext;
        }
        return false;
    }

    /**
     * 根据传入值删除结点
     * @param key 要删除的值
     * @return  删除成功返回被删除的结点；反之返回 null
     */
    public Node deleteNode(int key){
        return deleteNode(mHead, key);
    }

    private Node deleteNode(Node mHead, int key){
        Node tmp = mHead;
        if (tmp.mNext == null && tmp.mData != key){
            return null;
        }
        while (tmp.mNext != null){
            if (tmp.mNext.mData == key){
                tmp.mNext = tmp.mNext.mNext;
                return tmp.mNext;
            }
            tmp = tmp.mNext;
        }
        return null;
    }

    /**
     * 反转链表方法
     */
    public void reverse(){
        mHead = reverse(mHead);
    }

    private Node reverse(Node head){
        Node prev = null;
        while (head != null){
            Node next = head.mNext;
            head.mNext = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    /**
     * 递归反转链表方法
     */
    public void reverseNode(){
        mHead = reverseNode(mHead);
    }

    private Node reverseNode(Node head){
        if (head == null || head.mNext == null){
            return head;
        }

        Node next = head.mNext;
        Node newHead = reverseNode(next);
        next.mNext = head;
        head.mNext = null;

        return newHead;
    }

    @Override
    public String toString(){
        Node head = this.mHead;
        StringBuilder str = new StringBuilder();
        while(head != null){
            str.append(head.mData + ", ");
            head = head.mNext;
        }
        return str.toString();
    }
}
