/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Until.DBconnect;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class InformationDAO {

    // lấy ra ID nhân viên thông qua email nhân viên 
    public int getIDNVByEmail(String email) {
        int id = -1;
        String sql = "SELECT IDNhanVien FROM NhanVien where Email = '" + email + "' ";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    // lấy ra ID sản phẩm chi tiết thông qua mã sản phẩm chi tiết 
    public int getIDSPCTByMaSPCT(String maSPCT) {
        int id = -1;
        String sql = "SELECT IDChiTietSanPham FROM ChiTietSanPham WHERE Ma_ChiTietSanPham = '" + maSPCT + "' ";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    // lấy ra số lượng sản phẩm chi tiết thông qua id sản phẩm chi tiết 
    public int getSLSPCTbyIDSPCT(int idSPCT) {
        int sl = -1;
        String sql = "SELECT SoLuong\n"
                + "FROM ChiTietSanPham WHERE IDChiTietSanPham = "+idSPCT+"";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sl = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sl;
    }

    public static void main(String[] args) {
        InformationDAO x = new InformationDAO();
        int id = x.getIDNVByEmail("nguyenvana@example.com");
        System.out.println(id);
    }
}
