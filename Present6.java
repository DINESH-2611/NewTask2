package Assignment7;

import java.util.Scanner;

public class Present6 {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size : ");
        int size = sc.nextInt();
        int[] n = new int[size];
        for (int i = 0; i < size; i++) {
            n[i] = sc.nextInt();
        }
        System.out.println(isPresent(n,0));

    }

    public static boolean isPresent(int[] num,int index){
        if(index==num.length-1 && num[index]!=6){
            return false;
        }
        if(num[index]==6){
            return true;
        }
        return isPresent(num,index+1);
    }



}
