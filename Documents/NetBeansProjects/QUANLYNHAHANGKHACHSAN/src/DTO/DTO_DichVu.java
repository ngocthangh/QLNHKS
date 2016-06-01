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
public class DTO_DichVu {
    private String MaDichVu;
    private String TenDichVu;
    private double DonGia;
    
    
    public DTO_DichVu() {
    }

    public DTO_DichVu(String MaDichVu, String TenDichVu, double DonGia) {
        this.MaDichVu = MaDichVu;
        this.TenDichVu = TenDichVu;
        this.DonGia = DonGia;
    }


    public String getMaDichVu() {
        return MaDichVu;
    }

    public String getTenDichVu() {
        return TenDichVu;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setMaDichVu(String MaDichVu) {
        this.MaDichVu = MaDichVu;
    }

    public void setTenDichVu(String TenDichVu) {
        this.TenDichVu = TenDichVu;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }
    
}
