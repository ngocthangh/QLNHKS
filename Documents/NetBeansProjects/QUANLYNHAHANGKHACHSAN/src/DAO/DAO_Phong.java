/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ConnectDB;
import DTO.DTO_Phong;
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
public class DAO_Phong {
    public static ArrayList<DTO_Phong> getAll(){
        ArrayList<DTO_Phong> listRooms = new ArrayList();
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_Phong_getAll }");
            ResultSet rs = cs.executeQuery();
            if(rs != null)
            while(rs.next()){
                String MaPhong = rs.getString("MaPhong");
                String TenPhong = rs.getString("TenPhong");
                String Phong = rs.getString("LoaiPhong");
                int TinhTrang = rs.getInt("TinhTrang");
                DTO_Phong phong = new DTO_Phong(MaPhong,TenPhong, Phong, TinhTrang);
                listRooms.add(phong);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Phong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRooms;
    }
    
    public static boolean setRoomStatus(String roomId, int status){
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_Phong_UpdTinhTrang(?,?) }");
            cs.setInt("TinhTrang", status);
            cs.setString("MaPhong", roomId);
            cs.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Phong.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally{
            ConnectDB.getConnect();
        }
        return true;
    }
    
    public static DTO_Phong getById(String maPhong) throws Exception{
        DTO_Phong phong = null;
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_Phong_getById(?) }");
            cs.setString("MaPhong", maPhong);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                String MaPhong = rs.getString("MaPhong");
                String TenPhong = rs.getString("TenPhong");
                int TinhTrang = rs.getInt("TinhTrang");
                String LoaiPhong = rs.getString("LoaiPhong");
                phong = new DTO_Phong(MaPhong,TenPhong, LoaiPhong, TinhTrang);
            }
            
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
        return phong;
    }
    
    public static String AutoGenerateID() throws Exception{
        Connection cn = ConnectDB.getConnect(); 
        String MaPhong = "";
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_Phong_AutoGenerateID }");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                MaPhong = rs.getString("MaPhong");
            }
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.getConnect();
        }
        return MaPhong;
    }
    
    public static void InsertNew(DTO_Phong loaiPhong) throws Exception{
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_Phong_Ins(?, ?, ?, ?) }");
            cs.setString("MaPhong", loaiPhong.getMaPhong());
            cs.setString("TenPhong", loaiPhong.getTenPhong());
            cs.setString("LoaiPhong", loaiPhong.getLoaiPhong());
            cs.setInt("TinhTrang", loaiPhong.getTinhTrang());
            cs.execute();
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
    }
    
    public static void Update(DTO_Phong loaiPhong) throws Exception{
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_Phong_Upd(?, ?, ?, ?) }");
            cs.setString("MaPhong", loaiPhong.getMaPhong());
            cs.setString("TenPhong", loaiPhong.getTenPhong());
            cs.setString("LoaiPhong", loaiPhong.getLoaiPhong());
            cs.setInt("TinhTrang", loaiPhong.getTinhTrang());
            cs.execute();
        } catch (SQLException ex) {
            System.err.print(ex);
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
    }
    
    public static void Delete(String maPhong) throws Exception{
        Connection cn = ConnectDB.getConnect();
        try {
            CallableStatement cs = cn.prepareCall("{ call sp_Phong_Del(?) }");
            cs.setString("MaPhong", maPhong);
            cs.execute();
        } catch (SQLException ex) {
            throw ex;
        }
        finally{
            ConnectDB.Close();
        }
    }
}
