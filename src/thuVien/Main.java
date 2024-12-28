package thuVien;

public class Main {
	public static void main(String[] args) {
		QuanLySach qLySach = new QuanLySach();
		qLySach.themTaiLieu(new Sach("S01", "Kim Dong", 1, "Nam Cao", 1));
		qLySach.themTaiLieu(new Bao("B01", "Phu nu", 10, "12/01/2021"));
		qLySach.themTaiLieu(new TapChi("TC01", "La cai", 10, 5, "12"));
		qLySach.hienThiTaiLieu("S01");
		qLySach.hienThiTaiLieu("B01");
		qLySach.hienThiTaiLieu("TC01");
	}
}
