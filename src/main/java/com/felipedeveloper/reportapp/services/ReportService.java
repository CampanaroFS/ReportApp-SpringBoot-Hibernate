package com.felipedeveloper.reportapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipedeveloper.reportapp.entities.Report;
import com.felipedeveloper.reportapp.repositories.ReportRepository;
import com.felipedeveloper.reportapp.services.exception.ResourceNotFoundException;

@Service
public class ReportService {

	@Autowired
	private ReportRepository reportRepository;

	public List<Report> findAll() {
		return reportRepository.findAll();
	}

	public Report findById(Long id) {
		Optional<Report> obj = reportRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public void deleteById(Long id) {
		reportRepository.deleteById(id);
	}

	public Report insert(Report obj) {
		return reportRepository.save(obj);
	}

	public Report update(Long id, Report obj) {
		Report report = reportRepository.getOne(id);
		report.setSubject(obj.getSubject());
		report.setContent(obj.getContent());

		return reportRepository.save(report);
	}
}
