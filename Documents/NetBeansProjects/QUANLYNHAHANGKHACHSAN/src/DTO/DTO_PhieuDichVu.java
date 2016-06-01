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
public class DTO_PhieuDichVu {
    private String MaPhieuDichVu;
    private String MaKhach;
    private String NgayDat;
    private String TriGia;

    public DTO_PhieuDichVu() {
    }

    public DTO_PhieuDichVu(String MaPhieuDichVu, String MaKhach, String NgayDat, String TriGia) {
        this.MaPhieuDichVu = MaPhieuDichVu;
        this.MaKhach = MaKhach;
        this.NgayDat = NgayDat;
        this.TriGia = TriGia;
    }

    public String getMaPhieuDichVu() {
        return MaPhieuDichVu;
    }

    public String getMaKhach() {
        return MaKhach;
    }

    public String getNgayDat() {
        return NgayDat;
    }

    public String getTriGia() {
        return TriGia;
    }

    public void setMaPhieuDichVu(String MaPhieuDichVu) {
        this.MaPhieuDichVu = MaPhieuDichVu;
    }

    public void setMaKhach(String MaKhach) {
        this.MaKhach = MaKhach;
    }

    public void setNgayDat(String NgayDat) {
        this.NgayDat = NgayDat;
    }

    public void setTriGia(String TriGia) {
        this.TriGia = TriGia;
    }
    
    
}
