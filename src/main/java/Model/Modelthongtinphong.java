package Model;


import java.util.ArrayList;

import Model.Phong.TrangThaiPhong;  


public class Modelthongtinphong {
	
	private TrangThaiPhong trangthai;
	private String makh;
	private Integer madp;
	private String hoten;
	private String cccd;
	private String sdth;
	private String ngayvao;
	private ArrayList<ModelDVTruoc> dvtruoc;
	private ArrayList<ModelDVSau> dvsau;
	public Modelthongtinphong(TrangThaiPhong trangthai, String makh, Integer madp, String hoten, String cccd, String sdth,
			String ngayvao, ArrayList<ModelDVTruoc> dvtruoc, ArrayList<ModelDVSau> dvsau) {
		this.trangthai = trangthai;
		this.makh = makh;
		this.madp = madp;
		this.hoten = hoten;
		this.cccd = cccd;
		this.sdth = sdth;
		this.ngayvao = ngayvao;
		this.dvtruoc = dvtruoc;
		this.dvsau = dvsau;
	}
	public Modelthongtinphong() {
	}
	
	public TrangThaiPhong getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(TrangThaiPhong trangthai) {
		this.trangthai = trangthai;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public Integer getMadp() {
		return madp;
	}
	public void setMadp(Integer madp) {
		this.madp = madp;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getCccd() {
		return cccd;
	}
	public void setCccd(String cccd) {
		this.cccd = cccd;
	}
	public String getSdth() {
		return sdth;
	}
	public void setSdth(String sdth) {
		this.sdth = sdth;
	}
	public String getNgayvao() {
		return ngayvao;
	}
	public void setNgayvao(String ngayvao) {
		this.ngayvao = ngayvao;
	}
	public ArrayList<ModelDVTruoc> getDvtruoc() {
		return dvtruoc;
	}
	public void setDvtruoc(ArrayList<ModelDVTruoc> dvtruoc) {
		this.dvtruoc = dvtruoc;
	}
	public ArrayList<ModelDVSau> getDvsau() {
		return dvsau;
	}
	public void setDvsau(ArrayList<ModelDVSau> dvsau) {
		this.dvsau = dvsau;
	}
	
}

