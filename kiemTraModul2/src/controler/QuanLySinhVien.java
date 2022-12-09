package controler;

import doc_ghi_file.DocVaGhi;
import model.SinhVien;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class QuanLySinhVien implements Serializable {
    SinhVien sinhVien = new SinhVien();
    Scanner scanner = new Scanner(System.in);
    DocVaGhi docVaGhi = new DocVaGhi();
    List<SinhVien> danhSachSinhVien = docVaGhi.docTuFile();
    private static QuanLySinhVien instance;

    public static QuanLySinhVien getInstance() {
        if (instance == null) {
            instance = new QuanLySinhVien();
        }
        return instance;
    }

    public List<SinhVien> getAll(){
        return danhSachSinhVien;
    }
    public void themSinhVien(SinhVien sinhVien) {
        if (sinhVien != null) {
            danhSachSinhVien.add(sinhVien);
        } else {
            System.out.println("Sinh viên chưa được tạo");
        }

    }

    public SinhVien getSinhVien() {

        System.out.println("Nhập mã Sinh Viên");
        String maSV = scanner.nextLine();

        if (timKiem(maSV) == null) {

            System.out.println("Nhập tên Sinh Viên");
            String tenSV = scanner.nextLine();

            System.out.println("Nhập tuổi");
            int tuoi;
            do {
                try {
                    tuoi = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (Exception e) {
                    System.err.println("Phải nhập số!");
                }
            } while (true);

            System.out.println("Nhập giới tính");
            String gioiTinh = scanner.nextLine();

            System.out.println("Nhập tên địa chỉ");
            String diaChi = scanner.nextLine();

            System.out.println("Nhập điểm trung Bình");
            double diemTB = Double.parseDouble(scanner.nextLine());

            sinhVien = new SinhVien(maSV, tenSV, tuoi, gioiTinh, diaChi, diemTB);
            System.out.println("Bạn đã tạo mới sinh viên: " + sinhVien);
            return sinhVien;
        } else {
            System.out.println("Sinh viên này đã có trên hệ thống");
            return null;
        }
    }

    public SinhVien timKiem(String maSV) {
        for (SinhVien sinhVien : danhSachSinhVien) {
            if (maSV.equals(sinhVien.getMaSinhVien())) {
                return sinhVien;
            }
        }
        return null;
    }

    public void show() {
        for (SinhVien vien : danhSachSinhVien) {
            System.out.println(vien + "\n");
        }
        if(danhSachSinhVien== null|| danhSachSinhVien.size()==0){
            System.out.println("Danh sách trống!");
        }
    }

    public void suaSinhVien() {
        System.out.println("Nhập mã sinh viên");
        String maSv = scanner.nextLine();
        if (timKiem(maSv) == null) {
            System.out.println("Không có sinh viên này!");
        } else {
            danhSachSinhVien.set(danhSachSinhVien.indexOf(timKiem(maSv)), getSinhVien());
            System.out.println("Thao tác sửa thành công");
        }
    }

    public void xoaSinhVien() {
        System.out.println("Nhập mã sinh viên");
        String maSv = scanner.nextLine();
        if (timKiem(maSv) == null) {
            System.out.println("Không có sinh viên này!");
        } else {
            danhSachSinhVien.remove(timKiem(maSv));
            System.out.println("Thao tác xóa thành công");
        }
    }

    public void sapXepTheoMaSV() {
        danhSachSinhVien.sort(Comparator.comparing(SinhVien::getMaSinhVien));
    }

    public void sapXepTheoTenSinhVien() {
        danhSachSinhVien.sort(Comparator.comparing(SinhVien::getHoVaTen));
    }

    public void sapXepTheoDiem() {
        danhSachSinhVien.sort(Comparator.comparing(SinhVien::getDiemTrungBinh));
    }
}
