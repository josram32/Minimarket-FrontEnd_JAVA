package com.minimarket.model;


public class DetalleVenta {
	
	private int ide_dve;
	private int ide_ven;
	private int ide_pro;
	private int can_ven;
	private double pre_ven;
	private double dsc_ven;
	private double imp_ven;
	
	private Venta objVenta;
	
	private Producto objProducto;

	public int getIde_dve() {
		return ide_dve;
	}

	public void setIde_dve(int ide_dve) {
		this.ide_dve = ide_dve;
	}

	public int getIde_ven() {
		return ide_ven;
	}

	public void setIde_ven(int ide_ven) {
		this.ide_ven = ide_ven;
	}

	public int getIde_pro() {
		return ide_pro;
	}

	public void setIde_pro(int ide_pro) {
		this.ide_pro = ide_pro;
	}

	public int getCan_ven() {
		return can_ven;
	}

	public void setCan_ven(int can_ven) {
		this.can_ven = can_ven;
	}

	public double getPre_ven() {
		return pre_ven;
	}

	public void setPre_ven(double pre_ven) {
		this.pre_ven = pre_ven;
	}

	public double getDsc_ven() {
		return dsc_ven;
	}

	public void setDsc_ven(double dsc_ven) {
		this.dsc_ven = dsc_ven;
	}

	public double getImp_ven() {
		return imp_ven;
	}

	public void setImp_ven(double imp_ven) {
		this.imp_ven = imp_ven;
	}

	public Venta getObjVenta() {
		return objVenta;
	}

	public void setObjVenta(Venta objVenta) {
		this.objVenta = objVenta;
	}

	public Producto getObjProducto() {
		return objProducto;
	}

	public void setObjProducto(Producto objProducto) {
		this.objProducto = objProducto;
	}

	@Override
	public String toString() {
		return "DetalleVenta [ide_dve=" + ide_dve + ", ide_ven=" + ide_ven + ", ide_pro=" + ide_pro + ", can_ven="
				+ can_ven + ", pre_ven=" + pre_ven + ", dsc_ven=" + dsc_ven + ", imp_ven=" + imp_ven + ", objVenta="
				+ objVenta + ", objProducto=" + objProducto + "]";
	}
	
	

}
