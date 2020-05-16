package com.felipedeveloper.reportapp.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipedeveloper.reportapp.entities.Equipment;
import com.felipedeveloper.reportapp.services.EquipmentService;

@RestController
@RequestMapping(value = "/equipments")
public class EquipmentResource {

	@Autowired
	private EquipmentService equipmentService;
	
	@GetMapping
	public ResponseEntity<List<Equipment>> findAll(){
		List<Equipment> obj = equipmentService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Equipment> update(@PathVariable Long id, @RequestBody Equipment obj){
		obj = equipmentService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
