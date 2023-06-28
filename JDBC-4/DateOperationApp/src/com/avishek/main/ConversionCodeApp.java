package com.avishek.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ConversionCodeApp {

	public static void main(String[] args) throws ParseException {
		
		// Read the input from the user
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the date :: (dd-MM-yyyy)");
		String sdate = scanner.next();
		
		// Convert the date from String format to java.util.Date
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date uDate = sdf.parse(sdate);
		
		// Convert java.util.Date to java.sql.Date
		long value = uDate.getTime();
		java.sql.Date sqlDate = new java.sql.Date(value);
		
		// Printing all the 3 formats of Date
		System.out.println("String format date is :: "+sdate);
		System.out.println("Util date is :: "+uDate);
		System.out.println("sql date is :: "+sqlDate);
		
		System.out.println("Enter the dom in the following format ::(yyyy-MM-dd) "+sdate);
		String standardInput = scanner.next();
		java.sql.Date sqlStandarInput = java.sql.Date.valueOf(standardInput);
		
		System.out.println("String standardInput :: "+standardInput);
		System.out.println("String sqlStandarInput :: "+sqlStandarInput);
		
		scanner.close();
		
	}

}
