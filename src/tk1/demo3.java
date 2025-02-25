package tk1;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class SinhVien {
    private String maSV;
    private String hoTen;
    private String lop;

    public SinhVien(String maSV, String hoTen, String lop) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.lop = lop;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    @Override
    public String toString() {
        return maSV + ", " + hoTen + ", " + lop;
    }
}

class QuanLySinhVien {
    private List<SinhVien> danhSachSV;
    private final String fileName = "SINHVIEN.txt";

    public QuanLySinhVien() {
        this.danhSachSV = new ArrayList<>();
    }

    public synchronized void khoiTaoSinhVien(String maSV, String hoTen, String lop) {
        System.out.println(Thread.currentThread().getName() + " đang thêm sinh viên: " + maSV);
        SinhVien sv = new SinhVien(maSV, hoTen, lop);
        danhSachSV.add(sv);
        ghiFile();
    }

    public synchronized void suaThongTinSinhVien(String maSV, String hoTenMoi, String lopMoi) {
        System.out.println(Thread.currentThread().getName() + " đang sửa sinh viên: " + maSV);
        for (SinhVien sv : danhSachSV) {
            if (sv.getMaSV().equals(maSV)) {
                if (hoTenMoi != null && !hoTenMoi.isEmpty()) {
                    sv.setHoTen(hoTenMoi);
                }
                if (lopMoi != null && !lopMoi.isEmpty()) {
                    sv.setLop(lopMoi);
                }
                break;
            }
        }
        ghiFile();
    }

    public synchronized void xoaSinhVien(String maSV) {
        System.out.println(Thread.currentThread().getName() + " đang xóa sinh viên: " + maSV);
        Iterator<SinhVien> iterator = danhSachSV.iterator();
        while (iterator.hasNext()) {
            SinhVien sv = iterator.next();
            if (sv.getMaSV().equals(maSV)) {
                iterator.remove();
                break;
            }
        }
        ghiFile();
    }

    private void ghiFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (SinhVien sv : danhSachSV) {
                writer.write(sv.toString());
                writer.newLine();
            }
            System.out.println(Thread.currentThread().getName() + " đã ghi file thành công");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public synchronized void inDanhSach() {
        System.out.println("Danh sách sinh viên hiện tại:");
        for (SinhVien sv : danhSachSV) {
            System.out.println(sv);
        }
        System.out.println();
    }
}

class KhoiTaoThread implements Runnable {
    private QuanLySinhVien quanLy;
    private String maSV;
    private String hoTen;
    private String lop;

    public KhoiTaoThread(QuanLySinhVien quanLy, String maSV, String hoTen, String lop) {
        this.quanLy = quanLy;
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.lop = lop;
    }

    @Override
    public void run() {
        quanLy.khoiTaoSinhVien(maSV, hoTen, lop);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SuaThread implements Runnable {
    private QuanLySinhVien quanLy;
    private String maSV;
    private String hoTenMoi;
    private String lopMoi;

    public SuaThread(QuanLySinhVien quanLy, String maSV, String hoTenMoi, String lopMoi) {
        this.quanLy = quanLy;
        this.maSV = maSV;
        this.hoTenMoi = hoTenMoi;
        this.lopMoi = lopMoi;
    }

    @Override
    public void run() {
        quanLy.suaThongTinSinhVien(maSV, hoTenMoi, lopMoi);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class XoaThread implements Runnable {
    private QuanLySinhVien quanLy;
    private String maSV;

    public XoaThread(QuanLySinhVien quanLy, String maSV) {
        this.quanLy = quanLy;
        this.maSV = maSV;
    }

    @Override
    public void run() {
        quanLy.xoaSinhVien(maSV);
    }
}

public class demo3 {
    public static void main(String[] args) {
        QuanLySinhVien quanLy = new QuanLySinhVien();

        ThreadGroup khoiTaoGroup = new ThreadGroup("KHOITAO");
        ThreadGroup suaGroup = new ThreadGroup("SUA");
        ThreadGroup xoaGroup = new ThreadGroup("XOA");

        try {
            System.out.println("Bắt đầu chương trình quản lý sinh viên");

            Thread khoiTao1 = new Thread(khoiTaoGroup, new KhoiTaoThread(quanLy, "000001", "NGUYEN VAN NAM", "DHCNTT13B"), "KhoiTao-Thread-1");
            Thread khoiTao2 = new Thread(khoiTaoGroup, new KhoiTaoThread(quanLy, "000002", "NGUYEN THI MAI", "DHCNTT13B"), "KhoiTao-Thread-2");
            Thread khoiTao3 = new Thread(khoiTaoGroup, new KhoiTaoThread(quanLy, "000003", "NGUYEN MAN", "DHCNTT13B"), "KhoiTao-Thread-3");

            System.out.println("Đang khởi tạo sinh viên...");
            khoiTao1.start();
            khoiTao2.start();
            khoiTao3.start();

            khoiTao1.join();
            khoiTao2.join();
            khoiTao3.join();
            
            System.out.println("Đã hoàn thành việc khởi tạo sinh viên");
            quanLy.inDanhSach();

            Thread sua1 = new Thread(suaGroup, new SuaThread(quanLy, "000001", "NGUYEN VAN NAM", "DHCNTT13C"), "Sua-Thread-1");
            Thread sua2 = new Thread(suaGroup, new SuaThread(quanLy, "000002", "NGUYEN THI XUAN", "DHCNTT13B"), "Sua-Thread-2");

            System.out.println("Đang sửa thông tin sinh viên...");
            sua1.start();
            sua2.start();

            sua1.join();
            sua2.join();
            
            System.out.println("Đã hoàn thành việc sửa thông tin sinh viên");
            quanLy.inDanhSach();

            Thread xoa = new Thread(xoaGroup, new XoaThread(quanLy, "000002"), "Xoa-Thread");

            System.out.println("Đang xóa sinh viên...");
            xoa.start();

            xoa.join();
            
            System.out.println("Đã hoàn thành việc xóa sinh viên");
            quanLy.inDanhSach();

            System.out.println("Chương trình đã hoàn thành các nhiệm vụ.");

        } catch (InterruptedException e) {
            System.err.println("Lỗi trong quá trình thực thi: " + e.getMessage());
        }
    }
}