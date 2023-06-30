package com.minimarket.model;

public class TipoDocumento {

	private int ide_tdo;
	private String des_tdo;
	
	public int getIde_tdo() {
		return ide_tdo;
	}
	public void setIde_tdo(int ide_tdo) {
		this.ide_tdo = ide_tdo;
	}
	public String getDes_tdo() {
		return des_tdo;
	}
	public void setDes_tdo(String des_tdo) {
		this.des_tdo = des_tdo;
	}
	@Override
	public String toString() {
		return "TipoDocumento [ide_tdo=" + ide_tdo + ", des_tdo=" + des_tdo + "]";
	}
	
	
	
}
