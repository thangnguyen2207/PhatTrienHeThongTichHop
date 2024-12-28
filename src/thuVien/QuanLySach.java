package thuVien;

import java.util.ArrayList;
import java.util.List;

public class QuanLySach {
	private final List<TaiLieu> tailieu = new ArrayList<TaiLieu>();
	
	public void themTaiLieu(TaiLieu thongtinTailieu) {
		tailieu.add(thongtinTailieu);
	};
	
	public void xoaTaiLieu(String maTaiLieu) {
		for (int i = 0; i < tailieu.size(); i++) {
			if (tailieu.get(i).getMaTaiLieu().equals(maTaiLieu)) {
				tailieu.remove(i);
			}
		}
	}
	
	public void hienThiTaiLieu(String maTaiLieu) {
		for (int i = 0; i < tailieu.size(); i++) {
			if (tailieu.get(i).getMaTaiLieu().equals(maTaiLieu)) {
			System.out.println(tailieu.get(i).toString());
			}
		}
	}
}
