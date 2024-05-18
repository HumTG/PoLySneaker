/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.HoaDonCT;
import Service.InterfaceHoaDonCT;
import Until.DBconnect;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class HoaDonCTRepository implements InterfaceHoaDonCT {

    @Override
    public List<HoaDonCT> getHDCT(int IDHoaDon) {
        String sql = "SELECT [IDHoaDonChiTiet]\n"
                + "      ,[ID_HoaDon]\n"
                + "      ,[ID_ChiTietSanPham]\n"
                + "      ,[Ma_HoaDonChiTiet]\n"
                + "      ,HoaDonChiTiet.SoLuong\n"
                + "      ,[DonGia]\n"
                + "      ,HoaDonChiTiet.TrangThai\n"
                + "	  ,TenSanPham\n"
                + "	  ,TenMauSac\n"
                + "	  ,TenChatLieu\n"
                + "	  ,Size\n"
                + "	  ,ChiTietSanPham.GiaBan\n"
                + "  FROM [dbo].[HoaDonChiTiet]\n"
                + "  JOIN ChiTietSanPham on ChiTietSanPham.IDChiTietSanPham = HoaDonChiTiet.ID_ChiTietSanPham\n"
                + "  JOIN SanPham on ChiTietSanPham.ID_SanPham = SanPham.IDSanPham\n"
                + "  JOIN MauSac on MauSac.IDMauSac = ChiTietSanPham.ID_MauSac\n"
                + "  JOIN ChatLieu on ChatLieu.IDChatLieu = ChiTietSanPham.ID_ChatLieu\n"
                + "  JOIN Size on Size.IDSize = ChiTietSanPham.ID_Size\n"
                + "  where ID_HoaDon = " + IDHoaDon + " ";
        List<HoaDonCT> lists = new ArrayList<>();
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonCT hdct = new HoaDonCT(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getBigDecimal(6),
                        rs.getBoolean(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getBigDecimal(12)
                );
                lists.add(hdct);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

}
