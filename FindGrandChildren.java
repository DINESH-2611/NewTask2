package Assignment7;

import java.util.*;

public class FindGrandChildren {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the no of pairs");
        int n=sc.nextInt();
        sc.nextLine();
        String[][] s=new String[n][2];
        for (int i = 0; i <n ; i++) {
            System.out.println("Enter the child");
            s[i][0]=sc.nextLine();
            System.out.println("Enter the parent");
            s[i][1]=sc.nextLine();
        }
        System.out.println("Enter the grandFather");
        String gf=sc.nextLine();
//        String[][] s={{"luke","shaw"},
//                      {"wayne","rooney"},
//                      {"rooney","ronaldo"},
//                      {"shaw","rooney"}};
        System.out.println(gf+" has "+count(s,gf)+" grandchildrens");

    }
    public static int count(String[][] s,String gf) {

        String father = "";
        for (int i = 0, j = 1; i < s.length; i++) {
            if (gf.equals(s[i][j])) {
                father = s[i][0];
            }
        }
        int count = 0;
        for (int i = 0, j = 1; i < s.length; i++) {
            if (father.equals(s[i][j])) {
                count++;
            }

        }
        return count;
    }
}
