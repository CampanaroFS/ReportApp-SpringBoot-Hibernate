package com.felipedeveloper.reportapp.entities.enums;

public enum DepartmentEnum {
	
	ENGINEERING(1),
	JOURNALISM(2),
	TI(3),
	COMERCIAL(4),
	CBN(5),
	JOVEM_PAN(6);
	
	private int code;
	
	private DepartmentEnum(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static DepartmentEnum valueOf(int code) {
		for(DepartmentEnum value : DepartmentEnum.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid DepartmentEnum code");
	}
}
