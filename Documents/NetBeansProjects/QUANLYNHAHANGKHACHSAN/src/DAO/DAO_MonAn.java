/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ConnectDB;
import DTO.DTO_MonAn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ngoc Thang
 */
public class DAO_MonAn {
    public static ArrayList<DTO_MonAn> getAll() throws Exception{
        ArrayList<DTO_MonAn> dsMonAn = new ArrayList();
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_MonAn_getAll }");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                String MaMonAn = rs.getString("MaMonAn");
                String TenMonAn = rs.getString("TenMonAn");
                double DonGia = rs.getDouble("DonGia");
                DTO_MonAn monan = new DTO_MonAn(MaMonAn,TenMonAn, DonGia);
                dsMonAn.add(monan);
            }
            
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
        return dsMonAn;
    }
    
    public static DTO_MonAn getById(String maMonAn) throws Exception{
        DTO_MonAn monan = null;
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_MonAn_getById(?) }");
            cs.setString("MaMonAn", maMonAn);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                String MaMonAn = rs.getString("MaMonAn");
                String TenMonAn = rs.getString("TenMonAn");
                double DonGia = rs.getDouble("DonGia");
                monan = new DTO_MonAn(MaMonAn,TenMonAn, DonGia);
            }
            
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
        return monan;
    }
    
    public static String AutoGenerateID() throws Exception{
        Connection cn = ConnectDB.getConnect(); 
        String MaMonAn = "";
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_MonAn_AutoGenerateID }");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                MaMonAn = rs.getString("MaMonAn");
            }
            
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.getConnect();
        }
        return MaMonAn;
    }
    
    public static void InsertNew(DTO_MonAn monAn) throws Exception{
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_MonAn_Ins(?, ?, ?) }");
            cs.setString("MaMonAn", monAn.getMaMonAn());
            cs.setString("TenMonAn", monAn.getTenMonAn());
            cs.setDouble("DonGia", monAn.getDonGia());
            cs.execute();
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
    }
    
    public static void Update(DTO_MonAn monAn) throws Exception{
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_MonAn_Upd(?, ?, ?) }");
            cs.setString("MaMonAn", monAn.getMaMonAn());
            cs.setString("TenMonAn", monAn.getTenMonAn());
            cs.setDouble("DonGia", monAn.getDonGia());
            cs.execute();
        } catch (SQLException ex) {
            System.err.print(ex);
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
    }
    
    public static void Delete(String maMonAn) throws Exception{
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_MonAn_Del(?) }");
            cs.setString("MaMonAn", maMonAn);
            cs.execute();
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
    }
}
