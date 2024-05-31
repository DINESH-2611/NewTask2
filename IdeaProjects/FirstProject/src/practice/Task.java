package practice;

import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = scanner.nextInt();
        int count=0;
        while (n>4){
            count+=n/5;
            n/=5;
        }
        System.out.println(count);
    }
}
