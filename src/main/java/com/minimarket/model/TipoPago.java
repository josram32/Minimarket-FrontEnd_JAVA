package com.minimarket.model;


public class TipoPago {
	
	private int ide_tpa;
	private String des_tpa;
	
	public int getIde_tpa() {
		return ide_tpa;
	}
	public void setIde_tpa(int ide_tpa) {
		this.ide_tpa = ide_tpa;
	}
	public String getDes_tpa() {
		return des_tpa;
	}
	public void setDes_tpa(String des_tpa) {
		this.des_tpa = des_tpa;
	}
	@Override
	public String toString() {
		return "TipoPago [ide_tpa=" + ide_tpa + ", des_tpa=" + des_tpa + "]";
	}

}
