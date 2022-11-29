package com.minimarket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name= "tbl_TIPO_DOCUMENTO")
@Entity
public class TipoDocumento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
