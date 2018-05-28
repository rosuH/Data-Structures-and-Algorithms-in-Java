package sort;

import java.util.Random;

/**
 * 冒泡排序实现
 * @author rosuh 2018/05/24
 * 冒泡排序因为每一轮排序完成，都能获得最大数，所以每次循环次数都是 -1 的
 */
public class BubbleSort {
    public static void main(String[] args){
        int count = new Random().nextInt(1000);
        int[] unsortArray = new int[count];

        // 为数组元素设置随机值
        for (int i = 0; i < count; i ++){
            unsortArray[i] = new Random().nextInt(1000);
        }

        bubbleSortByDoWhile(unsortArray);
        bubbleSortByFor(unsortArray);
    }

    // 使用 do while 循环实现
    public static void bubbleSortByDoWhile(int[] ints){
        boolean swap;
        do {
            // Just print all elements
            for (int data: ints){
                System.out.print(data + ", ");
            }
            System.out.println();

            swap = false;
            for (int i = 1; i < ints.length; i ++){
                if (ints[i] < ints[i-1]){
                    int tmp = ints[i];
                    ints[i] = ints[i-1];
                    ints[i-1] = tmp;
                    swap = true;
                }
            }
        }while (swap);
    }

    // 使用 for 循环嵌套实现
    public static void bubbleSortByFor(int[] nums){
        int len = nums.length;
        boolean swap = false;

        for (int i = 0; i < len; i++){
            // Just print all elements
            for (int data: nums){
                System.out.print(data + ", ");
            }
            System.out.println();


            swap = true;
            for (int j = 1; j < len - i; j++){
                if (nums[j-1] > nums[j] ){
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                    swap = false;
                }
            }

            if (swap){
                return;
            }
        }
    }
}
