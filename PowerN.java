package Assignment7;

import java.util.Scanner;

public class PowerN {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the number");
        int n=sc.nextInt();
        System.out.println("Enter the power");
        int pow=sc.nextInt();
        System.out.println("Power: "+power(n,pow));

    }

    public static int power(int n,int pow){
        if(pow==0)
            return 1;
        return n*power(n,pow-1);
    }
}
