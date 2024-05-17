/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.NhanVien;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface InterfaceNhanVien {
    List<NhanVien> getAll(); 
    List<NhanVien> getChucVu(String username); 

}
