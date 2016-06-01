/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ConnectDB;
import DTO.DTO_LoaiPhong;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ngoc Thang
 */
public class DAO_LoaiPhong {
    public static ArrayList<DTO_LoaiPhong> getAll() throws Exception{
        ArrayList<DTO_LoaiPhong> dsLoaiPhong = new ArrayList();
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_LoaiPhong_getAll }");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                String MaLoaiPhong = rs.getString("MaLoaiPhong");
                String TenLoaiPhong = rs.getString("TenLoaiPhong");
                double DonGia = rs.getDouble("DonGia");
                String MoTa = rs.getString("MoTa");
                DTO_LoaiPhong loaiphong = new DTO_LoaiPhong(MaLoaiPhong,TenLoaiPhong, DonGia, MoTa);
                dsLoaiPhong.add(loaiphong);
            }
            
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
        return dsLoaiPhong;
    }
    
    public static DTO_LoaiPhong getById(String maLoaiPhong) throws Exception{
        DTO_LoaiPhong loaiphong = null;
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_LoaiPhong_getById(?) }");
            cs.setString("MaLoaiPhong", maLoaiPhong);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                String MaLoaiPhong = rs.getString("MaLoaiPhong");
                String TenLoaiPhong = rs.getString("TenLoaiPhong");
                double DonGia = rs.getDouble("DonGia");
                String MoTa = rs.getString("MoTa");
                loaiphong = new DTO_LoaiPhong(MaLoaiPhong,TenLoaiPhong, DonGia, MoTa);
            }
            
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
        return loaiphong;
    }
    
    public static String AutoGenerateID() throws Exception{
        Connection cn = ConnectDB.getConnect(); 
        String MaLoaiPhong = "";
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_LoaiPhong_AutoGenerateID }");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                MaLoaiPhong = rs.getString("MaLoaiPhong");
            }
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.getConnect();
        }
        return MaLoaiPhong;
    }
    
    public static void InsertNew(DTO_LoaiPhong loaiPhong) throws Exception{
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_LoaiPhong_Ins(?, ?, ?, ?) }");
            cs.setString("MaLoaiPhong", loaiPhong.getMaLoaiPhong());
            cs.setString("TenLoaiPhong", loaiPhong.getTenLoaiPhong());
            cs.setDouble("DonGia", loaiPhong.getDonGia());
            cs.setString("MoTa", loaiPhong.getMoTa());
            cs.execute();
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
    }
    
    public static void Update(DTO_LoaiPhong loaiPhong) throws Exception{
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_LoaiPhong_Upd(?, ?, ?, ?) }");
            cs.setString("MaLoaiPhong", loaiPhong.getMaLoaiPhong());
            cs.setString("TenLoaiPhong", loaiPhong.getTenLoaiPhong());
            cs.setDouble("DonGia", loaiPhong.getDonGia());
            cs.setString("MoTa", loaiPhong.getMoTa());
            cs.execute();
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
    }
    
    public static void Delete(String maLoaiPhong) throws Exception{
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_LoaiPhong_Del(?) }");
            cs.setString("MaLoaiPhong", maLoaiPhong);
            cs.execute();
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
    }
}
