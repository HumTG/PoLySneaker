/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.HoaDonCT;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface InterfaceHoaDonCT {
    List<HoaDonCT> getHDCT(int IDHoaDon); // lấy ra hóa đơn CT   
    void insertHDCT(int idHD , int idCTSP , int soLuongSPCT , BigDecimal donGia ); 
    BigDecimal getSumMonneyInHDCT(int iDHoaDon); 
    int getSLSP(int idSPCT , int idHoaDon);  // lấy ra số lượng sản phẩm chi tiết đã có trong hóa đơn chi tiết  
    void updateHDCT(int idSPCT , int idHoaDon, int soLuong , BigDecimal thanhTien) ; // cập nhật lại hóa đơn chi tiết 
    void deleteHDCT(int idHDCT); 
}
