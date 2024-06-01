package Model;

public class ModelDVSau {
	private String tendv;
	private int dongia;
	private int soluong;
	private int thanhtien;
	public ModelDVSau(String tendv, int dongia, int soluong, int thanhtien) {
		this.tendv = tendv;
		this.dongia = dongia;
		this.soluong = soluong;
		this.thanhtien = thanhtien;
	}
	public ModelDVSau() {
	}
	public String getTendv() {
		return tendv;
	}
	public void setTendv(String tendv) {
		this.tendv = tendv;
	}
	public int getDongia() {
		return dongia;
	}
	public void setDongia(int dongia) {
		this.dongia = dongia;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(int thanhtien) {
		this.thanhtien = thanhtien;
	}
	
	
}
