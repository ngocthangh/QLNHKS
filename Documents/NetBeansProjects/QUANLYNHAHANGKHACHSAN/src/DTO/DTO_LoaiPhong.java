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
public class DTO_LoaiPhong {
    private String MaLoaiPhong;
    private String TenLoaiPhong;
    private double DonGia;
    private String MoTa;

    public DTO_LoaiPhong() {
    }

    public DTO_LoaiPhong(String MaLoaiPhong, String TenLoaiPhong, double DonGia, String MoTa) {
        this.MaLoaiPhong = MaLoaiPhong;
        this.TenLoaiPhong = TenLoaiPhong;
        this.DonGia = DonGia;
        this.MoTa = MoTa;
    }

    public String getMaLoaiPhong() {
        return MaLoaiPhong;
    }

    public String getTenLoaiPhong() {
        return TenLoaiPhong;
    }

    public double getDonGia() {
        return DonGia;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMaLoaiPhong(String MaLoaiPhong) {
        this.MaLoaiPhong = MaLoaiPhong;
    }

    public void setTenLoaiPhong(String TenLoaiPhong) {
        this.TenLoaiPhong = TenLoaiPhong;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
    
    
}
