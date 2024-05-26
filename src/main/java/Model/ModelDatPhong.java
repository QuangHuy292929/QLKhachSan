package Model;

import java.time.LocalDateTime;  


public class ModelDatPhong {
	
	private int madatphong;
	private ModelKhachHang khachhang;
	private Phong phong;
	private LocalDateTime ngaygiovophong;
	private LocalDateTime ngaygiotraphong;
	private int chiphiphong;
	
	public ModelDatPhong(int madatphong, ModelKhachHang khachhang, Phong phong, LocalDateTime ngaygiovophong,
			LocalDateTime ngaygiotraphong, int chiphiphong) {
		this.madatphong = madatphong;
		this.khachhang = khachhang;
		this.phong = phong;
		this.ngaygiovophong = ngaygiovophong;
		this.ngaygiotraphong = ngaygiotraphong;
		this.chiphiphong = chiphiphong;
	}
	
	public int getMadatphong() {
		return madatphong;
	}
	public void setMadatphong(int madatphong) {
		this.madatphong = madatphong;
	}
	public ModelKhachHang getKhachhang() {
		return khachhang;
	}
	public void setKhachhang(ModelKhachHang khachhang) {
		this.khachhang = khachhang;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
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
	public int getChiphiphong() {
		return chiphiphong;
	}
	public void setChiphiphong(int chiphiphong) {
		this.chiphiphong = chiphiphong;
	}
	
	
}

