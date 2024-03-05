package Assignment7;

import java.util.Scanner;

public class OnlyParanthesis {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the string");
        String s=sc.nextLine();
        System.out.println(check(s));

    }
    public static String check(String s){
        if(s.charAt(0)=='(' && s.charAt(s.length()-1)==')'){
            return s.substring(1,s.length()-1);
        }
        if(s.charAt(0)!='('){
            return check(s.substring(1));
        }
        if(s.charAt(s.length()-1)!=')'){
            return check(s.substring(0,s.length()-1));
        }
        return check(s);
    }
}
