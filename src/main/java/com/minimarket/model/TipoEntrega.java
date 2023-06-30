package com.minimarket.model;

public class TipoEntrega {
	
	private int ide_ten;
	private String des_ten;
	
	public int getIde_ten() {
		return ide_ten;
	}
	public void setIde_ten(int ide_ten) {
		this.ide_ten = ide_ten;
	}
	public String getDes_ten() {
		return des_ten;
	}
	public void setDes_ten(String des_ten) {
		this.des_ten = des_ten;
	}
	@Override
	public String toString() {
		return "TipoEntrega [ide_ten=" + ide_ten + ", des_ten=" + des_ten + "]";
	}
	

}
