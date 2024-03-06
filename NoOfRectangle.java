package Assignment7;

import java.util.Arrays;
import java.util.Scanner;

public class NoOfRectangle {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter no of rows");
        int n=sc.nextInt();
        int[][] a=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <a[i].length; j++) {
                System.out.println("Enter the elements");
                a[i][j]=sc.nextInt();
            }
        }
//        int[][] a={{0, 1, 1, 0},
//                   {1, 1, 1, 0},
//                   {0, 0, 1, 1},
//                   {0, 0, 1, 1}};
        for(int[] i:a)
            System.out.println(Arrays.toString(i));
        int count=count(a);
        System.out.println("The No of rectangles in the matrix is: "+count);

    }
    public static int count(int[][] a){
        int count=0;
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a[i].length-1; j++) {
                if(a[i][j]==1 && a[i+1][j]==1 && a[i][j+1]==1 && a[i+1][j+1]==1)
                    count++;
            }
        }
        return count;
    }


    }


