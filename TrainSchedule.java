package Assignment7;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TrainSchedule {
        static Scanner sc = new Scanner(System.in);
        static boolean repeat=true;
        public static void main(String[] args) {
            System.out.println("Enter no of trips form A t B");
            int na=sc.nextInt();
            System.out.println("Enter no of trips form B t A");
            int nb=sc.nextInt();
            sc.nextLine();
            String[][] aTrips=new String[na][2];
            String[][] bTrips=new String[nb][2];

            for (int i = 0; i < na; i++) {
                System.out.println("Enter A's departure time in 'HH:MM' format");
                aTrips[i][0]=sc.nextLine();
                System.out.println("Enter A's arrival time in 'HH:MM' format");
                aTrips[i][1]=sc.nextLine();
            }
            for (int i = 0; i < nb; i++) {
                System.out.println("Enter B's departure time in 'HH:MM' format");
                bTrips[i][0]=sc.nextLine();
                System.out.println("Enter B's arrival time in 'HH:MM' format");
                bTrips[i][1]=sc.nextLine();
            }
           do {
               System.out.println("Select the option");
               System.out.println("1.Find No of Trains\n2.Exit");
               int input=sc.nextInt();
               switch (input){
                   case 1:{
                       int res=noOftrains(aTrips,bTrips);
                       if(res==-1)
                           System.out.println("Invalid input");
                       break;
                   }
                   case 2:{
                       System.out.println("Thank you");
                       repeat=false;
                       break;

                   }
                   default:{
                       System.out.println("Invalid input");
                       break;
                   }
               }
           }while(repeat);



        }
        public static int noOftrains(String[][] aTrips,String[][] bTrips){
            List<Integer> depatureA = new ArrayList<Integer>();
            List<Integer> arrivalA = new ArrayList<Integer>();
            List<Integer> depatureB = new ArrayList<Integer>();
            List<Integer> arrivalB = new ArrayList<Integer>();
            int aCount=0,bCount=0;
            for (int i = 0; i < aTrips.length; i++) {
                int min1=toMinutes(aTrips[i][0]);
                int min2=toMinutes(aTrips[i][1]);
                if(min1 ==-1 || min2==-1)
                    return -1;
                depatureA.add(min1);
                arrivalA.add(min2);
            }
            for (int i = 0; i < bTrips.length; i++) {
                int min1=toMinutes(bTrips[i][0]);
                int min2=toMinutes(bTrips[i][1]);
                if(min1 ==-1 || min2==-1)
                    return -1;
                depatureB.add(min1);
                arrivalB.add(min2);
            }
            for (int i = 0; i < depatureA.size(); i++) {
                if(arrivalB.isEmpty()) {
                    aCount=depatureA.size();
                    break;
                }
                if(!depatureA.isEmpty() &&!(Collections.min(arrivalB)<depatureA.get(i)))
                    aCount++;
            }
            for (int i = 0; i < depatureB.size(); i++) {
                if(arrivalA.isEmpty()) {
                    bCount=depatureB.size();
                    break;
                }
                if(!depatureB.isEmpty() &&  !(Collections.min(arrivalA)<depatureB.get(i)))
                    bCount++;
            }
            System.out.println("The no of trains for station A is: "+aCount);
            System.out.println("The no of trains for station B is: "+bCount);
            return 0;
        }

        public static int toMinutes(String s){
            String[] s1=s.split(":");
            if(s1.length!=2)
                return -1;
            int hours=Integer.parseInt(s1[0]);
            int min=Integer.parseInt(s1[1]);
            if(hours<0 || hours>23 || min<0 || min>59)
                return -1;
            return hours*60+min;
        }
    }



