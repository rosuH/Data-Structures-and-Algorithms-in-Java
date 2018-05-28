package sort;

import java.util.Random;

public class InsertSort {
    public static void main(String[] args){
        int count = new Random().nextInt(100);
        int[] unsortArray = new int[count];

        // 为数组元素设置随机值
        for (int i = 0; i < count; i ++){
            unsortArray[i] = new Random().nextInt(1000);
        }

        insertSort(unsortArray);
    }

    private static void insertSort(int[] nums){
        int len = nums.length;

        for (int i = 0; i < len; i ++){
            int index = i;
            int array_i = nums[i];

            while (index > 0 && array_i < nums[index - 1]){
                nums[index] = nums[index - 1];
                index--;
            }

            nums[index] = array_i;

            // Just print all elements
            for (int data: nums){
                System.out.print(data + ", ");
            }
            System.out.println();
        }
    }
}
