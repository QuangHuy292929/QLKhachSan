package Model;

public class Phong {
	private int id;
	private String tenPhong;
	private TrangThaiPhong TrangThai;
	public Phong(int id, String tenPhong, TrangThaiPhong TrangThai) {
		this.id = id;
		this.tenPhong = tenPhong;
		this.TrangThai = TrangThai;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	public TrangThaiPhong getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(TrangThaiPhong TrangThai) {
		this.TrangThai = TrangThai;
	}
	public enum TrangThaiPhong{
		TRONG, DANG_HOAT_DONG, CHO_XAC_NHAN
	}
	

}

