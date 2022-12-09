package doc_ghi_file;

import model.SinhVien;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocVaGhi implements Serializable {
    public void xuatRaFile( List<SinhVien> danhSachSinhVien) {

        try {
            FileOutputStream luuDanhSach = new FileOutputStream("danhSach.csv");
            ObjectOutputStream outputStream = new ObjectOutputStream(luuDanhSach);
            outputStream.writeObject(danhSachSinhVien);
            outputStream.close();
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra");
            e.printStackTrace();
        }
    }

    public List<SinhVien> docTuFile() {

        try {
            FileInputStream luuDanhSach = new FileInputStream("danhSach.csv");
            ObjectInputStream inputStream = new ObjectInputStream(luuDanhSach);
            List<SinhVien> danhSachSinhVien = (List<SinhVien>) inputStream.readObject();
            inputStream.close();
            return danhSachSinhVien;
        } catch (Exception e) {
            System.err.println("Có lỗi xảy ra");
            e.printStackTrace();
        }
        return new ArrayList<>();

    }
}
