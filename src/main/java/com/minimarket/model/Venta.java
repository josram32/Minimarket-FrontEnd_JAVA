package com.minimarket.model;

public class Venta {
	
	private int ide_ven;
	private int ide_cli;
	private int ide_usu;
	private int ide_tco;
	private int num_com;
	private int ide_tpa;
	private int ide_ten;
	private String fec_ven;
	private String fec_ent;
	private String dir_ent;
	private String ide_ubi;
	private String per_con;
	private double tot_ven;
	
	private Cliente objCliente;
	
	private Usuario objUsuario;
	
	private TipoComprobante objTipoComprobante;
	
	private TipoPago objTipoPago;
	
	private TipoEntrega objTipoEntrega;
	
	private Ubigeo objUbigeo;

	public int getIde_ven() {
		return ide_ven;
	}

	public void setIde_ven(int ide_ven) {
		this.ide_ven = ide_ven;
	}

	public int getIde_cli() {
		return ide_cli;
	}

	public void setIde_cli(int ide_cli) {
		this.ide_cli = ide_cli;
	}

	public int getIde_usu() {
		return ide_usu;
	}

	public void setIde_usu(int ide_usu) {
		this.ide_usu = ide_usu;
	}

	public int getIde_tco() {
		return ide_tco;
	}

	public void setIde_tco(int ide_tco) {
		this.ide_tco = ide_tco;
	}

	public int getNum_com() {
		return num_com;
	}

	public void setNum_com(int num_com) {
		this.num_com = num_com;
	}

	public int getIde_tpa() {
		return ide_tpa;
	}

	public void setIde_tpa(int ide_tpa) {
		this.ide_tpa = ide_tpa;
	}

	public int getIde_ten() {
		return ide_ten;
	}

	public void setIde_ten(int ide_ten) {
		this.ide_ten = ide_ten;
	}

	public String getFec_ven() {
		return fec_ven;
	}

	public void setFec_ven(String fec_ven) {
		this.fec_ven = fec_ven;
	}

	public String getFec_ent() {
		return fec_ent;
	}

	public void setFec_ent(String fec_ent) {
		this.fec_ent = fec_ent;
	}

	public String getDir_ent() {
		return dir_ent;
	}

	public void setDir_ent(String dir_ent) {
		this.dir_ent = dir_ent;
	}

	public String getIde_ubi() {
		return ide_ubi;
	}

	public void setIde_ubi(String ide_ubi) {
		this.ide_ubi = ide_ubi;
	}

	public String getPer_con() {
		return per_con;
	}

	public void setPer_con(String per_con) {
		this.per_con = per_con;
	}

	public double getTot_ven() {
		return tot_ven;
	}

	public void setTot_ven(double tot_ven) {
		this.tot_ven = tot_ven;
	}

	public Cliente getObjCliente() {
		return objCliente;
	}

	public void setObjCliente(Cliente objCliente) {
		this.objCliente = objCliente;
	}

	public Usuario getObjUsuario() {
		return objUsuario;
	}

	public void setObjUsuario(Usuario objUsuario) {
		this.objUsuario = objUsuario;
	}

	public TipoComprobante getObjTipoComprobante() {
		return objTipoComprobante;
	}

	public void setObjTipoComprobante(TipoComprobante objTipoComprobante) {
		this.objTipoComprobante = objTipoComprobante;
	}

	public TipoPago getObjTipoPago() {
		return objTipoPago;
	}

	public void setObjTipoPago(TipoPago objTipoPago) {
		this.objTipoPago = objTipoPago;
	}

	public TipoEntrega getObjTipoEntrega() {
		return objTipoEntrega;
	}

	public void setObjTipoEntrega(TipoEntrega objTipoEntrega) {
		this.objTipoEntrega = objTipoEntrega;
	}

	public Ubigeo getObjUbigeo() {
		return objUbigeo;
	}

	public void setObjUbigeo(Ubigeo objUbigeo) {
		this.objUbigeo = objUbigeo;
	}

	@Override
	public String toString() {
		return "Venta [ide_ven=" + ide_ven + ", ide_cli=" + ide_cli + ", ide_usu=" + ide_usu + ", ide_tco=" + ide_tco
				+ ", num_com=" + num_com + ", ide_tpa=" + ide_tpa + ", ide_ten=" + ide_ten + ", fec_ven=" + fec_ven
				+ ", fec_ent=" + fec_ent + ", dir_ent=" + dir_ent + ", ide_ubi=" + ide_ubi + ", per_con=" + per_con
				+ ", tot_ven=" + tot_ven + ", objCliente=" + objCliente + ", objUsuario=" + objUsuario
				+ ", objTipoComprobante=" + objTipoComprobante + ", objTipoPago=" + objTipoPago + ", objTipoEntrega="
				+ objTipoEntrega + ", objUbigeo=" + objUbigeo + "]";
	}
	

}
