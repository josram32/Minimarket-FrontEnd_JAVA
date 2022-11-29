package com.minimarket.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name= "tbl_UNIDAD_MEDIDA")
@Entity
public class UnidadMedida {
	
	@Id
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
