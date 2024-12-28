package thuVien;

public abstract class TaiLieu {
	private String maTaiLieu;
	private String tenNXB;
	private int soBPH;
	
	
	public TaiLieu(String maTaiLieu, String tenNXB, int soBPH) {
		super();
		this.maTaiLieu = maTaiLieu;
		this.tenNXB = tenNXB;
		this.soBPH = soBPH;
	}
	public String getMaTaiLieu() {
		return maTaiLieu;
	}
	public void setMaTaiLieu(String maTaiLieu) {
		this.maTaiLieu = maTaiLieu;
	}
	public String getTenNXB() {
		return tenNXB;
	}
	public void setTenNXB(String tenNXB) {
		this.tenNXB = tenNXB;
	}
	public int getSoBPH() {
		return soBPH;
	}
	public void setSoBPH(int soBPH) {
		this.soBPH = soBPH;
	}
	
}
