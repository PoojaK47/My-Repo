package com.mindtree.Student.VO;

public class College {
	private long id;
	private String name;
	private int NumOfStu;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumOfStu() {
		return NumOfStu;
	}
	public void setNoOfEmp(int noOfEmp) {
		this.NumOfStu = noOfEmp;
	}
	public College(long id,String name, int NumOfStu) {
		super();
		this.id = id;
		this.name = name;
		this.NumOfStu = NumOfStu;
	}
	public College() {
		super();
		
	}

}

