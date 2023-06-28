package com.avishek.main;

import java.util.Date;

public class TestApp {

	public static void main(String[] args) {

		// java.util.Date -> we use to store Date information
		Date udate = new Date();
		System.out.println("utilDAte is :: "+udate);
		
		long value = udate.getTime();
		
		// java.sql.Date -> we use to store Date information
		java.sql.Date sqlDate = new java.sql.Date(value);
		System.out.println("sqlDate is :: "+sqlDate);

	}

}
