package Model;

public class ModelKhachHang {
	private String makhachhang;
	private String hoten;
	private String cccd;
	private String sdt;
	private String email;
	private String username;
	public ModelKhachHang(String makhachhang, String hoten, String cccd, String sdt, String email, String username) {
		this.makhachhang = makhachhang;
		this.hoten = hoten;
		this.cccd = cccd;
		this.sdt = sdt;
		this.email = email;
		this.username = username;
	}
	
	
	public ModelKhachHang() {
	}


	public String getMakhachhang() {
		return makhachhang;
	}
	public void setMakhachhang(String makhachhang) {
		this.makhachhang = makhachhang;
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
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
