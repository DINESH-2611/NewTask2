package Assignment7;

import java.util.Scanner;

public class AddStar {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the string");
        String s=sc.nextLine();
        String result=addstar(s);
        System.out.println("Result : "+result);
    }
    public static String addstar(String s){
        if(s.isEmpty()){
            return s;
        }
        if(s.length()>1 &&  s.charAt(0)==s.charAt(1)){
            String first=""+s.charAt(0);
            String rem=s.substring(1);
            return first+"*"+addstar(rem);
        }
        String first=""+s.charAt(0);
        String rem=s.substring(1);

        return first+addstar(rem);
    }
}
