package Model;
public class ModelDichVu {
	
	private int maDichvu;
	private String tenDichvu;
	private int giaca;
	
	public ModelDichVu(int maDichvu, String tenDichvu, int giaca) {
		
		this.maDichvu = maDichvu;
		this.tenDichvu = tenDichvu;
		this.giaca = giaca;
	}
	public int getMaDichvu() {
		return maDichvu;
	}
	public void setMaDichvu(int maDichvu) {
		this.maDichvu = maDichvu;
	}
	public String getTenDichvu() {
		return tenDichvu;
	}
	public void setTenDichvu(String tenDichvu) {
		this.tenDichvu = tenDichvu;
	}
	public int getGiaca() {
		return giaca;
	}
	public void setGiaca(int giaca) {
		this.giaca = giaca;
	}
	
}
