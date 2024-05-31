package SortingAlgorithms;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr={2,4,6,1,3,5};
        new InsertionSort().insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int ele=arr[i];
            int j=i-1;
            for (;j>=0 ; j--) {
                if(arr[j]>ele)
                    arr[j+1]=arr[j];
                else
                    break;
            }
            arr[j+1]=ele;
        }
    }
}
