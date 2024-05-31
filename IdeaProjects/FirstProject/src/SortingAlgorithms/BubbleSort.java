package SortingAlgorithms;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 1, 3, 5};
        new BubbleSort().bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void bubbleSort(int[] arr) {
        int swapCount = 0;
        boolean swapped = false;
        do {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(i, i + 1, arr);
                    swapped = true;
                    swapCount++;
                }
            }
        } while (swapped);
    }

    private void swap(int left, int right, int[] arr) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

    }
}
