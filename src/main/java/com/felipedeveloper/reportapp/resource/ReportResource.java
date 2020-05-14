package com.felipedeveloper.reportapp.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Report> findById(@PathVariable Long id){
		Report report = reportService.findById(id);
		return ResponseEntity.ok().body(report);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		reportService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Report> insert(@RequestBody Report obj){
		obj = reportService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Report> update(@RequestBody Report obj, Long id){
		obj = reportService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	

}
