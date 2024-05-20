package Model;

import java.time.LocalDateTime; 
import java.util.ArrayList;

public class ModelDatPhong {
	
	private int madatphong;
	private int maKhachHang;
	private int maPhong;
	private LocalDateTime ngaygiovophong;
	private LocalDateTime ngaygiotraphong;
	private int songuoio;
	private int chiphiphong;
	
	public ModelDatPhong(int madatphong, int maKhachHang, int maPhong, LocalDateTime ngaygiovophong,
			LocalDateTime ngaygiotraphong, int songuoio, int chiphiphong) {
		this.madatphong = madatphong;
		this.maKhachHang = maKhachHang;
		this.maPhong = maPhong;
		this.ngaygiovophong = ngaygiovophong;
		this.ngaygiotraphong = ngaygiotraphong;
		this.songuoio = songuoio;
		this.chiphiphong = chiphiphong;
	}
	
	public ModelDatPhong() {
	}

	public int getMadatphong() {
		return madatphong;
	}
	public void setMadatphong(int madatphong) {
		this.madatphong = madatphong;
	}

	public int getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public int getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}

	public LocalDateTime getNgaygiovophong() {
		return ngaygiovophong;
	}
	public void setNgaygiovophong(LocalDateTime ngaygiovophong) {
		this.ngaygiovophong = ngaygiovophong;
	}
	public LocalDateTime getNgaygiotraphong() {
		return ngaygiotraphong;
	}
	public void setNgaygiotraphong(LocalDateTime ngaygiotraphong) {
		this.ngaygiotraphong = ngaygiotraphong;
	}
	public int getSonguoio() {
		return songuoio;
	}
	public void setSonguoio(int songuoio) {
		this.songuoio = songuoio;
	}
	public int getChiphiphong() {
		return chiphiphong;
	}
	public void setChiphiphong(int chiphiphong) {
		this.chiphiphong = chiphiphong;
	}
	
	static ArrayList<ModelDatPhong> listDatPhong;
	
}
