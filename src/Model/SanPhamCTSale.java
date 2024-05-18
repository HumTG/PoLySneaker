/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigDecimal;

/**
 *
 * @author Admin
 */
public class SanPhamCTSale {
    
    private String maSPCT ; 
    private String tenSP ; 
    private String tenMauSac ; 
    private String tenThuongHieu; 
    private String tenChatLieu ; 
    private String tenXuatXu ; 
    private int size ; 
    private int soLuong ; 
    private BigDecimal giaBan ; 

    public SanPhamCTSale(String maSPCT, String tenSP, String tenMauSac, String tenThuongHieu, String tenChatLieu, String tenXuatXu, int size, int soLuong, BigDecimal giaBan) {
        this.maSPCT = maSPCT;
        this.tenSP = tenSP;
        this.tenMauSac = tenMauSac;
        this.tenThuongHieu = tenThuongHieu;
        this.tenChatLieu = tenChatLieu;
        this.tenXuatXu = tenXuatXu;
        this.size = size;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public SanPhamCTSale() {
    }

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    public String getTenThuongHieu() {
        return tenThuongHieu;
    }

    public void setTenThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }

    public String getTenXuatXu() {
        return tenXuatXu;
    }

    public void setTenXuatXu(String tenXuatXu) {
        this.tenXuatXu = tenXuatXu;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "SanPhamCTSale{" + "maSPCT=" + maSPCT + ", tenSP=" + tenSP + ", tenMauSac=" + tenMauSac + ", tenThuongHieu=" + tenThuongHieu + ", tenChatLieu=" + tenChatLieu + ", tenXuatXu=" + tenXuatXu + ", size=" + size + ", soLuong=" + soLuong + ", giaBan=" + giaBan + '}';
    }
    
    
    
    
    
}
