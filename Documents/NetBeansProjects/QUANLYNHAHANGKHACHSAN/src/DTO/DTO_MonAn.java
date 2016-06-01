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
public class DTO_MonAn {
    private String MaMonAn;
    private String TenMonAn;
    private double DonGia;

    public DTO_MonAn() {
    }

    public DTO_MonAn(String MaMonAn, String TenMonAn, double DonGia) {
        this.MaMonAn = MaMonAn;
        this.TenMonAn = TenMonAn;
        this.DonGia = DonGia;
    }

        
    public String getMaMonAn() {
        return MaMonAn;
    }

    public String getTenMonAn() {
        return TenMonAn;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setMaMonAn(String MaMonAn) {
        this.MaMonAn = MaMonAn;
    }

    public void setTenMonAn(String TenMonAn) {
        this.TenMonAn = TenMonAn;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }
    
}
