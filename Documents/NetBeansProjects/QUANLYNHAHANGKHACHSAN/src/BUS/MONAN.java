/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DAO_MonAn;
import DTO.DTO_MonAn;
import java.util.ArrayList;

/**
 *
 * @author Ngoc Thang
 */
public class MONAN {
    public static ArrayList<DTO_MonAn> getAll()throws Exception{
        return DAO_MonAn.getAll();
    }
    
    public static String AutoGenerateID() throws Exception{
        return DAO_MonAn.AutoGenerateID();
    }
    
    public static void InsertNew(DTO_MonAn monAn) throws Exception{
        DAO_MonAn.InsertNew(monAn);
    }
    
    public static void Update(DTO_MonAn monAn) throws Exception{
        DAO_MonAn.Update(monAn);
    }
    
    public static void Delete(String maMonAn) throws Exception{
        DAO_MonAn.Delete(maMonAn);
    }
    
     public static DTO_MonAn getById(String maMonAn) throws Exception{
         return DAO_MonAn.getById(maMonAn);
     }
}
