package thuVien;

public class Sach extends TaiLieu {
	private String tenTacGia;
	private int soTrang;

	public Sach(String maTaiLieu, String tenNXB, int soBPH, String tenTacGia, int soTrang) {
		super(maTaiLieu, tenNXB, soBPH);
		this.tenTacGia = tenTacGia;
		this.soTrang = soTrang;
	}

	
	public String getTenTacGia() {
		return tenTacGia;
	}

	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}


	@Override
	public String toString() {
		return "Sach [Ma tai lieu: " + getMaTaiLieu() + ", Ten NXB: " + getTenNXB() + ", So ban phat hanh: " + + getSoBPH() + ", Ten tac gia: " + tenTacGia + ", So trang: " + soTrang + "]";
	}


	
	
}
