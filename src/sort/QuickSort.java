package sort;

import java.util.Random;

/**
 * 快速排序
 *     交换排序，递归分割
 * @author rosuh 2018/05/28
 *
 */


public class QuickSort {
    public static void main(String[] args){
        int count = new Random().nextInt(100);
        int[] unsortArray = new int[count];

        // 为数组元素设置随机值
        for (int i = 0; i < count; i ++){
            unsortArray[i] = new Random().nextInt(1000);
        }

        quickSort(unsortArray);
    }

    public static void quickSort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int l, int u){
        if (l >= u){
            return;
        }
        int pivot = nums[l];
        int left = l+1;
        int right = u;
        // Just print all elements
        for (int data: nums){
            System.out.print(data + ", ");
        }
        System.out.println();

        while (left <= right){
            while (left <= right && nums[left] < pivot){
                left++;
            }

            while (left <= right && nums[right] > pivot){
                right--;
            }

            if (left > right){
                break;
            }

            int tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;

        }

        int tmp = nums[right];
        nums[right] = nums[l];
        nums[l] = tmp;

        quickSort(nums, l, right - 1);
        quickSort(nums, right + 1, u);
    }
}
