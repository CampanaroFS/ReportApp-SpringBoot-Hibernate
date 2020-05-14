package com.felipedeveloper.reportapp.entities.enums;

public enum ProcessEnum {
	
	REPAIR(1),
	INSTALLATION(2),
	PREVENTION(3),
	SOFTWARE_UPDATE(4),
	FAIL(5),
	TEST(6),
	OTHER(7);
	
	private int code;
	
	private ProcessEnum(int code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public static ProcessEnum valueOf(int code) {
		for(ProcessEnum value: ProcessEnum.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Invalid ProcessEnum code");
	}
}
