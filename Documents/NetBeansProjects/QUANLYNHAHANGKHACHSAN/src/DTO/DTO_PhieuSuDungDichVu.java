/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Ngoc Thang
 */
public class DTO_PhieuSuDungDichVu {
    private String MaPhieuThuePhong;
    private String MaDichVu;
    private String NgaySuDung;
    private int SoLuong;
    private double DonGia;
    private double ThanhTien;

    public DTO_PhieuSuDungDichVu() {
    }

    public DTO_PhieuSuDungDichVu(String MaPhieuThuePhong, String MaDichVu, String NgaySuDung, int SoLuong, double DonGia, double ThanhTien) {
        this.MaPhieuThuePhong = MaPhieuThuePhong;
        this.MaDichVu = MaDichVu;
        this.NgaySuDung = NgaySuDung;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.ThanhTien = ThanhTien;
    }

    public String getMaPhieuThuePhong() {
        return MaPhieuThuePhong;
    }

    public String getMaDichVu() {
        return MaDichVu;
    }

    public String getNgaySuDung() {
        return NgaySuDung;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public double getDonGia() {
        return DonGia;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setMaPhieuThuePhong(String MaPhieuThuePhong) {
        this.MaPhieuThuePhong = MaPhieuThuePhong;
    }

    public void setMaDichVu(String MaDichVu) {
        this.MaDichVu = MaDichVu;
    }

    public void setNgaySuDung(String NgaySuDung) {
        this.NgaySuDung = NgaySuDung;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
    
}
