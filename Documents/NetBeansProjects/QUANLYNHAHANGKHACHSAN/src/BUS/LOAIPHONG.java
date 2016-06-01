/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DAO_LoaiPhong;
import DTO.DTO_LoaiPhong;
import java.util.ArrayList;

/**
 *
 * @author Ngoc Thang
 */
public class LOAIPHONG {
    public static ArrayList<DTO_LoaiPhong> getAll()throws Exception{
        return DAO_LoaiPhong.getAll();
    }
    
    public static String AutoGenerateID() throws Exception{
        return DAO_LoaiPhong.AutoGenerateID();
    }
    
    public static void InsertNew(DTO_LoaiPhong loaiPhong) throws Exception{
        DAO_LoaiPhong.InsertNew(loaiPhong);
    }
    
    public static void Update(DTO_LoaiPhong loaiPhong) throws Exception{
        DAO_LoaiPhong.Update(loaiPhong);
    }
    
    public static void Delete(String maLoaiPhong) throws Exception{
        DAO_LoaiPhong.Delete(maLoaiPhong);
    }
    
     public static DTO_LoaiPhong getById(String maLoaiPhong) throws Exception{
         return DAO_LoaiPhong.getById(maLoaiPhong);
     }
}
