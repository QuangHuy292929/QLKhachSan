package Model;

import java.time.LocalDateTime;  
import java.util.ArrayList;
public class ModelThanhToan {

	private int mathanhtoan;
	private int madatphong;
	private LocalDateTime GioThanhToan;
	
	private String hinhthuctt;
	private int tongchiphi;
	ModelThanhToan(int mathanhtoan, int madatphong, LocalDateTime GioThanhToan, String hinhthuctt, int tongchiphi) {
		
		this.mathanhtoan = mathanhtoan;
		this.madatphong = madatphong;
		this.GioThanhToan = GioThanhToan;
		this.hinhthuctt = hinhthuctt;
		this.tongchiphi = tongchiphi;
	}
	public int getMathanhtoan() {
		return mathanhtoan;
	}
	public void setMathanhtoan(int mathanhtoan) {
		this.mathanhtoan = mathanhtoan;
	}
	public int getMadatphong() {
		return madatphong;
	}
	public void setMadatphong(int madatphong) {
		this.madatphong = madatphong;
	}
	public LocalDateTime getGioThanhToan() {
		return GioThanhToan;
	}
	public void setGioThanhToan(LocalDateTime GioThanhToan) {
		this.GioThanhToan = GioThanhToan;
	}
	public String getHinhthuctt() {
		return hinhthuctt;
	}
	public void setHinhthuctt(String hinhthuctt) {
		this.hinhthuctt = hinhthuctt;
	}
	public int getTongchiphi() {
		return tongchiphi;
	}
	public void setTongchiphi(int tongchiphi) {
		this.tongchiphi = tongchiphi;
	}
	
	static ArrayList<ModelThanhToan> ListBill;

	public static ArrayList<ModelThanhToan> getListBill() {
		return ListBill;
	}
	public static void setListBill(ArrayList<ModelThanhToan> listBill) {
		ListBill = listBill;
	}
	
	

	
}

