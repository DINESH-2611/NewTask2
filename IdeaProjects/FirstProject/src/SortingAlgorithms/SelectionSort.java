package SortingAlgorithms;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr={2,4,6,1,3,5};
        new SelectionSort().selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min=i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[min])
                    min=j;
            }
            swap(i,min,arr);
        }
    }
    private void swap(int left,int right,int[] arr){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }
}
