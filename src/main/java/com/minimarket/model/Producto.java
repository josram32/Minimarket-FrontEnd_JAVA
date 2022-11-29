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
@Table(name= "tbl_PRODUCTO")
@Entity
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ide_pro;
	private String des_pro;
	private int ide_cat;
	private int ide_prv;
	private int stk_pro;
	private double pre_pro;
	private int ide_ume;
	private String vig_pro;
	
	@ManyToOne
	@JoinColumn(name="ide_cat", insertable=false, updatable=false)
	private Categoria objCategoria;
	
	@ManyToOne
	@JoinColumn(name="ide_prv", insertable=false, updatable=false)
	private Proveedor objProveedor;
	
	@ManyToOne
	@JoinColumn(name="ide_ume", insertable=false, updatable=false)
	private UnidadMedida objUnidadMedida;

	public int getIde_pro() {
		return ide_pro;
	}

	public void setIde_pro(int ide_pro) {
		this.ide_pro = ide_pro;
	}

	public String getDes_pro() {
		return des_pro;
	}

	public void setDes_pro(String des_pro) {
		this.des_pro = des_pro;
	}

	public int getIde_cat() {
		return ide_cat;
	}

	public void setIde_cat(int ide_cat) {
		this.ide_cat = ide_cat;
	}

	public int getIde_prv() {
		return ide_prv;
	}

	public void setIde_prv(int ide_prv) {
		this.ide_prv = ide_prv;
	}

	public int getStk_pro() {
		return stk_pro;
	}

	public void setStk_pro(int stk_pro) {
		this.stk_pro = stk_pro;
	}

	public double getPre_pro() {
		return pre_pro;
	}

	public void setPre_pro(double pre_pro) {
		this.pre_pro = pre_pro;
	}

	public int getIde_ume() {
		return ide_ume;
	}

	public void setIde_ume(int ide_ume) {
		this.ide_ume = ide_ume;
	}

	public String getVig_pro() {
		return vig_pro;
	}

	public void setVig_pro(String vig_pro) {
		this.vig_pro = vig_pro;
	}

	public Categoria getObjCategoria() {
		return objCategoria;
	}

	public void setObjCategoria(Categoria objCategoria) {
		this.objCategoria = objCategoria;
	}

	public Proveedor getObjProveedor() {
		return objProveedor;
	}

	public void setObjProveedor(Proveedor objProveedor) {
		this.objProveedor = objProveedor;
	}

	public UnidadMedida getObjUnidadMedida() {
		return objUnidadMedida;
	}

	public void setObjUnidadMedida(UnidadMedida objUnidadMedida) {
		this.objUnidadMedida = objUnidadMedida;
	}

	@Override
	public String toString() {
		return "Producto [ide_pro=" + ide_pro + ", des_pro=" + des_pro + ", ide_cat=" + ide_cat + ", ide_prv=" + ide_prv
				+ ", stk_pro=" + stk_pro + ", pre_pro=" + pre_pro + ", ide_ume=" + ide_ume + ", vig_pro=" + vig_pro
				+ ", objCategoria=" + objCategoria + ", objProveedor=" + objProveedor + ", objUnidadMedida="
				+ objUnidadMedida + "]";
	}
	

}
