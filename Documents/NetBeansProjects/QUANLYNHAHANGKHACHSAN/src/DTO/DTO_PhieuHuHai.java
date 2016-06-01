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
public class DTO_PhieuHuHai {
    private String MaPhieuThuePhong;
    private int Stt;
    private String NoiDungHuHai;
    private double PhiHuHai;

    public DTO_PhieuHuHai() {
    }

    public DTO_PhieuHuHai(String MaPhieuThuePhong, int Stt, String NoiDungHuHai, double PhiHuHai) {
        this.MaPhieuThuePhong = MaPhieuThuePhong;
        this.Stt = Stt;
        this.NoiDungHuHai = NoiDungHuHai;
        this.PhiHuHai = PhiHuHai;
    }

    public String getMaPhieuThuePhong() {
        return MaPhieuThuePhong;
    }

    public int getStt() {
        return Stt;
    }

    public String getNoiDungHuHai() {
        return NoiDungHuHai;
    }

    public double getPhiHuHai() {
        return PhiHuHai;
    }

    public void setMaPhieuThuePhong(String MaPhieuThuePhong) {
        this.MaPhieuThuePhong = MaPhieuThuePhong;
    }

    public void setStt(int Stt) {
        this.Stt = Stt;
    }

    public void setNoiDungHuHai(String NoiDungHuHai) {
        this.NoiDungHuHai = NoiDungHuHai;
    }

    public void setPhiHuHai(double PhiHuHai) {
        this.PhiHuHai = PhiHuHai;
    }

    
}
