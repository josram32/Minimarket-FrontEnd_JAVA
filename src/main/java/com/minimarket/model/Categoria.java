package com.minimarket.model;

public class Categoria {
	
	private int ide_cat;
	private String nom_cat;
	private String des_cat;
	
	
	public int getIde_cat() {
		return ide_cat;
	}
	public void setIde_cat(int ide_cat) {
		this.ide_cat = ide_cat;
	}
	public String getNom_cat() {
		return nom_cat;
	}
	public void setNom_cat(String nom_cat) {
		this.nom_cat = nom_cat;
	}
	public String getDes_cat() {
		return des_cat;
	}
	public void setDes_cat(String des_cat) {
		this.des_cat = des_cat;
	}
	@Override
	public String toString() {
		return "Categoria [ide_cat=" + ide_cat + ", nom_cat=" + nom_cat + ", des_cat=" + des_cat + "]";
	}
	
	

}
