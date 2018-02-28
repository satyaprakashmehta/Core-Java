/*Consider that I have a file with some numbers as below - the name of the file is seminar.txt. 
This file is a data set that I collected on the number of students who attended my seminar
sessions in the months of January - March. Some of these data is text. Your task is to extract
only the number of students and calculate and display the total number of students who attended
the seminars in the three months. Call this program Seminar.java

January
Week 1 23
Week 2 30
Week 3 20
Week 4 40
February
Week 1 20
Week 2 19
Week 3 19
Week 4 20
March
Week 1 10
Week 2 50
Week 3 21
Week 4 20*/

package com.emob.integration.fieldez.domain.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Seminar {

	static String filePath = "D:\\seminar.txt";

	public static void main(String[] args) throws IOException {
		File f = new File(filePath);

		if (f.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(f));

			String str;
			StringBuilder text = new StringBuilder();
			while ((str = br.readLine()) != null) {
				text.append(str);
			}
			String strArray[] = text.toString().replace("January", "").replace("February","").replace("March", "").replace("Week","").trim().split(" ");
				
			boolean flag=false;
			Integer sum=0;
			for(String s :strArray) {
				if(flag) {
					try {
						sum= sum + Integer.parseInt(s);
					}catch(Exception e) {}
					flag=false;
				}else
					flag=true;
			}
			System.out.println("Total Number of Student : "+sum);

		} else
			System.out.println("File Not Found...");

	}
	
}
