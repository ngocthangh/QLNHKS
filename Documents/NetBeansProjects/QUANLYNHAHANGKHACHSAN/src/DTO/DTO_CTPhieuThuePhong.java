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
public class DTO_CTPhieuThuePhong {
    private String MaPhieuThuePhong;
    private String MaKhach;

    public DTO_CTPhieuThuePhong() {
    }

    public DTO_CTPhieuThuePhong(String MaPhieuThuePhong, String MaKhach) {
        this.MaPhieuThuePhong = MaPhieuThuePhong;
        this.MaKhach = MaKhach;
    }

    public String getMaPhieuThuePhong() {
        return MaPhieuThuePhong;
    }

    public String getMaKhach() {
        return MaKhach;
    }

    public void setMaPhieuThuePhong(String MaPhieuThuePhong) {
        this.MaPhieuThuePhong = MaPhieuThuePhong;
    }

    public void setMaKhach(String MaKhach) {
        this.MaKhach = MaKhach;
    }
    
    
}
