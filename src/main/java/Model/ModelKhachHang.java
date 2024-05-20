package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class ModelKhachHang {
	private int makhachhang;
	private String hoten;
	private LocalDate ngaysinh;
	private String gioitinh;
	private int cccd;
	private int sdt;
	private String email;
	private String Sothetd;
	private String diachi;
	ModelKhachHang(int makhachhang, String hoten, LocalDate ngaysinh, String gioitinh, int cccd, int sdt, String email,
			String sothetd, String diachi) {
		this.makhachhang = makhachhang;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.cccd = cccd;
		this.sdt = sdt;
		this.email = email;
		Sothetd = sothetd;
		this.diachi = diachi;
	}
	
	public ModelKhachHang() {
	}

	public int getMakhachhang() {
		return makhachhang;
	}
	public void setMakhachhang(int makhachhang) {
		this.makhachhang = makhachhang;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public LocalDate getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(LocalDate ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public int getCccd() {
		return cccd;
	}
	public void setCccd(int cccd) {
		this.cccd = cccd;
	}
	public int getSdt() {
		return sdt;
	}
	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSothetd() {
		return Sothetd;
	}
	public void setSothetd(String sothetd) {
		Sothetd = sothetd;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	
	static ArrayList<ModelKhachHang> ListKHang;
	public static ArrayList<ModelKhachHang> getListKHang() {
		return ListKHang;
	}

	public static void setListKHang(ArrayList<ModelKhachHang> listKHang) {
		ListKHang = listKHang;
	}
	
	
	

}
