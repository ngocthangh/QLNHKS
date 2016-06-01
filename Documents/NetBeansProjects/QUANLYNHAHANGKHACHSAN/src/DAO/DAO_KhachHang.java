/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ConnectDB;
import DTO.DTO_KhachHang;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ngoc Thang
 */
public class DAO_KhachHang {
    public static ArrayList<DTO_KhachHang> getAll() throws Exception{
        ArrayList<DTO_KhachHang> dsKhachHang = new ArrayList();
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_KhachHang_getAll }");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                String MaKhachHang = rs.getString("MaKhachHang");
                String TenKhachHang = rs.getString("TenKhachHang");
                String CMND = rs.getString("CMND");
                String DiaChi = rs.getString("DiaChi");
                String Email = rs.getString("Email");
                String SDT = rs.getString("SoDienThoai");
                String QuocTich = rs.getString("QuocTich");
                DTO_KhachHang khachhang = new DTO_KhachHang(MaKhachHang, TenKhachHang, CMND, DiaChi, Email, SDT, QuocTich);
                dsKhachHang.add(khachhang);
            }
            
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
        return dsKhachHang;
    }
    
    public static DTO_KhachHang getById(String maKhachHang) throws Exception{
        DTO_KhachHang khachhang = null;
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_KhachHang_getById(?) }");
            cs.setString("MaKhachHang", maKhachHang);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                String MaKhachHang = rs.getString("MaKhachHang");
                String TenKhachHang = rs.getString("TenKhachHang");
                String CMND = rs.getString("CMND");
                String DiaChi = rs.getString("DiaChi");
                String Email = rs.getString("Email");
                String SDT = rs.getString("SoDienThoai");
                String QuocTich = rs.getString("QuocTich");
                khachhang = new DTO_KhachHang(MaKhachHang, TenKhachHang, CMND, DiaChi, Email, SDT, QuocTich);
            }
            
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
        return khachhang;
    }
    
    public static String AutoGenerateID() throws Exception{
        Connection cn = ConnectDB.getConnect(); 
        String MaKhachHang = "";
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_KhachHang_AutoGenerateID }");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                MaKhachHang = rs.getString("MaKhachHang");
            }
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.getConnect();
        }
        return MaKhachHang;
    }
    
    public static void InsertNew(DTO_KhachHang khachHang) throws Exception{
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_KhachHang_Ins(?, ?, ?, ?, ?, ?, ?) }");
            cs.setString("MaKhachHang", khachHang.getMaKhachHang());
            cs.setString("TenKhachHang", khachHang.getTenKhachHang());
            cs.setString("CMND", khachHang.getCMND());
            cs.setString("Email", khachHang.getEmail());
            cs.setString("SoDienThoai", khachHang.getSoDienThoai());
            cs.setString("DiaChi", khachHang.getDiaChi());
            cs.setString("QuocTich", khachHang.getQuocTich());
            cs.execute();
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
    }
    
    public static void Update(DTO_KhachHang khachHang) throws Exception{
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_KhachHang_Upd(?, ?, ?, ?, ?, ?, ?) }");
            cs.setString("MaKhachHang", khachHang.getMaKhachHang());
            cs.setString("TenKhachHang", khachHang.getTenKhachHang());
            cs.setString("CMND", khachHang.getCMND());
            cs.setString("Email", khachHang.getEmail());
            cs.setString("SoDienThoai", khachHang.getSoDienThoai());
            cs.setString("DiaChi", khachHang.getDiaChi());
            cs.setString("QuocTich", khachHang.getQuocTich());
            cs.execute();
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
    }
    
    public static void Delete(String maKhachHang) throws Exception{
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_KhachHang_Del(?) }");
            cs.setString("MaKhachHang", maKhachHang);
            cs.execute();
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
    }
}
