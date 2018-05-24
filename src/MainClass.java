import dataStructure.BinaryTree;
import dataStructure.LinkList;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author rosuh
 */
public class MainClass {
    public static void main(String[] args){
        int count = new Random().nextInt(20);
        Set<Integer> set = new HashSet<>();
        int[] source = new int[count];

        // 为数组元素设置随机值
        for (int i = 0; i < count; i ++){
            source[i] = new Random().nextInt(100);
        }

        // 利用集合特性给数组去重
        for (int data: source){
            set.add(data);
        }

        // 获取去重后的数组
        int[] array = new int[set.size()];
        Integer[] integers = (Integer[]) set.toArray(new Integer[set.size()]);
        for (int i = 0; i < integers.length; i++){
            array[i] = integers[i];
        }

        // 创建链表并插入值
        LinkList linkList = new LinkList().createLinkList(array);
        linkList.deleteNode(array[1]);
        System.out.println("linkList: " + linkList.toString());

        // 创建二叉树并插入值
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.binaryTree();
        for (int data: array){
            binaryTree.insert(data);
        }
        System.out.println("binaryTree size = " + binaryTree.size());
        System.out.println("binaryTree maxDepth = " + binaryTree.maxDepth());
        System.out.println("binaryTree minValue = " + binaryTree.minValue());
        System.out.println("binaryTree maxValue = " + binaryTree.maxValue());
        System.out.println("isBST = " + binaryTree.isBST());

        binaryTree.printfPaths();
        binaryTree.mirrorTree();
        binaryTree.printfPaths();

    }

}
