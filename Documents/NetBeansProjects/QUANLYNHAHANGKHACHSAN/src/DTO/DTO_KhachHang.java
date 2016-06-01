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
public class DTO_KhachHang {
    private String MaKhachHang;
    private String TenKhachHang;
    private String CMND;
    private String DiaChi;
    private String Email;
    private String SoDienThoai;
    private String QuocTich;

    public DTO_KhachHang() {
    }

    public DTO_KhachHang(String MaKhachHang, String TenKhachHang, String CMND, String DiaChi, String Email, String SoDienThoai, String QuocTich) {
        this.MaKhachHang = MaKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.CMND = CMND;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.SoDienThoai = SoDienThoai;
        this.QuocTich = QuocTich;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public String getCMND() {
        return CMND;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getEmail() {
        return Email;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }


    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getQuocTich() {
        return QuocTich;
    }

    public void setQuocTich(String QuocTich) {
        this.QuocTich = QuocTich;
    }

}
