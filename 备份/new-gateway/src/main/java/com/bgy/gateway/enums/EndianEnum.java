package com.bgy.gateway.enums;

import lombok.Getter; 

/**
 * @author bean
 * date 2020年12月1日
 */
@Getter 
public enum EndianEnum {
	ABCD(1),
	BADC(2),
	CDAB(3),
	DCBA(4);
	private int index; 
	EndianEnum(int i) {
		this.index = i; 
	} 
}
