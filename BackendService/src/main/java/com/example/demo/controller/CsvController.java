package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Country;
import com.example.demo.util.CSVReader;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/csv") // This means URL's start with /csv (after Application path)
public class CsvController {
	
	@Autowired
	CSVReader csvReader;
	
	@GetMapping(path="/getCSV") // Map ONLY GET Requests
	public @ResponseBody ArrayList<Country> getCSV()
	{
		return csvReader.getContry();
	}

}
