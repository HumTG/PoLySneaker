/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.KhachHang;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface InterfaceKhachHang {

    List<KhachHang> getAllDataKH();

    List<KhachHang> findAllKH(String key);
    

}
