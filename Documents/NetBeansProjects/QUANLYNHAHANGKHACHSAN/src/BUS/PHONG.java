/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DAO_Phong;
import DTO.DTO_Phong;
import java.util.ArrayList;

/**
 *
 * @author Ngoc Thang
 */
public class PHONG {
    public static ArrayList<DTO_Phong> getAll(){
        return DAO_Phong.getAll();
    }
    public static boolean setRoomStatus(String roomId, int status){
        return DAO_Phong.setRoomStatus(roomId, status);
    }
    
    public static String AutoGenerateID() throws Exception{
        return DAO_Phong.AutoGenerateID();
    }
    
    public static void InsertNew(DTO_Phong loaiPhong) throws Exception{
        DAO_Phong.InsertNew(loaiPhong);
    }
    
    public static void Update(DTO_Phong loaiPhong) throws Exception{
        DAO_Phong.Update(loaiPhong);
    }
    
    public static void Delete(String maPhong) throws Exception{
        DAO_Phong.Delete(maPhong);
    }
    
     public static DTO_Phong getById(String maPhong) throws Exception{
         return DAO_Phong.getById(maPhong);
     }
}
