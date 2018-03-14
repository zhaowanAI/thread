package com.atguigu.test02;

public enum TestEnum {

	ONE(1,"王"),TWO(2,"李"),THREE(3,"钱"),FOUR(4,"孙"),FIVE(5,"赵");
	
	private Integer rc;
	private String rm;
	public Integer getRc() {
		return rc;
	}
	public void setRc(Integer rc) {
		this.rc = rc;
	}
	public String getRm() {
		return rm;
	}
	public void setRm(String rm) {
		this.rm = rm;
	}
	private TestEnum(Integer rc, String rm) {
		this.rc = rc;
		this.rm = rm;
	}
	public static TestEnum getR(Integer index) {
		
		for (TestEnum element : values()) {
			
			if(element.getRc() == index) {
				
				return element;
			}
			
		}
		return null;
	}
	
}
