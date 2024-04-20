package sudokosolver;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SudukoSolver {
    Scanner scanner=new Scanner(System.in);
    private void createSudoko(){
        int[][] sudoko={{5,3,0,0,7,0,0,0,2},
                        {0,0,2,1,0,5,3,0,0},
                        {0,9,8,0,4,0,0,0,7},
                        {8,0,0,7,6,0,4,0,3},
                        {4,2,0,0,0,3,0,9,0},
                        {7,0,0,9,2,0,0,5,6},
                        {9,0,0,0,3,7,0,0,0},
                        {0,0,0,4,1,9,0,0,0},
                        {3,4,0,2,8,0,0,0,0}};
        printSudoko(sudoko);
        int empty=0;
        int count=0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(sudoko[i][j]!=0){
                    count++;
                }
            }
        }
        empty=81-count;
        getVal(sudoko,empty);
    }
    private boolean validRow(int row,int val,int[][] sudoko){
        Set<Integer> set =new HashSet<>();
        for(int i=0;i<9;i++){
            set.add(sudoko[row][i]);
        }
        return set.add(val);
    }
    private boolean validCol(int col,int val,int[][] sudoko){
        Set<Integer> set =new HashSet<>();
        for(int i=0;i<9;i++){
            set.add(sudoko[i][col]);
        }
        return set.add(val);

    }
    private boolean validSubMatrix(int row,int col,int val,int[][] sudoko){
        Set<Integer> set =new HashSet<>();
        int subRow=row-row%3;
        int subCol=col-col%3;
        for (int i = subRow; i <subRow+3 ; i++) {
            for (int j = subCol; j <subCol+3 ; j++) {
                set.add(sudoko[i][j]);
            }
        }
        return set.add(val);
    }
    public void getVal(int[][] suduko,int count){
        int wrong=0,repeat=0;
        for (int k = 0; k < count; k++) {
            System.out.println("Enter the index in 'i j' format");
            int i=scanner.nextInt(),j=scanner.nextInt();
            if(suduko[i][j]!=0){
                if(repeat>3){
                    System.out.println("You have choose already filled index 5 times and lost this game");
                    return;
                }
                System.out.println("Index already filled,Choose another index");
                k--;
                repeat++;
            }else {
                System.out.println("Enter the value");
                int val=scanner.nextInt();
                if (validRow(i,val,suduko) && validCol(j,val,suduko) && validSubMatrix(i, j,val,suduko)) {
                    suduko[i][j]=val;
                }else{
                    if(wrong>1){
                        System.out.println("You made 3 mistakes and lost this game");
                        return;
                    }
                    suduko[i][j]=val;
                    wrong++;
                }
            }
        }
        if(isValidSudoku(suduko))
            System.out.println("Congratulation!...You have solved the Suduko");
        else
            System.out.println("You lost this game");
    }
    private void printSudoko(int[][] sudoko){
        for(int[] sub:sudoko){
            for(int val:sub){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
    private boolean isValidSudoku(int[][] sudoku){
        Set<String> set=new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j <9 ; j++) {
                int val=sudoku[i][j];
                if(!set.add(val+"in row"+i) || !set.add(val+"in column"+j) || !set.add(val+"in block"+i/3+"-"+j/3))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new SudukoSolver().createSudoko();
    }
}

