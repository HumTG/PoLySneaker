/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.HoaDon;
import Service.HoaDonInterface;
import Until.DBconnect;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class HoaDonRepository implements HoaDonInterface {

    @Override
    public List<HoaDon> getDaTaHD() {
        String sql = "SELECT [IDHoaDon]\n"
                + "      ,[ID_KhachHang]\n"
                + "      ,[ID_NhanVien]\n"
                + "      ,[ID_KhuyenMai]\n"
                + "      ,[Ma_HoaDon]\n"
                + "      ,[TienSauGiamGia]\n"
                + "      ,[ThanhTien]\n"
                + "      ,[PhuongThucThanhToan]\n"
                + "      ,[NgayThanhToan]\n"
                + "      ,[HoaDon].TrangThai\n"
                + "	  ,TenKhachHang\n"
                + "	  ,HoTen\n"
                + "  FROM [dbo].[HoaDon] \n"
                + "  JOIN KhachHang on HoaDon.ID_KhachHang = KhachHang.IDKhangHang\n"
                + "  JOIN NhanVien on HoaDon.ID_NhanVien = NhanVien.IDNhanVien\n"
                + "  where HoaDon.TrangThai = 0 ";
        List<HoaDon> lists = new ArrayList<>();

        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idHoaDon = rs.getInt(1);
                int idKhachHang = rs.getInt(2);
                int idNhanVien = rs.getInt(3);
                int idKhuyenMai = rs.getInt(4);
                String maHoaDon = rs.getString(5);
                BigDecimal tienSauGiamGia = rs.getBigDecimal(6);
                BigDecimal thanhTien = rs.getBigDecimal(7);
                boolean phuongThucThanhToan = rs.getBoolean(8);
                Date ngayThanhToan = rs.getDate(9);
                boolean trangThai = rs.getBoolean(10);
                String tenKH = rs.getString(11);
                String tenNV = rs.getString(12);
                HoaDon hd = new HoaDon(idHoaDon, idKhachHang, idNhanVien, idKhuyenMai, maHoaDon, tienSauGiamGia, thanhTien, phuongThucThanhToan, ngayThanhToan, trangThai, tenKH, tenNV);
                lists.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lists;
    }

    @Override
    public void createBill(int IDNhanVien) {
        String sql = "INSERT INTO [dbo].[HoaDon]\n"
                + "           ([ID_KhachHang]\n"
                + "           ,[ID_NhanVien]\n"
                + "           ,[ID_KhuyenMai]\n"
                + "           ,[Ma_HoaDon]\n"
                + "           ,[TienSauGiamGia]\n"
                + "           ,[ThanhTien]\n"
                + "           ,[PhuongThucThanhToan]\n"
                + "           ,[NgayThanhToan]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (1\n"
                + "           ," + IDNhanVien + "\n"
                + "           ,NULL\n"
                + "           ,NULL\n"
                + "           ,0\n"
                + "           ,0\n"
                + "           ,NULL\n"
                + "           ,GETDATE()\n"
                + "           ,0)";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Cập nhật lại giá tiền trong hóa đơn 
    @Override
    public void updateSumMonneyBill(int idHoaDon, BigDecimal thanhTien) {
        String sql = "UPDATE HoaDon Set ThanhTien = "+thanhTien+" \n"
                + "WHERE IDHoaDon = "+idHoaDon+"";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
