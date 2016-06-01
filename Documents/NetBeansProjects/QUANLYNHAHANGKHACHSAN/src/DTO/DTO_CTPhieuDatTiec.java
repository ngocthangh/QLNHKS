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
public class DTO_CTPhieuDatTiec {
    private String MaCTPhieuDatTiec;
    private String MaPhieuDatTiec;
    private String MaMonAn;
    private int DonGia;
    private int SoLuong;

    public DTO_CTPhieuDatTiec() {
    }

    public DTO_CTPhieuDatTiec(String MaCTPhieuDatTiec, String MaPhieuDatTiec, String MaMonAn, int DonGia, int SoLuong) {
        this.MaCTPhieuDatTiec = MaCTPhieuDatTiec;
        this.MaPhieuDatTiec = MaPhieuDatTiec;
        this.MaMonAn = MaMonAn;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
    }

    public String getMaCTPhieuDatTiec() {
        return MaCTPhieuDatTiec;
    }

    public String getMaPhieuDatTiec() {
        return MaPhieuDatTiec;
    }

    public String getMaMonAn() {
        return MaMonAn;
    }

    public int getDonGia() {
        return DonGia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setMaCTPhieuDatTiec(String MaCTPhieuDatTiec) {
        this.MaCTPhieuDatTiec = MaCTPhieuDatTiec;
    }

    public void setMaPhieuDatTiec(String MaPhieuDatTiec) {
        this.MaPhieuDatTiec = MaPhieuDatTiec;
    }

    public void setMaMonAn(String MaMonAn) {
        this.MaMonAn = MaMonAn;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    
}
