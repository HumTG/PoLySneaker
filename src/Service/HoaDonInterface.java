/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.HoaDon;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface HoaDonInterface {
    List<HoaDon> getDaTaHD();  // fill lên hóa đơn chờ 
    void createBill(int IDNhanVien); // tạo hóa đơn chờ mới 
}
