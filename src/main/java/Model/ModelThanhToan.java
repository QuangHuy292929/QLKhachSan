package Model;

import java.time.LocalDateTime;   

public class ModelThanhToan {

	private int mathanhtoan;
	private ModelDatPhong datphong;
	private LocalDateTime GioThanhToan;
	private int tongchiphi;
	public ModelThanhToan(int mathanhtoan, ModelDatPhong datphong, LocalDateTime gioThanhToan, int tongchiphi) {
		this.mathanhtoan = mathanhtoan;
		this.datphong = datphong;
		this.GioThanhToan = gioThanhToan;
		this.tongchiphi = tongchiphi;
		
	}
	public int getMathanhtoan() {
		return mathanhtoan;
	}
	public void setMathanhtoan(int mathanhtoan) {
		this.mathanhtoan = mathanhtoan;
	}
	public ModelDatPhong getDatphong() {
		return datphong;
	}
	public void setDatphong(ModelDatPhong datphong) {
		this.datphong = datphong;
	}
	public LocalDateTime getGioThanhToan() {
		return GioThanhToan;
	}
	public void setGioThanhToan(LocalDateTime gioThanhToan) {
		GioThanhToan = gioThanhToan;
	}
	public int getTongchiphi() {
		return tongchiphi;
	}
	public void setTongchiphi(int tongchiphi) {
		this.tongchiphi = tongchiphi;
	}
	
}

