package br.com.vinicius.util.enums;

public enum EmptyFieldsEnum {
	
	STRING_EMPTY (""),
	LONG_EMPTY (0L);
	
	private String valueString;
	private Long valueLong;	
	
	EmptyFieldsEnum(String valueString) {
		this.valueString = valueString;
	}
	
	EmptyFieldsEnum(Long valueLong) {
		this.valueLong = valueLong;
	}
	
	public String valueString() {
		return valueString.toString();
	}
	
	public Long valueLong() {
		return valueLong;
	}
}