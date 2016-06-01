/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ConnectDB;
import DTO.DTO_DichVu;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ngoc Thang
 */
public class DAO_DichVu {
    public static ArrayList<DTO_DichVu> getAll() throws Exception{
        ArrayList<DTO_DichVu> dsDichVu = new ArrayList();
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_DichVu_getAll }");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                String MaDichVu = rs.getString("MaDichVu");
                String TenDichVu = rs.getString("TenDichVu");
                double DonGia = rs.getDouble("DonGia");
                DTO_DichVu dichvu = new DTO_DichVu(MaDichVu, TenDichVu, DonGia);
                dsDichVu.add(dichvu);
            }
            
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
        return dsDichVu;
    }
    
    public static DTO_DichVu getById(String maDichVu) throws Exception{
        DTO_DichVu dv = null;
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_DichVu_getById(?) }");
            cs.setString("MaDichVu", maDichVu);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                String MaDichVu = rs.getString("MaDichVu");
                String TenDichVu = rs.getString("TenDichVu");
                double DonGia = rs.getDouble("DonGia");
                dv = new DTO_DichVu(MaDichVu, TenDichVu, DonGia);
            }
            
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
        return dv;
    }
    
    public static String AutoGenerateID() throws Exception{
        Connection cn = ConnectDB.getConnect(); 
        String MaDichVu = "";
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_DichVu_AutoGenerateID }");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                MaDichVu = rs.getString("MaDichVu");
            }
            
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.getConnect();
        }
        return MaDichVu;
    }
    
    public static void InsertNew(DTO_DichVu dichVu) throws Exception{
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_DichVu_Ins(?, ?, ?) }");
            cs.setString("MaDichVu", dichVu.getMaDichVu());
            cs.setString("TenDichVu", dichVu.getTenDichVu());
            cs.setDouble("DonGia", dichVu.getDonGia());
            cs.execute();
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
    }
    
    public static void Update(DTO_DichVu dichVu) throws Exception{
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_DichVu_Upd(?, ?, ?) }");
            cs.setString("MaDichVu", dichVu.getMaDichVu());
            cs.setString("TenDichVu", dichVu.getTenDichVu());
            cs.setDouble("DonGia", dichVu.getDonGia());
            cs.execute();
        } catch (SQLException ex) {
            System.err.print(ex);
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
    }
    
    public static void Delete(String maDichVu) throws Exception{
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_DichVu_Del(?) }");
            cs.setString("MaDichVu", maDichVu);
            cs.execute();
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
    }
}
