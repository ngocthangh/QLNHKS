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
public class DTO_PhieuDatTiec {
    private String MaPhieuDatTiec;
    private String MaKhach;
    private String TriGia;
    private String NgayDat;

    public DTO_PhieuDatTiec() {
    }

    public DTO_PhieuDatTiec(String MaPhieuDatTiec, String MaKhach, String TriGia, String NgayDat) {
        this.MaPhieuDatTiec = MaPhieuDatTiec;
        this.MaKhach = MaKhach;
        this.TriGia = TriGia;
        this.NgayDat = NgayDat;
    }

    public String getMaPhieuDatTiec() {
        return MaPhieuDatTiec;
    }

    public String getMaKhach() {
        return MaKhach;
    }

    public String getTriGia() {
        return TriGia;
    }

    public String getNgayDat() {
        return NgayDat;
    }

    public void setMaPhieuDatTiec(String MaPhieuDatTiec) {
        this.MaPhieuDatTiec = MaPhieuDatTiec;
    }

    public void setMaKhach(String MaKhach) {
        this.MaKhach = MaKhach;
    }

    public void setTriGia(String TriGia) {
        this.TriGia = TriGia;
    }

    public void setNgayDat(String NgayDat) {
        this.NgayDat = NgayDat;
    }
    
    
}
