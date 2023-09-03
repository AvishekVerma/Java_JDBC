package com.avishek.project;

import java.util.Scanner;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Which Operation You would like to perform?");
		System.out.println("Choose from below menu....");
		System.out.println("Press 1 for Insert Operation");
		System.out.println("Press 2 for Select Operation");
		System.out.println("Press 3 for Update Operation");
		System.out.println("Press 4 for Delete Operation");
		System.out.println("Press 5 for exit");
		
		Scanner sc = new Scanner(System.in);
		int userChoice = sc.nextInt();
		
		while(true) {
			if(userChoice==1) {
				System.out.println("You Opted for Insert Operation");
				InsertApp.insert();
				continue;
			} 
			if(userChoice==2) {
				System.out.println("You Opted for Select Operation");
				SelectApp.select();
				continue;
			} 
			if(userChoice==3)
				System.out.println("You Opted for Update Operation");{
				UpdateApp.update();
			}
			if(userChoice==4) {
				System.out.println("You Opted for Delete Operation");
				DeleteApp.delete();
			} 
			if(userChoice==5) {
				System.out.println("You Opted for Exit");
				break;
			}
		}
	}

}
