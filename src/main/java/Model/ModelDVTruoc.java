package Model;

public class ModelDVTruoc {
	private String tendv;
	private int gia;
	public ModelDVTruoc(String tendv, int gia) {
		this.tendv = tendv;
		this.gia = gia;
	}
	public ModelDVTruoc() {
	}
	public String getTendv() {
		return tendv;
	}
	public void setTendv(String tendv) {
		this.tendv = tendv;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	
}