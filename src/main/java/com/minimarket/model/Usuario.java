package com.minimarket.model;

public class Usuario {

	private int ide_usu;
	private String clave;	
	private String nom_usu;
	private String ape_usu;
	private String fna_usu;
	private String tel_usu;
	private int ide_tdo;
	private String ndi_usu;
	private String correo;	
	private int ide_tus;
	
	private TipoUsuario objTipoUsuario;
	
	private TipoDocumento objTipoDocumento;

	public int getIde_usu() {
		return ide_usu;
	}

	public void setIde_usu(int ide_usu) {
		this.ide_usu = ide_usu;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNom_usu() {
		return nom_usu;
	}

	public void setNom_usu(String nom_usu) {
		this.nom_usu = nom_usu;
	}

	public String getApe_usu() {
		return ape_usu;
	}

	public void setApe_usu(String ape_usu) {
		this.ape_usu = ape_usu;
	}

	public String getFna_usu() {
		return fna_usu;
	}

	public void setFna_usu(String fna_usu) {
		this.fna_usu = fna_usu;
	}

	public String getTel_usu() {
		return tel_usu;
	}

	public void setTel_usu(String tel_usu) {
		this.tel_usu = tel_usu;
	}

	public int getIde_tdo() {
		return ide_tdo;
	}

	public void setIde_tdo(int ide_tdo) {
		this.ide_tdo = ide_tdo;
	}

	public String getNdi_usu() {
		return ndi_usu;
	}

	public void setNdi_usu(String ndi_usu) {
		this.ndi_usu = ndi_usu;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getIde_tus() {
		return ide_tus;
	}

	public void setIde_tus(int ide_tus) {
		this.ide_tus = ide_tus;
	}

	public TipoUsuario getObjTipoUsuario() {
		return objTipoUsuario;
	}

	public void setObjTipoUsuario(TipoUsuario objTipoUsuario) {
		this.objTipoUsuario = objTipoUsuario;
	}

	public TipoDocumento getObjTipoDocumento() {
		return objTipoDocumento;
	}

	public void setObjTipoDocumento(TipoDocumento objTipoDocumento) {
		this.objTipoDocumento = objTipoDocumento;
	}

	@Override
	public String toString() {
		return "Usuario [ide_usu=" + ide_usu + ", clave=" + clave + ", nom_usu=" + nom_usu + ", ape_usu=" + ape_usu
				+ ", fna_usu=" + fna_usu + ", tel_usu=" + tel_usu + ", ide_tdo=" + ide_tdo + ", ndi_usu=" + ndi_usu
				+ ", correo=" + correo + ", ide_tus=" + ide_tus + ", objTipoUsuario=" + objTipoUsuario
				+ ", objTipoDocumento=" + objTipoDocumento + "]";
	}
	
}
