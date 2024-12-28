package thuVien;

public class TapChi extends TaiLieu {
	private int soPhatHanh;
	private String thangPhatHanh;

	public TapChi(String maTaiLieu, String tenNXB, int soBPH, int soPhatHanh, String thangPhatHanh) {
		super(maTaiLieu, tenNXB, soBPH);
		this.soPhatHanh = soPhatHanh;
		this.thangPhatHanh = thangPhatHanh;
	}

	public int getSoPhatHanh() {
		return soPhatHanh;
	}

	public void setSoPhatHanh(int soPhatHanh) {
		this.soPhatHanh = soPhatHanh;
	}

	public String getThangPhatHanh() {
		return thangPhatHanh;
	}

	public void setThangPhatHanh(String thangPhatHanh) {
		this.thangPhatHanh = thangPhatHanh;
	}

	@Override
	public String toString() {
		return "TapChi [Ma tai lieu: " + getMaTaiLieu() + ", Ten NXB: " + getTenNXB() + 
					", So ban phat hanh: " + getSoBPH() + ", So phat hanh: " + soPhatHanh + ", Thang phat hanh: " + thangPhatHanh + "]";
	}


}
