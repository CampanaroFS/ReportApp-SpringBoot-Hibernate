package com.felipedeveloper.reportapp.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipedeveloper.reportapp.entities.Report;
import com.felipedeveloper.reportapp.services.ReportService;

@RestController
@RequestMapping(value = "/reports")
public class ReportResource {
	
	@Autowired
	private ReportService reportService;
	
	@GetMapping
	public ResponseEntity<List<Report>> findAll(){
		List<Report> report = reportService.findAll();
		return ResponseEntity.ok().body(report);
	}

}
