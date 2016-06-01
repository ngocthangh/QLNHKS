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
public class DTO_CTPhieuDatPhong {
    private String MaPhieuDat;
    private String MaPhong;
    private String NgayNhanPhong;
    private String NgayTraPhong;
    private int SoKhach;
    private double DonGia;

    public DTO_CTPhieuDatPhong() {
    }

    public DTO_CTPhieuDatPhong(String MaPhieuDat, String MaPhong, String NgayNhanPhong, String NgayTraPhong, int SoKhach, double DonGia) {
        this.MaPhieuDat = MaPhieuDat;
        this.MaPhong = MaPhong;
        this.NgayNhanPhong = NgayNhanPhong;
        this.NgayTraPhong = NgayTraPhong;
        this.SoKhach = SoKhach;
        this.DonGia = DonGia;
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

    public int getSoKhach() {
        return SoKhach;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
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

    public void setSoKhach(int SoKhach) {
        this.SoKhach = SoKhach;
    }

}
