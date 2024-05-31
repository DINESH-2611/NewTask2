package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZigZag {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter m and n");
        int m=sc.nextInt();
        int n=sc.nextInt();
        ZigZag zigZag=new ZigZag();
        int[][] matrix=zigZag.generateMatrix(m,n);
        List<List<Integer>> list=zigZag.aDiagonal(matrix);
        for (List<Integer> a:list){
            System.out.println(a);
        }
        for(int i=0;i<list.size();i++){
            if(list.get(i).size()==1)
                System.out.print(list.get(i).get(0)+" ");
            else if((i%2)==0){
                List<Integer> temp=list.get(i);
                for (int j = temp.size()-1; j >=0 ; j--) {
                    System.out.print(temp.get(j)+" ");
                }
            }else{
                List<Integer> temp=list.get(i);
                for (int j = 0; j <temp.size(); j++) {
                    System.out.print(temp.get(j)+" ");
                }
            }
        }
    }
    int[][] generateMatrix(int m,int n){
        int[][] matrix=new int[m][n];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                matrix[i][j]=generaterandomNumber();
            }
        }
        printZigZag(matrix);
        return matrix;
    }

    private void printZigZag(int[][] matrix) {
        for(int[] i:matrix ) {
            for(int j:i) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    private int generaterandomNumber() {
        return (int)(Math.random()*10+20);
    }
    public List<List<Integer>> aDiagonal(int[][] arr){
        int row=arr.length;
        int col=arr[0].length;
        int rowStart=0;

        List<List<Integer>> res= new ArrayList<>();
        while(rowStart<row)
        {
            int c=0;
            int r=rowStart;
            List<Integer> l= new ArrayList<>();
            while(r>=0 && c<col)
            {
                l.add(arr[r][c]);
                r--;
                c++;
            }
            res.add(l);
            rowStart++;
        }
        // rowStart--;
        int colStart=1;
        while(colStart<col)
        {
            int c=colStart;
            int r=row-1;
            List<Integer> l= new ArrayList<>();
            while(c<col && r>=0)
            {
                l.add(arr[r][c]);
                r--;
                c++;
            }
            // rowStart++;
            colStart++;
            res.add(l);
        }

        return res;
    }

}
