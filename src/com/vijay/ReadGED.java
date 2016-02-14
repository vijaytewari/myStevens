package com.vijay;
import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class ReadGED {

	public static void main(String[] args) {
		String fileName = "D:\\Stevens MSCS\\Assignment Week2\\TewariVijay.ged";
		String line = null;
			
		try{
			FileReader fileReader = new FileReader(fileName);
			BufferedReader  bufferedReader = new BufferedReader(fileReader);
						
			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				Scanner scan = null;
			    scan = new Scanner(line);
			    while (scan.hasNextLine()) {
			            Scanner s2 = new Scanner(scan.nextLine());
			            String level = s2.next();
			            String tag = s2.next();
			            System.out.println(level+ " " + tag);
			            if(!isTagvalid(tag)) {
			                	System.out.println("Invalid Tag");
			            }
			            System.out.println("");
			    }
			    scan.close();
			}
			bufferedReader.close();
		}
			catch(FileNotFoundException ex) {
				System.out.println("Unable to open file '" +fileName + "'");
		} catch (IOException e) {
				e.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	public static boolean isTagvalid(String tag) {
		 Scanner tagRef = null;
		 int i = 0;
		
		    try {
		    	tagRef = new Scanner(new File("D:\\Stevens MSCS\\Assignment Week2\\TagRef.txt")); 
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();  
		    }
		    Set<String> b = new HashSet<String>();
		    while (tagRef.hasNextLine()) 
		    {
		    	b.add(tagRef.nextLine());
		    }
		  
		    if(!b.contains(tag)){
			    	return false;
		    }
 	 return true;
		
	}
}
