package com.minimarket.model;


public class UnidadMedida {
	
	private int ide_ume;
	private String des_ume;
	
	public int getIde_ume() {
		return ide_ume;
	}
	public void setIde_ume(int ide_ume) {
		this.ide_ume = ide_ume;
	}
	public String getDes_ume() {
		return des_ume;
	}
	public void setDes_ume(String des_ume) {
		this.des_ume = des_ume;
	}
	@Override
	public String toString() {
		return "UnidadMedida [ide_ume=" + ide_ume + ", des_ume=" + des_ume + "]";
	}
	

}
