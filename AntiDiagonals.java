package Assignment7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AntiDiagonals {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the size of the array");
        int n=sc.nextInt();
        int[][] a=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                System.out.println("Enter the elements of the array");
                a[i][j]=sc.nextInt();
            }
        }
        List<List<Integer>> res=antiDiagonals(a);
        System.out.println(res);
    }

    public static List<List<Integer>> antiDiagonals(int[][] a){
        int n=a.length;
        List<List<Integer>> ad=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> d = new ArrayList<>();
            int row = 0, col = i;
            while (row < n && col >= 0) {
                d.add(a[row][col]);
                row++;
                col--;
            }
            ad.add(d);
        }

            for (int i = 1; i < n; i++) {
                List<Integer> d=new ArrayList<>();
                int row=i,col=n-1;
                while(row<n && col>=0){
                    d.add(a[row][col]);
                    row++;
                    col--;
                }
                ad.add(d);
        }
            return ad;
    }
}
