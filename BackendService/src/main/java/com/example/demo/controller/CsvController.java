package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Country;
import com.example.demo.util.CSVReader;
import com.example.demo.util.CSVUtils;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/csv") // This means URL's start with /csv (after Application path)
public class CsvController {
	
	@Autowired
	CSVReader csvReader;
	@Autowired
	CSVUtils csvUtils;
	
	@GetMapping(path="/getCSV") // Map ONLY GET Requests
	public @ResponseBody ArrayList<Country> getCSV()
	{
		return csvReader.getContry();
	}
	
	@GetMapping(path="/getNewCSV") // Map ONLY GET Requests
	public @ResponseBody List<String> getCSV2() throws FileNotFoundException
	{	
		
	    String csvFile = pathString();
	    CSVUtils obj=new CSVUtils();
        Scanner scanner = new Scanner(new File(csvFile));
        List<String>list=new ArrayList<>();
        while (scanner.hasNext()) {
        
            list.addAll(obj.parseLine(scanner.nextLine()));
            System.out.println(list.size());
          //  System.out.println("Country [id= " + line.get(0) + ", code= " + line.get(1) + " , name=" + line.get(2) + "]");
        }
        scanner.close();
		return list;
	}
	
	public static String pathString()
	{
		Properties prop = new Properties();
		InputStream input = null;
		String path=null;
		try {
		
		input=new FileInputStream("src\\main\\resources\\path.properties");
		prop.load(input);
		path=prop.getProperty("csvPath");
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return path;
	}

}
