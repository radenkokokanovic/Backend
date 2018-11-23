package com.example.demo.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Country;

@Service
public class CSVReader {

	public static void main(String[] args) {

       
    //Test method getCountry();
	//Create object for testing
	CSVReader csvreader=new CSVReader();
	ArrayList<Country> resultList=csvreader.getContry();
	
	resultList.forEach(System.out::println);

    }
 
 	public  ArrayList<Country> getContry()
 	{
 		//List country
 		ArrayList<Country> listCountry=new ArrayList<>();
 		listCountry.clear();
 		//Country object
 		Country countryObj;
 		//Path for csv file
 		String csvFile="src\\main\\resources\\static\\country.csv";
 		BufferedReader br=null;
 		String line = "";
 	    String cvsSplitBy = ",";
 	    
 	    try {
 	    	 br = new BufferedReader(new FileReader(csvFile));
 	    	 int i=0;
             while ((line = br.readLine()) != null) {
            	 
            	 i++;
                 // use comma as separator
                 String[] country = line.split(cvsSplitBy);
                 countryObj=new Country();
                 countryObj.setId(i);
                 countryObj.setSkracenica(country[4]);
                 countryObj.setIme(country[5]);
                 
                 //Put value from cvs to ArrayList
                 listCountry.add(countryObj);
                
                 //Print from CSV for testing
                 System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");

             }
      
 	   } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           if (br != null) {
               try {
                   br.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
		return listCountry;
 	}

}