public class LinkList {

    private Node mHead;


    private static class Node{
        private Node mNext;
        private int mData;
        public Node(int data){
            mNext = null;
            mData = data;
        }
    }

    public LinkList createLinkList(int[] dataAry){
        createLinkList(mHead, dataAry);
        return this;
    }

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
