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
public class DTO_PhieuDatPhong {
    private String MaPhieuDat;
    private String MaKhach;
    private int SoPhong;
    private double TriGia;
    

    public DTO_PhieuDatPhong() {
    }

    public DTO_PhieuDatPhong(String MaPhieuDat, String MaKhach, int SoPhong, double TriGia) {
        this.MaPhieuDat = MaPhieuDat;
        this.MaKhach = MaKhach;
        this.SoPhong = SoPhong;
        this.TriGia = TriGia;
    }

    

    public String getMaPhieuDat() {
        return MaPhieuDat;
    }

    public String getMaKhach() {
        return MaKhach;
    }

    public int getSoPhong() {
        return SoPhong;
    }

    public double getTriGia() {
        return TriGia;
    }

    
    
    public void setMaPhieuDat(String MaPhieuDat) {
        this.MaPhieuDat = MaPhieuDat;
    }

    public void setMaKhach(String MaKhach) {
        this.MaKhach = MaKhach;
    }

    public void setSoPhong(int SoPhong) {
        this.SoPhong = SoPhong;
    }

    public void setTriGia(double TriGia) {
        this.TriGia = TriGia;
    }

    
}
