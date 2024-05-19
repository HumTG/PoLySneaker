/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.SanPhamCTSale;
import Service.InterfaceSPCTSale;
import Until.DBconnect;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class SPCTSaleRepository implements InterfaceSPCTSale {

    @Override
    public List<SanPhamCTSale> getDataSPCT(String key) {
        String sql = "SELECT \n"
                + "Ma_ChiTietSanPham,\n"
                + "SanPham.TenSanPham,\n"
                + "MauSac.TenMauSac , \n"
                + "ThuongHieu.TenThuongHieu, \n"
                + "ChatLieu.TenChatLieu,\n"
                + "XuatXu.TenXuatXu,\n"
                + "Size.Size,\n"
                + "SoLuong,\n"
                + "GiaBan\n"
                + "FROM SanPham \n"
                + "JOIN ChiTietSanPham on ChiTietSanPham.ID_SanPham = SanPham.IDSanPham\n"
                + "JOIN MauSac on ChiTietSanPham.ID_MauSac = MauSac.IDMauSac\n"
                + "JOIN ThuongHieu on ThuongHieu.IDThuongHieu = SanPham.ID_ThuongHieu\n"
                + "JOIN ChatLieu on ChatLieu.IDChatLieu = ChiTietSanPham.ID_ChatLieu\n"
                + "JOIN XuatXu on ChiTietSanPham.ID_XuatXu = XuatXu.IDXuatXu\n"
                + "JOIN Size on ChiTietSanPham.ID_Size = Size.IDSize\n"
                + "WHERE Ma_ChiTietSanPham LIKE ? OR TenSanPham LIKE ?\n";

        List<SanPhamCTSale> lists = new ArrayList<>();
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + key + "%");
            ps.setString(2, "%" + key + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maSPCT = rs.getString("Ma_ChiTietSanPham");
                String tenSP = rs.getString("TenSanPham");
                String tenMauSac = rs.getString("TenMauSac");
                String tenThuongHieu = rs.getString("TenThuongHieu");
                String tenChatLieu = rs.getString("TenChatLieu");
                String tenXuatXu = rs.getString("TenXuatXu");
                int size = rs.getInt("Size");
                int soLuong = rs.getInt("SoLuong");
                BigDecimal giaBan = rs.getBigDecimal("GiaBan");

                SanPhamCTSale sp = new SanPhamCTSale(maSPCT, tenSP, tenMauSac, tenThuongHieu, tenChatLieu, tenXuatXu, size, soLuong, giaBan);
                lists.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    public static void main(String[] args) {
        SPCTSaleRepository spctsr = new SPCTSaleRepository();
        System.out.println(spctsr.getDataSPCT("Giày chạy bộ").toString());
    }

    @Override
    public void updateSLSPCT(int idSPCT, int soLuong) {
        String sql = "UPDATE ChiTietSanPham \n"
                + "SET SoLuong = " + soLuong + " \n"
                + "WHERE IDChiTietSanPham = " + idSPCT + " ";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNumberProduct(int soLuong, int idSPCT) {
        String sql = "UPDATE ChiTietSanPham SET SoLuong = SoLuong +  "+soLuong+" \n"
                + "WHERE IDChiTietSanPham = "+idSPCT+"";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
