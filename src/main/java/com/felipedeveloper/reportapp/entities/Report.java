package com.felipedeveloper.reportapp.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.felipedeveloper.reportapp.entities.enums.DepartmentEnum;
import com.felipedeveloper.reportapp.entities.enums.ProcessEnum;

@Entity
@Table(name = "MaintenanceReport_tb")
public class Report implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	private String subject;
	private String content;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss'T'HH:mm:ss'Z'", timezone = "America/Sao_Paulo")
	private Instant date;
	private Integer departmentEnum;
	private Integer processEnum;
	
	@ManyToOne
	@JoinColumn(name = "User_Id")
	private User user;

	public Report() {
	}

	public Report(Long id, Instant date, ProcessEnum processEnum, DepartmentEnum departmentEnum, String subject, String content, User user) {
		super();
		this.id = id;
		this.date = date;
		setProcessEnum(processEnum);
		setDepartmentEnum(departmentEnum);
		this.subject = subject;
		this.content = content;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Integer getProcessEnum() {
		return processEnum;
	}

	public void setProcessEnum(ProcessEnum processEnum) {
		this.processEnum = processEnum.getCode();
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
