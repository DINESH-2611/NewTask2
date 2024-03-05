package Assignment7;

import java.util.Scanner;

public class CharacterRemove {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the string");
        String s=sc.nextLine();
        for (int i = 0; i <s.length(); i++) {
            if(i<s.length()-1 && s.charAt(i)==s.charAt(i+1)){
                s=s.substring(0,i)+s.substring(i+2);
                i=0;
            }
        }
        if(s.length()==2 && s.charAt(0)==s.charAt(1))
            System.out.println("Empty string");
        else
           System.out.println(s);
    }
}
