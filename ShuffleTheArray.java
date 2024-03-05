package Assignment7;

import java.util.Arrays;
import java.util.Scanner;

public class ShuffleTheArray {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the size of the array");
        int n=sc.nextInt();
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the elements of the array");
            a[i]=sc.nextInt();
        }

        System.out.println("Index :"+returnIndex(a));

    }
    public static int returnIndex(int[] a){
        int k=0;
        for (int i = 0; i < a.length-1; i++) {
            if(a[i]!=a[i+1])
//                a[k++]=a[i];
                k++;
        }
        a[k]=a[a.length-1];
        for (int i = k+1; i <a.length ; i++) {
              a[i]=0;
        }
        System.out.println(Arrays.toString(a));
        return k;
    }


}
