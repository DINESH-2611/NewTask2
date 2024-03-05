package Assignment7;

import java.util.Scanner;

public class Paranthesis {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the string");
        String s=sc.nextLine();
        System.out.println(isParanthesis(s));

    }
        public static boolean isParanthesis(String s){
        if(s.length()==1 && (s.equals("(") || s.equals(")"))){
            return false;
        }
        if(s.length()==1 ){
            return true;
        }
        if(s.equals("()")) return true;
        String first=s.charAt(0)+"";
        String last=s.charAt(s.length()-1)+"";
        String rem=s.substring(1 ,s.length()-1);
        if(first.equals("(") && last.equals(")")){
            return isParanthesis(rem);
        }
        return false;

    }


    }

