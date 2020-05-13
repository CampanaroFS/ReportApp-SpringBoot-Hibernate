package com.felipedeveloper.reportapp.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.felipedeveloper.reportapp.entities.enums.DepartmentEnum;

@Entity
@Table(name = "MaintenanceReport_tb")
public class Report implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	private String subject;
	private String content;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
	private Instant date;

	private Integer departmentEnum;

	public Report() {
	}

	public Report(Integer id, Instant date, DepartmentEnum departmentEnum, String subject, String content) {
		super();
		this.id = id;
		this.date = date;
		setDepartmentEnum(departmentEnum);
		this.subject = subject;
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public Integer getDepartmentEnum() {
		return departmentEnum;
	}

	public void setDepartmentEnum(DepartmentEnum departmentEnum) {
		if (departmentEnum != null) {
			this.departmentEnum = departmentEnum.getCode();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Report other = (Report) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
