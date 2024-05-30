package Model;

import Model.Phong.TrangThaiPhong;

public class Modelchuoi {
		private int maphong;
		private TrangThaiPhong trangthai;
	    private String hoVaTen;
	    private String maKhachHang;
	    private String cccd;
	    private String sdt;
	    private boolean tuanTrangMat;
	    private boolean duaDonSanBay;
	    private boolean dungDiemTam;
	    private boolean trongTre;
	    private boolean choThueXe;
	    private boolean giatui;
	    private boolean spa;
	    private boolean fitness;
	    private String ngaygiovaophong;
	    
		
		public Modelchuoi(int maphong, TrangThaiPhong trangthai, String hoVaTen, String maKhachHang, String cccd, String sdt, boolean tuanTrangMat,
				boolean duaDonSanBay, boolean dungDiemTam, boolean trongTre, boolean choThueXe, boolean giatui, boolean spa, boolean fitness,
				String ngaygiovaophong) {
			this.maphong = maphong;
			this.trangthai = trangthai;
			this.hoVaTen = hoVaTen;
			this.maKhachHang = maKhachHang;
			this.cccd = cccd;
			this.sdt = sdt;
			this.tuanTrangMat = tuanTrangMat;
			this.duaDonSanBay = duaDonSanBay;
			this.dungDiemTam = dungDiemTam;
			this.trongTre = trongTre;
			this.choThueXe = choThueXe;
			this.giatui = giatui;
			this.spa = spa;
			this.fitness = fitness;
			this.ngaygiovaophong = ngaygiovaophong;
		}
		
		
		public boolean isGiatui() {
			return giatui;
		}


		public void setGiatui(boolean giatui) {
			this.giatui = giatui;
		}


		public int getMaphong() {
			return maphong;
		}


		public void setMaphong(int maphong) {
			this.maphong = maphong;
		}


		public TrangThaiPhong getTrangthai() {
			return trangthai;
		}


		public void setTrangthai(TrangThaiPhong trangthai) {
			this.trangthai = trangthai;
		}


		public String getNgaygiovaophong() {
			return ngaygiovaophong;
		}


		public void setNgaygiovaophong(String ngaygiovaophong) {
			this.ngaygiovaophong = ngaygiovaophong;
		}


		public Modelchuoi() {

		}

		public String getHoVaTen() {
			return hoVaTen;
		}
		public void setHoVaTen(String hoVaTen) {
			this.hoVaTen = hoVaTen;
		}
		public String getMaKhachHang() {
			return maKhachHang;
		}
		public void setMaKhachHang(String maKhachHang) {
			this.maKhachHang = maKhachHang;
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
		public boolean isTuanTrangMat() {
			return tuanTrangMat;
		}
		public void setTuanTrangMat(boolean tuanTrangMat) {
			this.tuanTrangMat = tuanTrangMat;
		}
		public boolean isDuaDonSanBay() {
			return duaDonSanBay;
		}
		public void setDuaDonSanBay(boolean duaDonSanBay) {
			this.duaDonSanBay = duaDonSanBay;
		}
		public boolean isDungDiemTam() {
			return dungDiemTam;
		}
		public void setDungDiemTam(boolean dungDiemTam) {
			this.dungDiemTam = dungDiemTam;
		}
		public boolean isTrongTre() {
			return trongTre;
		}
		public void setTrongTre(boolean trongTre) {
			this.trongTre = trongTre;
		}
		
		public boolean isChoThueXe() {
			return choThueXe;
		}
		public void setChoThueXe(boolean choThueXe) {
			this.choThueXe = choThueXe;
		}
		
		public String getngaygiovaophong() {
			return ngaygiovaophong;
		}
		public void setngaygiovaophong(String ngaygiovaophong) {
			this.ngaygiovaophong=ngaygiovaophong;
		}
		
		public boolean isSpa() {
			return spa;
		}
		public void setSpa(boolean spa) {
			this.spa = spa;
		}
		public boolean isFitness() {
			return fitness;
		}
		public void setFitness(boolean fitness) {
			this.fitness = fitness;
		}
		
}