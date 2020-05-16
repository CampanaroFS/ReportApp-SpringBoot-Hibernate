package com.felipedeveloper.reportapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipedeveloper.reportapp.entities.Equipment;
import com.felipedeveloper.reportapp.repositories.EquipmentRepository;

@Service
public class EquipmentService {
	
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	public List<Equipment> findAll(){
		return equipmentRepository.findAll();
	}
	
	public Equipment insert(Equipment obj) {
		return equipmentRepository.save(obj);
	}
	
	public Equipment update(Long id, Equipment obj) {
		Equipment equipment = equipmentRepository.getOne(id);
		equipment.setBrand(obj.getBrand());
		equipment.setModel(obj.getModel());
		equipment.setSerialNumber(obj.getSerialNumber());
		equipment.setCode(obj.getCode());
		
		return equipmentRepository.save(equipment);
	}
	
	

}
