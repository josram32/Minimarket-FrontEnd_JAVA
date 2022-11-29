package com.minimarket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name= "tbl_PROVEEDOR")
@Entity
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ide_prv;
	private String ruc_prv;
	private String nom_prv;
	private String pco_prv;
	private int ide_car;
	private String tel_prv;
	private String ema_prv;
	private String dir_prv;
	private String ide_ubi;
	
	@ManyToOne
	@JoinColumn(name="ide_car", insertable=false, updatable=false)
	private Cargo objCargo;
	
	@ManyToOne
	@JoinColumn(name="ide_ubi", insertable=false, updatable=false)
	private Ubigeo objUbigeo;

	public int getIde_prv() {
		return ide_prv;
	}

	public void setIde_prv(int ide_prv) {
		this.ide_prv = ide_prv;
	}

	public String getRuc_prv() {
		return ruc_prv;
	}

	public void setRuc_prv(String ruc_prv) {
		this.ruc_prv = ruc_prv;
	}

	public String getNom_prv() {
		return nom_prv;
	}

	public void setNom_prv(String nom_prv) {
		this.nom_prv = nom_prv;
	}

	public String getPco_prv() {
		return pco_prv;
	}

	public void setPco_prv(String pco_prv) {
		this.pco_prv = pco_prv;
	}

	public int getIde_car() {
		return ide_car;
	}

	public void setIde_car(int ide_car) {
		this.ide_car = ide_car;
	}

	public String getTel_prv() {
		return tel_prv;
	}

	public void setTel_prv(String tel_prv) {
		this.tel_prv = tel_prv;
	}

	public String getEma_prv() {
		return ema_prv;
	}

	public void setEma_prv(String ema_prv) {
		this.ema_prv = ema_prv;
	}

	public String getDir_prv() {
		return dir_prv;
	}

	public void setDir_prv(String dir_prv) {
		this.dir_prv = dir_prv;
	}

	public String getIde_ubi() {
		return ide_ubi;
	}

	public void setIde_ubi(String ide_ubi) {
		this.ide_ubi = ide_ubi;
	}

	public Cargo getObjCargo() {
		return objCargo;
	}

	public void setObjCargo(Cargo objCargo) {
		this.objCargo = objCargo;
	}

	public Ubigeo getObjUbigeo() {
		return objUbigeo;
	}

	public void setObjUbigeo(Ubigeo objUbigeo) {
		this.objUbigeo = objUbigeo;
	}

	@Override
	public String toString() {
		return "Proveedor [ide_prv=" + ide_prv + ", ruc_prv=" + ruc_prv + ", nom_prv=" + nom_prv + ", pco_prv="
				+ pco_prv + ", ide_car=" + ide_car + ", tel_prv=" + tel_prv + ", ema_prv=" + ema_prv + ", dir_prv="
				+ dir_prv + ", ide_ubi=" + ide_ubi + ", objCargo=" + objCargo + ", objUbigeo=" + objUbigeo + "]";
	}
	
	

}
