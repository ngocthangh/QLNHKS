/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DAO_DichVu;
import DTO.DTO_DichVu;
import java.util.ArrayList;

/**
 *
 * @author Ngoc Thang
 */
public class DICHVU {
    public static ArrayList<DTO_DichVu> getAll()throws Exception{
        return DAO_DichVu.getAll();
    }
    
    public static String AutoGenerateID() throws Exception{
        return DAO_DichVu.AutoGenerateID();
    }
    
    public static void InsertNew(DTO_DichVu monAn) throws Exception{
        DAO_DichVu.InsertNew(monAn);
    }
    
    public static void Update(DTO_DichVu monAn) throws Exception{
        DAO_DichVu.Update(monAn);
    }
    
    public static void Delete(String maDichVu) throws Exception{
        DAO_DichVu.Delete(maDichVu);
    }
    
    public static DTO_DichVu getById(String maDichVu) throws Exception{
        return DAO_DichVu.getById(maDichVu);
    }
}
