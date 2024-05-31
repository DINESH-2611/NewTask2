package SortingAlgorithms;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 1, 3, 5};
        new ShellSort().shellSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private void shellSort(int[] arr, int n) {
        for (int i = n / 2; i > 0; i /= 2) {
            for (int j = i; j < n; j++) {
                int temp = arr[j];
                int k;
                for (k = j; k >= i && arr[k - i] > temp; k -= i) {
                    arr[k] = arr[k - i];
                }
                arr[k] = temp;
            }
        }
    }
}
