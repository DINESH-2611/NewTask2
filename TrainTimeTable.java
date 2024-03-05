package Assignent7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TrainTimeTable {

	static Scanner sc = new Scanner(System.in); 

	public static void main(String[] args) {
		
		System.out.println("No of trains from A to B");
		int na = sc.nextInt();
		System.out.println("No of trains from B to A");
		int nb = sc.nextInt();
        int aCount=0,bCount=0;
		List<Double> depatureA = new ArrayList<Double>();
		List<Double> arrivalA = new ArrayList<Double>();
		List<Double> depatureB = new ArrayList<Double>();
		List<Double> arrivalB = new ArrayList<Double>();
		for (int i = 0; i <na; i++) {
			System.out.println("Enter A's departure time");
			depatureA.add(sc.nextDouble());
			System.out.println("Enter A's arrival time");
			arrivalA.add(sc.nextDouble());
		}
		for (int i = 0; i <nb; i++) {
			System.out.println("Enter B's departure time");
			depatureB.add(sc.nextDouble());
			System.out.println("Enter B's arrival time");
			arrivalB.add(sc.nextDouble());
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
		System.out.println(aCount);
		System.out.println(bCount);

	}
	
}
