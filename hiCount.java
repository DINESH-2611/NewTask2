package Assignent7;

import java.util.Scanner;

public class hiCount {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the string");
		String s=sc.next();
		System.out.println(countHi(s));
	}
	
	
	    public static int countHi(String s){
	        if(s.length()==2 && s.equals("hi")){
	            return 1;
	        }
	        if(s.length() < 2){ return 0;}
	        int count=0;
	        String first=s.substring(0,2);
	        String rem=s.substring(1);
	        if(first.equals("hi")) count++;
	        return count+countHi(rem);
	    }

}
