/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.KhachHang;
import Service.InterfaceKhachHang;
import Until.DBconnect;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class KhachHangRepository implements InterfaceKhachHang {

    @Override
    public List<KhachHang> getAllDataKH() {
        String sql = "SELECT * FROM KhachHang";
        List<KhachHang> list = new ArrayList<>();
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getBoolean(7));
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<KhachHang> findAllKH(String key) {
        String sql = "SELECT * FROM KhachHang WHERE SDT = '"+key+"' or TenKhachHang = N'"+key+"' ";
        List<KhachHang> list = new ArrayList<>();
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getBoolean(7));
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        KhachHangRepository khachHangRepository = new KhachHangRepository();
        System.out.print(khachHangRepository.findAllKH("0868180010"));
    }

}
