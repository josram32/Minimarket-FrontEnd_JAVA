package com.minimarket.model;

public class Ubigeo {
	
	private String ide_ubi;
	private String cod_dpt;
	private String cod_pro;
	private String cod_dis;
	private String des_dpt;
	private String des_pro;
	private String des_dis;
	
	public String getIde_ubi() {
		return ide_ubi;
	}
	public void setIde_ubi(String ide_ubi) {
		this.ide_ubi = ide_ubi;
	}
	public String getCod_dpt() {
		return cod_dpt;
	}
	public void setCod_dpt(String cod_dpt) {
		this.cod_dpt = cod_dpt;
	}
	public String getCod_pro() {
		return cod_pro;
	}
	public void setCod_pro(String cod_pro) {
		this.cod_pro = cod_pro;
	}
	public String getCod_dis() {
		return cod_dis;
	}
	public void setCod_dis(String cod_dis) {
		this.cod_dis = cod_dis;
	}
	public String getDes_dpt() {
		return des_dpt;
	}
	public void setDes_dpt(String des_dpt) {
		this.des_dpt = des_dpt;
	}
	public String getDes_pro() {
		return des_pro;
	}
	public void setDes_pro(String des_pro) {
		this.des_pro = des_pro;
	}
	public String getDes_dis() {
		return des_dis;
	}
	public void setDes_dis(String des_dis) {
		this.des_dis = des_dis;
	}
	@Override
	public String toString() {
		return "Ubigeo [ide_ubi=" + ide_ubi + ", cod_dpt=" + cod_dpt + ", cod_pro=" + cod_pro + ", cod_dis=" + cod_dis
				+ ", des_dpt=" + des_dpt + ", des_pro=" + des_pro + ", des_dis=" + des_dis + "]";
	}
	
	

}
