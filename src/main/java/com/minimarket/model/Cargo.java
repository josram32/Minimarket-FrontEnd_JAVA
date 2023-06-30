package com.minimarket.model;

public class Cargo {
	
	private int ide_car;
	private String des_car;
	
	public int getIde_car() {
		return ide_car;
	}
	public void setIde_car(int ide_car) {
		this.ide_car = ide_car;
	}
	public String getDes_car() {
		return des_car;
	}
	public void setDes_car(String des_car) {
		this.des_car = des_car;
	}
	
	@Override
	public String toString() {
		return "Cargo [ide_car=" + ide_car + ", des_car=" + des_car + "]";
	}
	
	

}
