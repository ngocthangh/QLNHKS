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
public class DTO_Phong {
    private String MaPhong;
    private String TenPhong;
    private String LoaiPhong;
    private int TinhTrang;

    public DTO_Phong() {
    }

    public DTO_Phong(String MaPhong, String TenPhong, String LoaiPhong, int TinhTrang) {
        this.MaPhong = MaPhong;
        this.TenPhong = TenPhong;
        this.LoaiPhong = LoaiPhong;
        this.TinhTrang = TinhTrang;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public String getTenPhong() {
        return TenPhong;
    }

    public String getLoaiPhong() {
        return LoaiPhong;
    }

    public int getTinhTrang() {
        return TinhTrang;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public void setTenPhong(String TenPhong) {
        this.TenPhong = TenPhong;
    }

    public void setLoaiPhong(String LoaiPhong) {
        this.LoaiPhong = LoaiPhong;
    }

    public void setTinhTrang(int TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    
}
