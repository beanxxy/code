package com.bgy.gateway.enums;

import lombok.Getter;

/**
 * @author bean
 * date 2020年12月1日
 */
@Getter 
public enum DataTypeEnum {
	// 数据类型
	BOOL(1),
	INT(2),
	FLOAT(3),
	WORD(4),
	DWORD(5),
	CHAR(6),
	DINT(7),
	REAL(8),
	TIME(9),
	DATE(10),
	S5TIME(11),
	BIT(12),
	STRING(13),
	DREAL(14),
	SHORT(15),
	UNSIGNEDINT(16),
	UNSIGNEDSHORT(17),
	DOUBLE(18),
	LONG(19), 
	UNSIGNEDBYTE(20),
	
	bool(31),
	int32(32),
	float32(33),
	word(34),
	dword(35),
	char8(36),
	dint(37),
	real(38),
	time(39),
	date(310),
	s5time(311),
	bit(312),
	string(313),
	dreal(314),
	short16(315),
	unsignedint(316),
	unsignedshort(317),
	dobule(318),
	long64(319), 
	
	unsignedbtye(320);
	private int index; 
	DataTypeEnum(int i) {
		this.index = i; 
	}
}
