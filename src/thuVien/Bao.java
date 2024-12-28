package thuVien;

public class Bao extends TaiLieu {
	private String ngayPhatHanh;

	public Bao(String maTaiLieu, String tenNXB, int soBPH, String ngayPhatHanh) {
		super(maTaiLieu, tenNXB, soBPH);
		this.ngayPhatHanh = ngayPhatHanh;
	}

	public String getNgayPhatHanh() {
		return ngayPhatHanh;
	}

	public void setNgayPhatHanh(String ngayPhatHanh) {
		this.ngayPhatHanh = ngayPhatHanh;
	}

	@Override
	public String toString() {
		return "Bao [Ma tai lieu: " + getMaTaiLieu() + ", Ten NXB: " + getTenNXB() + ", So ban phat hanh: " + getSoBPH()
				+ ", Ngay phat hanh: " + ngayPhatHanh + "]";
	}

	
}
