package com.minimarket.model;


public class Cliente {
	
	private int ide_cli;
	private String nom_cli;
	private String tel_cli;
	private String fna_cli;
	private String sex_cli;
	private String nro_doc;
	private String ema_cli;
	private String dir_cli;
	private String ide_ubi;
	
	private Ubigeo objUbigeo;
	

	public int getIde_cli() {
		return ide_cli;
	}

	public void setIde_cli(int ide_cli) {
		this.ide_cli = ide_cli;
	}

	public String getNom_cli() {
		return nom_cli;
	}

	public void setNom_cli(String nom_cli) {
		this.nom_cli = nom_cli;
	}

	public String getTel_cli() {
		return tel_cli;
	}

	public void setTel_cli(String tel_cli) {
		this.tel_cli = tel_cli;
	}

	public String getFna_cli() {
		return fna_cli;
	}

	public void setFna_cli(String fna_cli) {
		this.fna_cli = fna_cli;
	}

	public String getSex_cli() {
		return sex_cli;
	}

	public void setSex_cli(String sex_cli) {
		this.sex_cli = sex_cli;
	}

	public String getNro_doc() {
		return nro_doc;
	}

	public void setNro_doc(String nro_doc) {
		this.nro_doc = nro_doc;
	}

	public String getEma_cli() {
		return ema_cli;
	}

	public void setEma_cli(String ema_cli) {
		this.ema_cli = ema_cli;
	}

	public String getDir_cli() {
		return dir_cli;
	}

	public void setDir_cli(String dir_cli) {
		this.dir_cli = dir_cli;
	}

	public String getIde_ubi() {
		return ide_ubi;
	}

	public void setIde_ubi(String ide_ubi) {
		this.ide_ubi = ide_ubi;
	}

	public Ubigeo getObjUbigeo() {
		return objUbigeo;
	}

	public void setObjUbigeo(Ubigeo objUbigeo) {
		this.objUbigeo = objUbigeo;
	}

	@Override
	public String toString() {
		return "Cliente [ide_cli=" + ide_cli + ", nom_cli=" + nom_cli + ", tel_cli=" + tel_cli + ", fna_cli=" + fna_cli
				+ ", sex_cli=" + sex_cli + ", nro_doc=" + nro_doc + ", ema_cli=" + ema_cli + ", dir_cli=" + dir_cli
				+ ", ide_ubi=" + ide_ubi + ", objUbigeo=" + objUbigeo + "]";
	}
	

}
