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
        System.out.println(binaryTree.printfAll());
//        LinkList linkList = new LinkList().createLinkList(array);
//        linkList.deleteNode(10);
//        System.out.println(linkList.toString());
        System.out.println("size = " + binaryTree.size());
        System.out.println("maxDepth = " + binaryTree.maxDepth());
        System.out.println("minValue = " + binaryTree.minValue());
    }
}
