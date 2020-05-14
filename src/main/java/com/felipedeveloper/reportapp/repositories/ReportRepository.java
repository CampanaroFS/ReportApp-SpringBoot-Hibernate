package com.felipedeveloper.reportapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipedeveloper.reportapp.entities.Report;

public interface ReportRepository extends JpaRepository<Report, Long>{

}
