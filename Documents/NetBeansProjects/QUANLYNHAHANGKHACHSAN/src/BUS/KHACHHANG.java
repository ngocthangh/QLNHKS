/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DAO_KhachHang;
import DTO.DTO_KhachHang;
import java.util.ArrayList;

/**
 *
 * @author Ngoc Thang
 */
public class KHACHHANG {
    public static ArrayList<DTO_KhachHang> getAll()throws Exception{
        return DAO_KhachHang.getAll();
    }
    
    public static String AutoGenerateID() throws Exception{
        return DAO_KhachHang.AutoGenerateID();
    }
    
    public static void InsertNew(DTO_KhachHang khachHang) throws Exception{
        DAO_KhachHang.InsertNew(khachHang);
    }
    
    public static void Update(DTO_KhachHang khachHang) throws Exception{
        DAO_KhachHang.Update(khachHang);
    }
    
    public static void Delete(String maKhachHang) throws Exception{
        DAO_KhachHang.Delete(maKhachHang);
    }
    
     public static DTO_KhachHang getById(String maKhachHang) throws Exception{
         return DAO_KhachHang.getById(maKhachHang);
     }
}
