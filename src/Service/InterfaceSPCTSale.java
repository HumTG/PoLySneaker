/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.SanPhamCTSale;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface InterfaceSPCTSale {

    List<SanPhamCTSale> getDataSPCT(String key);
    
    void updateSLSPCT(int idSPCT, int soLuong); 
    
    void addNumberProduct(int soLuong , int idSPCT); 
    
}
