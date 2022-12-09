package main;

import controler.QuanLySinhVien;
import doc_ghi_file.DocVaGhi;

import java.io.Serializable;
import java.util.Scanner;

public class Main implements Serializable {

    public static void main(String[] args) {
        QuanLySinhVien quanLySinhVien = QuanLySinhVien.getInstance();

        Scanner scanner = new Scanner(System.in);

        DocVaGhi docVaGhi = new DocVaGhi();
        quanLySinhVien.getAll();
        while (true) {
            System.out.println("Mời nhập lựa chọn");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Sắp xếp danh sách sinh viên");
            System.out.println("5. Thoát chương trình");

            int choice;
            do {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (Exception e) {
                    System.err.println("Phải nhập số!");
                }
            } while (true);

            switch (choice) {
                case 1 -> {
                    quanLySinhVien.themSinhVien(quanLySinhVien.getSinhVien());
                    docVaGhi.xuatRaFile(quanLySinhVien.getAll());
                }
                case 2 -> {
                    quanLySinhVien.suaSinhVien();
                    docVaGhi.xuatRaFile(quanLySinhVien.getAll());
                }
                case 3 -> {
                    quanLySinhVien.xoaSinhVien();
                    docVaGhi.xuatRaFile(quanLySinhVien.getAll());
                }
                case 4 -> {
                    System.out.println("1. Danh sách Sinh viên theo mã ");
                    System.out.println("2. Danh sách Sinh viên theo tên ");
                    System.out.println("3. Danh sách Sinh viên theo điểm TB ");
                    int choice1;
                    do {
                        try {
                            choice1 = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (Exception e) {
                            System.err.println("Phải nhập số!");
                        }
                    } while (true);
                    switch (choice1) {
                        case 1 -> {
                            quanLySinhVien.sapXepTheoMaSV();
                            quanLySinhVien.show();
                        }
                        case 2 -> {
                            quanLySinhVien.sapXepTheoTenSinhVien();
                            quanLySinhVien.show();
                        }
                        case 3 -> {
                            quanLySinhVien.sapXepTheoDiem();
                            quanLySinhVien.show();
                        }
                        default -> System.out.println("Không có lựa chọn này");
                    }
                }
                case 5 -> System.exit(0);
                default -> System.out.println("Không có lựa chọn này");

            }
        }
    }
}