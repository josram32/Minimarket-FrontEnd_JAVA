package com.minimarket.model;


public class TipoComprobante {
	
	private int ide_tco;
	private String des_tco;
	public int getIde_tco() {
		return ide_tco;
	}
	public void setIde_tco(int ide_tco) {
		this.ide_tco = ide_tco;
	}
	public String getDes_tco() {
		return des_tco;
	}
	public void setDes_tco(String des_tco) {
		this.des_tco = des_tco;
	}
	@Override
	public String toString() {
		return "TipoComprobante [ide_tco=" + ide_tco + ", des_tco=" + des_tco + "]";
	}
	
	

}
