package sort;

import java.util.Random;

/**
 * 选择排序
 * @author rosuh 2018-05-25
 */
public class SelectionSort {
    public static void main(String[] args){
        int count = new Random().nextInt(100);
        int[] unsortArray = new int[count];

        // 为数组元素设置随机值
        for (int i = 0; i < count; i ++){
            unsortArray[i] = new Random().nextInt(1000);
        }

        selectionSort(unsortArray);
    }

    public static void selectionSort(int[] nums){
        int len = nums.length;
        for (int i = 0; i < len; i++){
            // Just print all elements
            for (int data: nums){
                System.out.print(data + ", ");
            }
            System.out.println();

            int minNum = nums[i];
            for (int j = i; j < len; j++ ){
                if (nums[j] < minNum){
                    nums[i] = nums[j];
                    nums[j] = minNum;
                    minNum = nums[i];
                }
            }
        }
    }

    public static void selectionSort2(int[] nums){
        for (int i = 0; i < nums.length; i++){
            int min = i;
            int tmp;

            for (int j = i+1; j < nums.length; j++){
                if (nums[j] < nums[min]){
                    min = j;
                }
            }

            tmp = nums[min];
            nums[min] = nums[i];
            nums[i] = tmp;
        }
    }
}
