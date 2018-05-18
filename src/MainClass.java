import java.util.Random;

public class MainClass {
    public static void main(String[] args){
        int count = new Random().nextInt(100);
        int array[] = new int[count];

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.BinaryTree();

        for (int i = 0; i < count; i ++){
            array[i] = new Random().nextInt(100);
        }

        for (int data: array){
            binaryTree.insert(data);
        }

        LinkList linkList = new LinkList().createLinkList(array);
        linkList.deleteNode(array[1]);
        System.out.println("linkList: " + linkList.toString());

        System.out.println("binaryTree size = " + binaryTree.size());
        System.out.println("binaryTree maxDepth = " + binaryTree.maxDepth());
        System.out.println("binaryTree minValue = " + binaryTree.minValue());
    }
}
