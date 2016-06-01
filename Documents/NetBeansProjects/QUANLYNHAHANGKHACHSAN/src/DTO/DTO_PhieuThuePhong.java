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
public class DTO_PhieuThuePhong {
    private String MaPhieuThuePhong;
    private String MaPhieuDat;
    private String MaPhong;
    private String NgayNhanPhong;
    private String NgayTraPhong;
    private String SoKhach;
    private double DonGia;
    private double ThanhTien;
    private double TongPhiHuHai;
    private double TongTienDichVu;
    
    public DTO_PhieuThuePhong() {
    }

    public DTO_PhieuThuePhong(String MaPhieuThuePhong, String MaPhieuDat, String MaPhong, String NgayNhanPhong, String NgayTraPhong, String SoKhach, double DonGia, double ThanhTien, double TongPhiHuHai, double TongTienDichVu) {
        this.MaPhieuThuePhong = MaPhieuThuePhong;
        this.MaPhieuDat = MaPhieuDat;
        this.MaPhong = MaPhong;
        this.NgayNhanPhong = NgayNhanPhong;
        this.NgayTraPhong = NgayTraPhong;
        this.SoKhach = SoKhach;
        this.DonGia = DonGia;
        this.ThanhTien = ThanhTien;
        this.TongPhiHuHai = TongPhiHuHai;
        this.TongTienDichVu = TongTienDichVu;
    }
    
    

    public String getMaPhieuThuePhong() {
        return MaPhieuThuePhong;
    }

    public String getMaPhieuDat() {
        return MaPhieuDat;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public String getNgayNhanPhong() {
        return NgayNhanPhong;
    }

    public String getNgayTraPhong() {
        return NgayTraPhong;
    }

    public String getSoKhach() {
        return SoKhach;
    }

    public double getDonGia() {
        return DonGia;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public double getTongPhiHuHai() {
        return TongPhiHuHai;
    }

    public double getTongTienDichVu() {
        return TongTienDichVu;
    }

    public void setMaPhieuThuePhong(String MaPhieuThuePhong) {
        this.MaPhieuThuePhong = MaPhieuThuePhong;
    }

    public void setMaPhieuDat(String MaPhieuDat) {
        this.MaPhieuDat = MaPhieuDat;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public void setNgayNhanPhong(String NgayNhanPhong) {
        this.NgayNhanPhong = NgayNhanPhong;
    }

    public void setNgayTraPhong(String NgayTraPhong) {
        this.NgayTraPhong = NgayTraPhong;
    }

    public void setSoKhach(String SoKhach) {
        this.SoKhach = SoKhach;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public void setTongPhiHuHai(double TongPhiHuHai) {
        this.TongPhiHuHai = TongPhiHuHai;
    }

    public void setTongTienDichVu(double TongTienDichVu) {
        this.TongTienDichVu = TongTienDichVu;
    }

    
    
}
